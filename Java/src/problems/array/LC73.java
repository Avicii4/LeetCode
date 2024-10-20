package problems.array;

import java.util.*;

public class LC73 {
    // 法一：额外空间记录
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int x : rowSet) {
            for (int y = 0; y < col; y++) {
                matrix[x][y] = 0;
            }
        }
        for (int y : colSet) {
            for (int x = 0; x < row; x++) {
                matrix[x][y] = 0;
            }
        }
    }

    // 法二：O(1)复杂度
    // 可以先找到一个为0的元素，那么它的所在行列都会被置为0，
    // 那就可以将这一行和一列分别用来记录该矩阵的某一列和某一行是否需要被置零。
    // 最后不要忘记将记录的行和列全部置零。
    public void setZeroes2(int[][] matrix) {
        int row = 0;
        int col = 0;

        int i = 0;
        for (i = 0; i < matrix.length; i++) {
            boolean flag = false;
            for (int j = 0; j < matrix[0].length; j++) {
                // 先找到一个为0的元素
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

        // 扫描整个矩阵，用i行与j列记录0
        for (int k = i + 1; k < matrix.length; k++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[k][j] == 0) {
                    matrix[k][col] = 0;
                    matrix[row][j] = 0;
                }
            }
        }

        // 读取记录，执行置0操作
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

        // 把用于记录的i行和j列全部置0
        for (i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        for (i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }


    public static void main(String[] args) {
        int[][] arr = {
                {0, 2, 3, 4},
                {5, 6, 0, 0},
                {9, 10, 11, 12}};
        setZeroes(arr);
        for (int[] r : arr) {
            System.out.println(Arrays.toString(r));
        }
    }

}
