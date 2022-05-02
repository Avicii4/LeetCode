package problems.array.lc74;

/**
 * Created by Harry Chou at 2019/2/28.
 * Description: Write an efficient algorithm that searches for a value in an m x
 * n matrix. This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the
 * previous row.
 */
class Search {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int front = 0;
        int rear = m * n - 1;

        while (front <= rear) {
            int mid = front + (rear - front) / 2;
            if (target == matrix[mid / n][mid % n]) {
                return true;
            } else if (target > matrix[mid / n][mid % n]) {
                front = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        return false;
    }
}