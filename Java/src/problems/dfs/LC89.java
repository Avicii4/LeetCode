package problems.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));   // 倒序地在二进制最前面加1
            }
            head <<= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(grayCode(10));
    }
}
