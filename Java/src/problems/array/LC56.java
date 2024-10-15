package problems.array;

import java.util.*;

public class LC56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        int idx = 1;
        while (!stack.isEmpty() && idx < intervals.length) {
            int[] cur = stack.peek();
            if (cur[1] < intervals[idx][0]) {
                stack.add(intervals[idx]);
            } else {
                stack.pop();
                stack.add(new int[]{cur[0], Math.max(intervals[idx][1],cur[1])});
            }
            idx++;
        }
        int[][] res = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(a);
        for(int[] i:res){
            System.out.println(Arrays.toString(i));
        }
    }
}
