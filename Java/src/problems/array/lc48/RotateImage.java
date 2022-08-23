package problems.array.lc48;

/**
 * Created by Harry Chou at 2018/10/21.
 * Description: You are given an n x n 2D matrix representing an image.Rotate
 * the image by 90 degrees (clockwise).
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++)
            for (int j = i; j < len - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = tmp;
            }
    }
}
