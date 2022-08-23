package problems.math.lc29;

/**
 * Created by Harry Chou at 2019/01/23.
 * Description:Given two integers dividend and divisor, divide two integers
 * without using multiplication, division and mod operator.Return the quotient
 * after dividing dividend by divisor.The integer division should truncate
 * toward zero.
 */
class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend < 0) ^ (divisor < 0) ? -1 : 1);

        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int result = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long mul = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            result += mul;
        }
        return result*sign;
    }
}