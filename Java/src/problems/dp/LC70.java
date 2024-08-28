package problems.dp;

public class LC70 {
    public static int climbStairs(int n) {
        // 用长度固定为2的数组，存储和计算斐波那契数列
        int[] arr = new int[]{1, 1};
        int index = 0;
        while (n > 0) {
            arr[index] = arr[0] + arr[1];
            index = (index + 1) % 2;
            n--;
        }
        return arr[index];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(climbStairs(i));
        }
    }
}
