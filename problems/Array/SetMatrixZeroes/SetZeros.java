/**
 * Created by Harry Chou at 2018/12/15.
 * Description: Given a m x n matrix, if an element is 0, set its entire row and
 * column to 0. Do it in-place.
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int row = 0;
        int col = 0;

        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (i == matrix.length) {
            return;
        }

        for (int k = i + 1; k < matrix.length; k++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[k][j] == 0) {
                    matrix[k][col] = 0;
                    matrix[row][j] = 0;
                }
            }
        }

        for (i = 0; i < matrix[0].length; i++) {
            if (i == col) {
                continue;
            }
            if (matrix[row][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (i = 0; i < matrix.length; i++) {
            if (i == row) {
                continue;
            }
            if (matrix[i][col] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }

        for (i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }
}