package problems.dfs;

import java.util.ArrayList;
import java.util.List;

public class LC77 {
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] visit;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        visit = new boolean[n + 1];
        dfs(1, n, k);
        return res;
    }

    private void dfs(int curIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = curIndex; i <= n; i++) {
            if (!visit[i]) {
                path.add(i);
                visit[i] = true;
                dfs(i+1, n, k);
                visit[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC77().combine(4, 2));
    }
}
