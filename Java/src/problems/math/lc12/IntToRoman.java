package problems.math.lc12;

/**
 * Created by Harry Chou at 2018/11/23.
 * Description: Given an integer, convert it to a roman numeral. Input is
 * guaranteed to be within the range from 1 to 3999.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        String[] key = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String ans = new String();
        for (int i = 0; i < 13; i++) {
            if (num < value[i])
                continue;
            while (num >= value[i]) {
                num -= value[i];
                ans += key[i];
            }
        }
        return ans;
    }
}