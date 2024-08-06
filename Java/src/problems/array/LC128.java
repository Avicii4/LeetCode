package problems.array;

import java.util.*;

// 最长连续序列
public class LC128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                // num是序列的开头
                int cur = num;
                int curLength = 0;
                while (set.contains(cur)) {
                    curLength++;
                    cur++;
                }
                res = Math.max(curLength, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(arr));
    }

}
