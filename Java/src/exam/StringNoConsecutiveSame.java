package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 有n个字符串，每次从中各取一个组成一个字符串，
 * 要求组成的串不能有连续相同字符，问符合要求的字符串个数
 * 例如输入：
 * 2
 * ab
 * bcd
 * 输出： 5
 */
public class StringNoConsecutiveSame {
    static int mod = 1000000007;
    static HashMap<Pair<Integer, Character>, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> stores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stores.add(scanner.next());
        }

        System.out.println(dfs(0, '\0', stores));
    }

    static int dfs(int i, char c, ArrayList<String> stores) {
        int n = stores.size();
        if (i == n) {
            return 1;
        }
        if (dp.containsKey(new Pair<>(i, c))) {
            return dp.get(new Pair<>(i, c));
        }
        int res = 0;
        for (int j = 0; j < stores.get(i).length(); j++) {
            if (stores.get(i).charAt(j) != c) {
                res += dfs(i + 1, stores.get(i).charAt(j), stores);
                res %= mod;
            }
        }
        dp.put(new Pair<>(i, c), res);
        return res;
    }

    static class Pair<X, Y> {
        X first;
        Y second;

        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;
            Pair<?, ?> p = (Pair<?, ?>) obj;
            return this.first.equals(p.first) && this.second.equals(p.second);
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }
    }
}
