package problems.array;

import java.util.*;

public class LCR180 {
    public static int[][] fileCombination(int target) {
        List<int[]> res = new ArrayList<>();
        int curSum = 0;
        int p = 1, q = 1;
        while (p <= target / 2) {
            if (curSum == target) {
                int[] arr = new int[q - p];
                for (int i = p; i < q; i++) {
                    arr[i - p] = i;
                }
                res.add(arr);
                curSum -= p;
                p++;
            } else if (curSum < target) {
                curSum += q;
                q++;
            } else {
                curSum -= p;
                p++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = fileCombination(18);
        for (int[] x : a) {
            System.out.println(Arrays.toString(x));
        }
    }
}
