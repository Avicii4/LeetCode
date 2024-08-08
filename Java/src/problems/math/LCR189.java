package problems.math;

public class LCR189 {
    int res = 0;

    public int mechanicalAccumulator(int target) {
        // && 的短路效应，若target > 1不成立，后面的递归函数不会被调用，递归停止
        boolean x = target > 1 && mechanicalAccumulator(target - 1) > 0;
        res += target;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LCR189().mechanicalAccumulator(100));
    }
}
