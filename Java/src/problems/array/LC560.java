package problems.array;

import java.util.HashMap;
import java.util.Map;

public class LC560 {
    public int subarraySum_1(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int counter = 0;
        for (int step = 1; step <= n; step++) {
            for (int i = 0; i <= n - step; i++) {
                if (preSum[i + step] - preSum[i] == k) {
                    counter++;
                }
            }
        }
        return counter;
    }


    public int subarraySum_2(int[] nums, int k) {
        // 存储前缀和-出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curSum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            // 到当前这个位置，前面的数组头部可以提供多少个 curSum - k?
            // 因为我用curSum减去它们提供的 curSum - k,就可以得到和为k的子数组了
            if (map.containsKey(curSum - k)) {
                res += map.get(curSum - k);
            }
            if (map.containsKey(curSum)) {
                map.put(curSum, map.get(curSum) + 1);
            } else {
                map.put(curSum, 1);
            }
        }
        return res;

    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1};
        System.out.println(new LC560().subarraySum_2(a, 2));
    }
}
