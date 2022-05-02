package problems.array.lc40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Harry Chou at 2019/02/03.
 * Description: Given a collection of candidate numbers (candidates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.Each number in candidates may only be used
 * once in the combination.
 */
class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(candidates);
        trace(list, item, candidates, target, 0);
        return list;
    }

    public void trace(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int num) {
        if (target == 0) {
            list.add(temp);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        while (num < candidates.length && candidates[num] <= target) {
            List<Integer> item = new ArrayList<>(temp);
            item.add(candidates[num]);
            trace(list, item, candidates, target - candidates[num], num + 1);
            int flag = num;
            while (flag + 1 < candidates.length && candidates[num] == candidates[flag + 1]) {
                flag++;
            }
            if (flag > num) {
                num = flag + 1;
                if (flag == candidates.length - 1) {
                    break;
                }
            } else {
                num++;
            }
        }
    }
}