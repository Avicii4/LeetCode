/**
 * Created by Harry Chou at 2019/3/14.
 */
public class FindInArray {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 && array[0].length == 0) {
            return false;
        }
        int x = array.length - 1;
        int y = 0;
        while (x >= 0 && y < array[0].length) {
            if (array[x][y] == target) {
                return true;
            } else if (array[x][y] < target) {
                y++;
            } else {
                x--;
            }
        }
        return false;
    }
}