/**
 * Created by Harry Chou at 2019/9/15.
 */
public class CutRope {
	public int cutRope(int target) {
		if (target == 2) {
			return 1;
		}
		if (target == 3) {
			return 2;
		}
		int m = target % 3;
		int n = target / 3;

		if (m == 0) {
			return (int) Math.pow(3, n);
		} else if (m == 1) {
			return 4 * (int)Math.pow(3, n - 1);
		} else {
			return 2 * (int)Math.pow(3, n);
		}
	}
}
