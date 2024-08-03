package test;

public class KMPAlgorithm {

    // 计算 nextval 数组
    public static int[] computeNextval(String pattern) {
        int m = pattern.length();
        int[] nextval = new int[m];
        nextval[0] = 0;  // 第一个字符的 nextval 值为 0
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = nextval[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (i + 1 < m && pattern.charAt(i + 1) == pattern.charAt(j)) {
                nextval[i] = nextval[j - 1];
            } else {
                nextval[i] = j;
            }
        }
        return nextval;
    }

    // KMP 字符串匹配算法
    public static int kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] nextval = computeNextval(pattern);
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = nextval[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;  // 找到匹配，返回起始位置
                // j = nextval[j - 1];  // 如果要继续查找下一处匹配，则需要这行
            }
        }
        return -1;  // 未找到匹配
    }

    public static void main(String[] args) {
        // 测试示例
        String text = "ababcabcabababd";
        String pattern = "ababd";
        int result = kmpSearch(text, pattern);
        System.out.println("Pattern found at index: " + result);  // 输出: Pattern found at index: 10
    }
}

