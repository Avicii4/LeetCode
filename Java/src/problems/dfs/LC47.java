package problems.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    List<List<Integer>> res;
    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);   // 排序是剪枝的前提
        dfs(curList, nums);
        return res;
    }

    private void dfs(List<Integer> curList, int[] nums) {
        if (curList.size() == nums.length) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && visit[i - 1]) {
                continue;
            } else if (!visit[i]) {
                curList.add(nums[i]);
                visit[i] = true;
                dfs(curList, nums);
                curList.remove(curList.size() - 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 1, 0};
        System.out.println(new LC47().permuteUnique(a));

    }
}
