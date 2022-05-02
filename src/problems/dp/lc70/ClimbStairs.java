package problems.dp.lc70;

/**
 * Created by Harry Chou at 2018/11/13.
 * Description: You are climbing a stair case. It takes n steps to reach to the
 * top.Each time you can either climb 1 or 2 steps. In how many distinct ways
 * can you climb to the top?
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int ans = 0;
        if (n == 1)
            ans = 1;
        if (n == 2)
            ans = 2;
        if (n > 2) {
            int[] result = new int[n];
            result[0] = 1;
            result[1] = 2;
            for (int i = 2; i < result.length; i++)
                result[i] = result[i - 1] + result[i - 2];
            ans = result[result.length - 1];
        }
        return ans;
    }
}