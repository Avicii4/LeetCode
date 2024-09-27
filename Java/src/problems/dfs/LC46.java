package problems.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 求数组全排列，且数组不含重复元素
 */
public class LC46 {
    // 交换法
    public static List<List<Integer>> permute_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(0, nums.length, output, res);
        return res;
    }

    private static void backtrack(int index, int n, List<Integer> output, List<List<Integer>> res) {
        if (index == n) {
            res.add(new ArrayList<>(output));
        } else {
            for (int i = index; i < n; i++) {
                Collections.swap(output, index, i);
                backtrack(index + 1, n, output, res);
                Collections.swap(output, index, i);  // 恢复
            }
        }
    }


    // 用额外的visited数组
    public static List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        process(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private static void process(int[] nums, boolean[] visited, List<Integer> curList, List<List<Integer>> res) {
        if (curList.size() == nums.length) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curList.add(nums[i]);
                visited[i] = true;
                process(nums, visited, curList, res);
                visited[i] = false;
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(permute_1(arr));
    }
}
