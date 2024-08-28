package problems.dp;


import java.util.*;

public class LC502 {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // 根据成本建立小根堆
        PriorityQueue<int[]> minCost = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            minCost.offer(new int[]{capital[i], profits[i]});
        }
        // 根据利润建立大根堆
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < k; i++) {
            // 现有的本钱w可以进行哪些项目，这些项目全部进大根堆
            while (!minCost.isEmpty() && minCost.peek()[0] <= w) {
                maxProfit.offer(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll()[1]; // 直接做利润最大的项目，并获得其利润
        }
        return w;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] capital = new int[]{0, 1, 1};
        int[] profits = new int[]{1, 2, 3};
        System.out.println(findMaximizedCapital(k, w, profits, capital));  // 4
    }
}
