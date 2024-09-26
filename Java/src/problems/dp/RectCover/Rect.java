package problems.dp.RectCover;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，从同一个方向看总共有多少种不同的方法？
 * Created by Harry Chou at 2019/4/19.
 */
public class Rect {
    // 其实最后找规律，发现 f(n)=f(n-1)+f(n-2)，就是斐波那契
    public static int rectCover(int target) {
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

    public static void main(String[] args) {
        System.out.println(rectCover(10));
    }
}
