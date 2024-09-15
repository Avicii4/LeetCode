package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

// LeetCode 460
public class LFUCache {

    int capacity;
    // 存储当前最小的频率值，在淘汰的时候才知道去哪个链表淘汰
    int curMinFreq;
    // 存储key-value数据
    Map<Integer, Integer> kvMap;
    // 存储key-频率数据
    Map<Integer, Integer> freqMap;
    // 所有相同频率的数据存在一个链表上，所以这里存频率-链表关系
    Map<Integer, LFULinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        curMinFreq = 0;
        kvMap = new HashMap<>();
        freqMap = new HashMap<>();
        listMap = new HashMap<>();
    }


    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            System.out.println(-1);
            return -1;
        }
        visit(key);
        int res = kvMap.get(key);
        System.out.println(res);
        return res;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!kvMap.containsKey(key) && kvMap.size() == capacity) {
            // 需要淘汰最小频次链表上的最久未被访问的节点
            int k = listMap.get(curMinFreq).popLeast();
            kvMap.remove(k);
            freqMap.remove(k);
        }
        kvMap.put(key, value);
        visit(key);
        curMinFreq = Math.min(curMinFreq, freqMap.get(key));
    }

    // 访问了一次key，则调用此方法
    private void visit(int key) {
        int cnt = 0;
        if (!freqMap.containsKey(key)) {
            freqMap.put(key, 1);
        } else {
            cnt = freqMap.get(key);
        }
        if (listMap.containsKey(cnt)) {
            listMap.get(cnt).pop(key);  // 从旧频率的链表中弹出
        }
        if (listMap.containsKey(cnt + 1)) {
            listMap.get(cnt + 1).addMost(key);  // 加入新频率的链表中
        } else {
            LFULinkedList newList = new LFULinkedList();
            newList.addMost(key);
            listMap.put(cnt + 1, newList);
        }
        if (curMinFreq == cnt && listMap.getOrDefault(cnt, new LFULinkedList()).map.isEmpty()) {
            // 这次访问导致全局最小频次+1
            curMinFreq++;
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1);
        lfu.put(3, 3);
        lfu.get(2);
        lfu.get(3);
        lfu.put(4, 4);
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
    }
}


class LFULinkedList {
    LFUNode least;
    LFUNode most;
    Map<Integer, LFUNode> map;

    LFULinkedList() {
        least = new LFUNode(0);
        most = new LFUNode(0);
        least.next = most;
        most.prev = least;
        map = new HashMap<>();
    }

    // 根据key弹出链表
    public void pop(int key) {
        if (map.containsKey(key)) {
            LFUNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(key);
        }
    }

    // key加入最近访问的位置
    public void addMost(int key) {
        LFUNode node = new LFUNode(key);
        node.prev = most.prev;
        node.next = most;
        most.prev.next = node;
        most.prev = node;
        map.put(key, node);
    }

    public int popLeast() {
        int key = least.next.val;
        pop(least.next.val);
        return key;
    }
}


class LFUNode {
    int val;
    LFUNode prev;
    LFUNode next;

    LFUNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}