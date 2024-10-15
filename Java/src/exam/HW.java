package exam;


// n个台阶，一次可以走2步，5步，组合数量
// n=2;   1
// n=3;   0
// n=10   2
public class HW {
    public static int stair(int n) {
        if (n == 2) return 1;
        if (n == 5) return 1;
        if (n == 4) return 1;
        if (n <= 1 || n == 3) {
            return 0;
        }
        return stair(n - 2) + stair(n - 5);
    }

    public static void main(String[] args) {
        // 开始的用例
        //for (int i = 0; i <= 5; i++) {
        //    System.out.println(stair(i));
        //}
        // 222
        System.out.println(stair(6));
        // 25 52
        System.out.println(stair(7));
        // 22222 55
        System.out.println(stair(10));
        // -1
        System.out.println(stair(-1));
        // 11 = 5 + 6   2225
        System.out.println(stair(11));
    }
}
