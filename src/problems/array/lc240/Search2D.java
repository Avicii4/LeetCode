package problems.array.lc240;

/**
 * Created by Harry Chou at 2019/3/4.
 * Description: Write an efficient algorithm that searches for a value in an m x
 * n matrix. This matrix has the following properties: 
 * 1. Integers in each row are sorted in ascending from left to right. 
 * 2. Integers in each column are sorted in ascending from top to bottom.
 */
class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}