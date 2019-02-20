/**
 * Created by Harry Chou at 2019/02/20.
 * Description: Given an integer n, return the number of distinct solutions to
 * the n-queens puzzle.
 */
public class NQueensII {
    public int count = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        check(0, new int[n]);
        return count;
    }

    private void check(int row, int[] location) {
        if (row == location.length) {
            count++;
            return;
        }
        for (int i = 0; i < location.length; i++) {
            location[row] = i;
            if (!isAttackable(row, location)) {
                check(row + 1, location);
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
