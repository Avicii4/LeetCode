package test.dp;

public class StringConverter {

    // 将字符串转换为整数
    public static int convert2string(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return convert2stringProcess(str.toCharArray(), 0);
    }

    // 暴力递归处理
    private static int convert2stringProcess(char[] arr, int idx) {
        if (idx == arr.length) { // 基础条件，遍历到最后一个元素之后
            return 1;
        }

        if (arr[idx] == '0') { // '0' 没有对应的字母
            return 0;
        }

        if (arr[idx] == '1') { // '1' 的两种可能性
            int res = convert2stringProcess(arr, idx + 1); // 单个转换
            if (idx + 1 < arr.length) {
                res += convert2stringProcess(arr, idx + 2); // 两个合并转换
            }
            return res;
        }

        if (arr[idx] == '2') { // '2' 的两种可能性
            int res = convert2stringProcess(arr, idx + 1); // 单个转换
            if (idx + 1 < arr.length && arr[idx + 1] >= '0' && arr[idx + 1] <= '6') {
                res += convert2stringProcess(arr, idx + 2); // 两个合并转换
            }
            return res;
        }

        // 其他数字单独转换
        return convert2stringProcess(arr, idx + 1);
    }


    // 动态规划解法
    public static int dpConvert2String(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] arr = str.toCharArray();
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                dp[i] = 0;   // 没有对应字母，无法转化
            } else if (arr[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < n) {
                    dp[i] += dp[i + 2];
                }
            } else if (arr[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < n && (arr[i + 1] >= '0' && arr[i + 1] <= '6')) {
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String testString = "121811120";
        System.out.println("Number of ways to convert: " + convert2string(testString));
        System.out.println("Number of ways to convert: " + dpConvert2String(testString));
    }


}
