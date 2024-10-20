package problems.array;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            int number = i;
            List<Integer> curList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((number >> j) & 1) == 1) {
                    curList.add(nums[j]);
                }
            }
            res.add(curList);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }
}
