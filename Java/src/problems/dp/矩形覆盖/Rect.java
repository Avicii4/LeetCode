/**
 * Created by Harry Chou at 2019/4/19.
 */
public class Rect {
    public int rectCover(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        int frontIndex = 1;
        int rearIndex = 1;
        while (target > 0) {
            rearIndex += frontIndex;
            frontIndex = rearIndex - frontIndex;
            target--;
        }
        return frontIndex;
    }
}
