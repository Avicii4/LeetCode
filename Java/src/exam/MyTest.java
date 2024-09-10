package exam;

// 快速

import java.util.ArrayList;
import java.util.List;


public class MyTest {
    public static List<String> allSeq(String s, int m) {
        boolean[] v = new boolean[s.length()];
        List<String> res = new ArrayList<>();
        dfs(new StringBuffer(), v, res, s, m);
        return res;
    }

    private static void dfs(StringBuffer cur, boolean[] visited, List<String> res, String s, int m) {
        if (cur.length() == m) {
            res.add(cur.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                StringBuffer tmp = new StringBuffer(cur);
                tmp.append(s.charAt(i));
                dfs(tmp, visited, res, s, m);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        String a = "abc";
        int m=2;
        System.out.println(allSeq(a,m));
    }


}
