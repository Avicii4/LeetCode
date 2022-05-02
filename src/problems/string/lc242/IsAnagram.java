package problems.string.lc242;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Harry Chou at 2018/10/25.
 * Description: Given two strings s and t , write a function to determine if t
 * is an anagram of s.
 */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        List<String> sList = Arrays.asList(s.split(""));
        List sToList = new ArrayList(sList);
        List<String> tList = Arrays.asList(t.split(""));
        List tToList = new ArrayList(tList);
        if (sToList.size() != tToList.size())
            return false;
        Collections.sort(sToList);
        Collections.sort(tToList);
        for (int i = 0; i < sToList.size(); i++)
            if (!sToList.get(i).equals(tToList.get(i)))
                return false;
        return true;
    }
}