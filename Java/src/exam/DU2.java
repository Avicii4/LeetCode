package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DU2 {
    public static int maxSubstring(String s, int n, int k) {
        if(k>n){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int maxCount = 0;
        for (int freq : map.values()) {
            maxCount = Math.max(maxCount, freq / k);
        }
        return maxCount;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(maxSubstring(s, n, k));
    }
}
