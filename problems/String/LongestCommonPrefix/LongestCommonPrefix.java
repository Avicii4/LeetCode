/**
 * Created by Harry Chou at 2018/10/30.
 * Description: Write a function to find the longest common prefix string
 * amongst an array of strings. If there is no common prefix, return an empty
 * string "".
 */
public class LongestCommonPrefix {
    public String findPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int index = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char flag = strs[0].charAt(index);
            // Originally I wrote this for loop like:
            // for(String str: strs) {...}
            // which is also feasible but costs more time.
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || flag != strs[j].charAt(index))
                    return strs[0].substring(0, index);
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}