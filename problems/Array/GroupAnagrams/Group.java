import java.util.*;

/**
 * Created by Harry Chou at 2018/12/31.
 * Description: Given an array of strings, group anagrams together.
 */
public class Group {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] elem = strs[i].toCharArray();
            Arrays.sort(elem);
            String keyStr = String.valueOf(elem);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
