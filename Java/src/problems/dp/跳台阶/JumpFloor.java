/**
 * Created by Harry Chou at 2019/4/19.
 */
public class JumpFloor {
    public int JumpFloorCounter(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}