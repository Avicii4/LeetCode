package problems.array;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 上下左右4个边界变量
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;
        while (left < right && top < bottom) {
            // 上面一行
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // 右侧一列
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;
            if (left >= right || top >= bottom) {
                break;
            }
            // 下面一行
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            // 左侧一列
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }


        return res;
    }

    public static void main(String[] args) {
        int rows = 4;
        int cols = 2;
        int[][] matrix = new int[rows][cols];

        int value = 1; // 从 1 开始赋值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        System.out.println(spiralOrder(matrix));
    }
}
