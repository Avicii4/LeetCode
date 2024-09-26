package problems.dp;

import java.util.HashMap;
import java.util.Map;

public class LC343 {
    // 方法一：暴力递归
    public static int integerBreak_1(int n) {
        return force(n, n);
    }

    private static int force(int cur, int n) {
        if (cur == 1) {
            return 1;
        }
        // 如果原来的数n=3，那么我必须对其进行分解，分解后最大乘积是2
        // 如果原来的数n=4，那么n可以被分成1+3，再对3调用force()的时候，发现3不分解反而乘积更大，所以res就是3
        int res = cur == n ? 0 : cur;
        for (int i = 1; i < cur; i++) {
            int val = force(i, n) * force(cur - i, n);
            res = Math.max(val, res);
        }
        return res;
    }

    // 方法二：暴力递归改成有缓存的形式
    public static int integerBreak_2(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        return dfsCache(n, n, dp);
    }

    private static int dfsCache(int cur, int n, Map<Integer, Integer> dp) {
        // 缓存里有就直接返回
        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }
        int res = cur == n ? 0 : cur;
        for (int i = 1; i < cur; i++) {
            int val = dfsCache(i, n, dp) * dfsCache(cur - i, n, dp);
            res = Math.max(val, res);
        }
        // 存入dp中
        dp.put(cur, res);
        return res;
    }

    // 方法三：换成典型的dp写法，其时空复杂度和方法二是一样的
    public static int integerBreak_3(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        for (int cur = 2; cur <= n; cur++) {
            int res = cur == n ? 0 : cur;
            for (int i = 1; i < cur; i++) {
                // 因为从下到大遍历，这里可以保证i与cur-i都存在于dp中
                int val = dp.get(i) * dp.get(cur - i);
                res = Math.max(res, val);
            }
            dp.put(cur, res);
        }
        return dp.get(n);
    }


    public static void main(String[] args) {
        int number = 13;
        System.out.println(integerBreak_2(number));
        System.out.println(integerBreak_3(number));
    }
}
