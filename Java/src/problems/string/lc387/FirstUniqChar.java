package problems.string.lc387;

import java.util.Arrays;

/**
 * Created by Harry Chou at 2018/10/23.
 * Description: Given a string, find the first non-repeating character in it and
 * return it's index. If it doesn't exist, return -1.
 */
public class FirstUniqChar {
    public int find(String s) {
        int[] nums = new int[256];
        int index = -1;
        Arrays.fill(nums, 0);
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}