package structure;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集
 */
public class UnionFindSet<V> {
    // 节点值-节点对象的映射关系，一经初始化就不会改变
    public HashMap<V, MyNode<V>> nodes;
    // 记录节点和父母，注意里面存的不一定就是最高的祖先
    public HashMap<MyNode<V>, MyNode<V>> parentMap;
    // 记录每个独立集合的节点数目,只有是祖先（最高的父母节点）的那些节点才会出现在这里
    public HashMap<MyNode<V>, Integer> sizeMap;

    public UnionFindSet(List<V> values) {
        // 初始化时，所有节点自成一个集合
        for (V val : values) {
            MyNode<V> node = new MyNode<>(val);
            nodes.put(val, node);
            parentMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    // 查看两节点是否属于同一集合
    public boolean isSameSet(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return false;
        }
        return findParent(nodes.get(a)) == findParent(nodes.get(b));
    }

    // 合并两个节点所属的集合
    public void union(V a, V b) {
        if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
            return;
        }
        MyNode<V> aParent = findParent(nodes.get(a));
        MyNode<V> bParent = findParent(nodes.get(b));
        if (aParent != bParent) {
            int aSize = sizeMap.get(aParent);
            int bSize = sizeMap.get(bParent);
            if (aSize >= bSize) {
                // 让b接到a的下面
                parentMap.put(bParent, aParent);
                sizeMap.put(aParent, aSize + bSize);
                sizeMap.remove(bParent);
            } else {
                // 让a接到b的下面
                parentMap.put(aParent, bParent);
                sizeMap.put(bParent, aSize + bSize);
                sizeMap.remove(aParent);
            }
        }
    }

    private MyNode<V> findParent(MyNode<V> cur) {
        Stack<MyNode<V>> path = new Stack<>();
        // 获取最高的那个祖先
        while (cur != parentMap.get(cur)) {
            path.push(cur);
            cur = parentMap.get(cur);
        }
        // 沿途节点全部优化
        while (!parentMap.isEmpty()) {
            parentMap.put(path.pop(), cur);
        }
        return cur;
    }

}

class MyNode<V> {
    V value;

    public MyNode(V v) {
        value = v;
    }
}