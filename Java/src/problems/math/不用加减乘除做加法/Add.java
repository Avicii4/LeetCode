package problems.math.不用加减乘除做加法;

/**
 * Created by Harry Chou at 2019/7/5.
 */
public class Add {
    public int add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
