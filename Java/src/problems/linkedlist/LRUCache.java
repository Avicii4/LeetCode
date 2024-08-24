package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

// LeetCode 146 设计一个LRU
public class LRUCache {

    // LRU当前的容量
    private int capacity;
    // LRU辅助需要的map
    private Map<Integer, CacheNode> map;
    // 最远使用和最近使用
    private CacheNode least;
    private CacheNode most;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        least = new CacheNode(-1, -1);
        most = new CacheNode(-1, -1);
        least.next = most; // 指向最久远的节点
        most.prev = least;  // 指向最近的节点
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CacheNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            add(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CacheNode curNode = map.get(key);
            curNode.value = value;
            curNode.prev.next = curNode.next;
            curNode.next.prev = curNode.prev;
            add(curNode);
            map.put(key, curNode);
        } else {
            if (map.size() == capacity) {
                CacheNode goNode = least.next;
                eliminate();
                map.remove(goNode.key);
            }
            CacheNode newNode = new CacheNode(key, value);
            map.put(key, newNode);
            add(newNode);
        }
    }

    // 节点添加到most节点前面
    private void add(CacheNode curNode) {
        most.prev.next = curNode;
        curNode.next = most;
        curNode.prev = most.prev;
        most.prev = curNode;
    }

    // 去掉最久远的节点
    private void eliminate() {
        least.next.next.prev = least;
        least.next = least.next.next;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6); // 缓存是 {2=6}
        System.out.println(lRUCache.get(1));  // 6
        lRUCache.put(1, 5); // 缓存是 {2=6, 1=5}
        lRUCache.put(1, 2); // 缓存是 {2=6, 1=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        System.out.println(lRUCache.get(2));
    }
}

class CacheNode {
    public int key;
    public int value;
    public CacheNode prev;
    public CacheNode next;

    public CacheNode(int k, int v) {
        this.key = k;
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}