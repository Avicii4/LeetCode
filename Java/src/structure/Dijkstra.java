package structure;

import java.util.HashMap;

// no negative weight
public class Dijkstra {

    public static class NodeRecord {
        public Node node;
        public int distance;

        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // 定制的小根堆的视线
    public static class NodeHeap {
        // 实际的堆结构
        private Node[] nodes;
        // 用于记录节点-堆中位置的映射，如果节点进入过堆，但后来被弹出，则对应记录是-1
        private HashMap<Node, Integer> heapIndexMap;
        //用于记录初始节点到Node的距离
        private HashMap<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (inHeap(node)) {
                //在堆中的节点，需要去heapify更新一下
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                //这里更新距离，要么没更新，要么变小了  需要往上走
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                //新建节点，先挂在size位置上，然后调整堆
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
            //剩下的就是进来过但没在堆上的，不用管
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            //堆去掉堆顶  把最后一个换上来
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);  // 置为-1，表示不在堆中了
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null;
            heapify(0, --size);
            return nodeRecord;
        }

        private void insertHeapify(Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left])
                        ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        // 判断Node有没有进来过
        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);
        }

        // 判断Node是否在堆上
        // 如果进来了又弹出，会把value置为-1，此时节点进过堆但不算在堆上
        private boolean inHeap(Node node) {
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
    }

    // 用小根堆优化后的算法
    public static HashMap<Node, Integer> dijkstra(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        // 没出现过就add 出现过如果比原来的小就update 如果比原来的大就ignore
        // 还有个隐藏功能，不会去看那些已经看过的节点，因为一定不会更小
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}

