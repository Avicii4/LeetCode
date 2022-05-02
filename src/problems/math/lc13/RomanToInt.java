package problems.math.lc13;

/**
 * Created by Harry Chou at 2018/11/22.
 * Description: Given a roman numeral, convert it to an integer. Input is
 * guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int[] romanIndex = new int[256];
        romanIndex['I'] = 1;
        romanIndex['V'] = 5;
        romanIndex['X'] = 10;
        romanIndex['L'] = 50;
        romanIndex['C'] = 100;
        romanIndex['D'] = 500;
        romanIndex['M'] = 1000;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 >= s.length() || romanIndex[s.charAt(i + 1)] <= romanIndex[s.charAt(i)]) {
                ans += romanIndex[s.charAt(i)];
            } else {
                ans -= romanIndex[s.charAt(i)];
            }
        }
        return ans;
    }
}