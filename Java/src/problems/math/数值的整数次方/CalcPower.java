/**
 * Created by Harry Chou at 2019/4/27.
 */
public class CalcPower {
    public double power(double base, int exponent) {
        int e = Math.abs(exponent);
        if (e == 0 && base != 0) {
            return 1;
        }
        double result = 1;
        while (e >= 1) {
            e--;
            result *= base;
        }
        return exponent >= 0 ? result : (1 / result);
    }
}
