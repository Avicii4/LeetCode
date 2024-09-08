package problems.math;

public class LC7 {
    public static int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            return 0;
        }
            x = Math.abs(x);
        int flag = x > 0 ? 1 : -1;
        int curDigit;
        int curNumber = 0;
        while (x != 0) {
            curDigit = x % 10;
            if (curNumber < Integer.MAX_VALUE / 10 ||
                    (curNumber == Integer.MAX_VALUE / 10 && curDigit <= Integer.MAX_VALUE % 10)) {
                curNumber = curNumber * 10 + curDigit;
            } else {
                return 0;
            }
            x /= 10;
        }
        return curNumber * flag;
    }


    public static void main(String[] args) {
        // 2147483647
        //
        System.out.println(reverse(-2147483648));
    }
}
