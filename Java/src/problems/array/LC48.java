package problems.array;

import java.util.Arrays;

public class LC48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int top = left, bottom = right;
            for (int i = 0; i < right - left; i++) {
                int topLeft = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = new int[4][4];
        int value = 1; // 从 1 开始赋值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        rotate(matrix);
        for (int[] t : matrix)
            System.out.println(Arrays.toString(t));
    }
}
