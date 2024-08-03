package test;

import java.util.*;

import test.sort.SortingValidator;

public class AllTests {
    public static List<List<String>> group(String[] strs) {
        Map<String,List<String>> map =new HashMap<>();
        for(String string:strs){
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String keyString=new String(arr);
            List<String> list = map.getOrDefault(keyString, new ArrayList<>());
            list.add(string);
            map.put(keyString,list);
        }
        return new ArrayList<>(map.values());


    }

    public static void main(String[] args) {
        String[] strs=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(group(strs));


    }
}
