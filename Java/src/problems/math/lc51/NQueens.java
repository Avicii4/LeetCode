package problems.math.lc51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harry Chou at 2019/02/20.
 * Description: Given an integer n, return all distinct solutions to the
 * n-queens puzzle.Each solution contains a distinct board configuration of the
 * n-queens' placement, where 'Q' and '.' both indicate a queen and an empty
 * space respectively.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[] location = new int[n];
        List<List<String>> res = new ArrayList<>();
        insertQueen(n, 0, location, res);
        return res;
    }

    private static void insertQueen(int n, int row, int[] location, List<List<String>> res) {
        if (row == n) {
            List<String> arrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == location[i]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                arrayList.add(sb.toString());
            }
            res.add(arrayList);
            return;
        }
        for (int i = 0; i < n; i++) {
            location[row] = i;
            if (!isAttackable(row, location)) {
                insertQueen(n, row + 1, location, res);
            }
        }
    }

    private static boolean isAttackable(int row, int[] location) {
        for (int i = 0; i < row; i++) {
            if (location[row] == location[i] || Math.abs(location[row] - location[i]) == row - i)
                return true;
        }
        return false;
    }
}
