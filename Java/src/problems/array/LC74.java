package problems.array;

public class LC74 {
    // 法一：两次二分，先找所在行，再找所在列
    public static boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, bottom = row - 1;
        while (top < bottom) {
            int mid = (top + bottom + 1) / 2;
            if (matrix[mid][0] <= target) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }
        // 对l行进行二分
        int left = 0, right = col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[top][mid] == target) {
                return true;
            } else if (matrix[top][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    // 法二：把矩阵的全部行排成一行，那么这一行是有序的，所以相当于在一维上做二分
    // 关键在于定位这个设想的一行和实际矩阵位置的映射关系
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            int num = matrix[mid / col][mid % col];
            if (num == target) {
                return true;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix1(arr, 12));
    }
}
