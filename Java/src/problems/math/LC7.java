package problems.math;

public class LC7 {
    public static int reverse(int x) {
        int curNumber = 0;
        while (x != 0) {
            int temp = curNumber * 10 + x % 10;
            if (temp / 10 != curNumber) {
                return 0;
            }
            curNumber = temp;
            x /= 10;
        }
        return curNumber;
    }


    public static void main(String[] args) {
        // 2147483647
        System.out.println(reverse(-2147483648));
    }
}
