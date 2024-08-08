package test;

import java.util.*;

public class AllTests {
    public static List<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String keyString = new String(arr);
            List<String> list = map.getOrDefault(keyString, new ArrayList<>());
            list.add(string);
            map.put(keyString, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void queueTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<>(10, Comparator.reverseOrder()); // 默认是大顶堆
        int[] arr = new int[]{3,7,1,0,9,19,87,0};
        for (int num:arr){
            queue.offer(num);
            //if(queue.size()>4){
            //    queue.poll();
            //}
        }
        System.out.println(queue);
        System.out.println(queue.poll());

    }

    public static void main(String[] args) {
        //String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(group(strs));
        queueTest();

    }
}
