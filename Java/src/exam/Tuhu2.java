package exam;

import java.util.*;

public class Tuhu2 {
    /**
     * @param n            int整型 服务总数
     * @param points       int整型一维数组 服务对应积分
     * @param dependencies int整型二维数组 服务依赖
     * @param k            int整型 可买服务数量
     * @return int整型
     * <p>
     * 贪心，优先队列里存储可以做的任务+分数，每次就做分数最高的哪个
     */
    public int maxPoints(int n, int[] points, int[][] dependencies, int k) {
        // write code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        //boolean[] isDependent = new boolean[n];
        for (int[] d : dependencies) {
            // d[0] 依赖 d[1]
            if (!map.containsKey(d[0])) {
                map.put(d[0], new ArrayList<>());
            }
            map.get(d[0]).add(d[1]);
        }
        PriorityQueue<Service> heap = new PriorityQueue<>((o1, o2) -> o2.point - o1.point);
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                heap.offer(new Service(i, points[i]));
            }
        }
        k = Math.min(k, n);
        int res = 0;
        while (!heap.isEmpty() && k > 0) {
            Service s = heap.poll();
            res += s.point;
            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()) {
                int key = it.next();
                // 删除每个列表中存有的s.index
                map.get(key).removeIf(val -> val == s.index);
                if (map.get(key).isEmpty()) {
                    it.remove();
                    heap.offer(new Service(key, points[key]));
                }
            }
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] ps = {8, 3, 7, 5, 6, 2};
        int[][] d = {{1, 0}, {2, 1}, {3, 1}, {4, 2}};
        int k = 3;
        System.out.println(new Tuhu2().maxPoints(n, ps, d, k));
    }

    class Service {
        public int index;
        public int point;

        Service(int index, int point) {
            this.index = index;
            this.point = point;
        }
    }

}
