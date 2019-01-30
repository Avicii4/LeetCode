/**
 * Created by Harry Chou at 2019/01/30.
 * Description: Given a set of candidate numbers (candidates) (without
 * duplicates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.The same repeated
 * number may be chosen from candidates unlimited number of times.
 */
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        Arrays.sort(candidates);
        trace(list, item, candidates, target, 0);
        return list;
    }

    private void trace(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int num) {
        if (target == 0) {
            list.add(temp);
            return;
        }
        if (target < candidates[0]) {
            return;
        }
        for (int i = num; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                List<Integer> item = new ArrayList<Integer>(temp);
                item.add(candidates[i]);
                trace(list, item, candidates, target - candidates[i], i);
            }
        }
    }
}