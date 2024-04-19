package exam;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param k int整型
     * @return int整型
     */
    public int maxLen(String s, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (curLen > 0) {
                    pq.offer(curLen);
                    curLen = 0;
                }
            } else {
                curLen++;
            }
        }
        if (curLen > 0) {
            pq.offer(curLen);
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                int popValue = pq.poll();
                if (popValue == 1) {
                    continue;
                }
                if (popValue == 2) {
                    pq.offer(1);
                    continue;
                }
                if (popValue % 2 == 1) {
                    pq.offer((popValue - 1) / 2);
                    pq.offer((popValue - 1) / 2);
                } else {
                    pq.offer(popValue / 2);
                    pq.offer((popValue - 2) / 2);
                }
            }
        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxLen("101110110", 1));
    }
}