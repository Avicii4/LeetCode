package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] record = new int[n];
        process(0, record, n, res);
        return res;
    }

    /**
     * N 皇后回溯递归的函数
     *
     * @param i      当前行数
     * @param record 数组中记录着i行之前的摆放情况，例如record[3]=7意味着3行7列放着一个皇后
     * @param n      皇后总数
     * @param res    最终的结果
     */
    private static void process(int i, int[] record, int n, List<List<String>> res) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[record[j]] = 'Q';
                String s = new String(chars);
                list.add(s);
            }
            res.add(list);
        }
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process(i + 1, record, n, res);
            }

        }
    }

    private static boolean isValid(int[] record, int i, int j) {
        /**
         * 对于两个坐标为(a,b)和(c,d)的皇后来说，
         * 它们同一列的话，就是b==d
         * 它们为同一斜线的话，就是 |a-c|==|b-d|
         */
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
