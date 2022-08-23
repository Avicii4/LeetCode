/**
 * Created by Harry Chou at 2019/4/19.
 */
public class JumpFloorII {
    public int JumpFloorIICounter(int target) {
        return 1 << --target;
        // return (int) Math.pow(2, target - 1);
    }
}
