package structure;

public class NQueens {
    public static int solveNQueens(int n) {
        int limit = n == 32 ? -1 : (1 << n) - 1;  // 最右侧n位是1，剩余都是0
        return fastProcess(limit, 0, 0, 0);
    }

    /**
     * @param limit 本值始终不变，它决定了当前是几皇后问题，这个值的右侧n位全为1
     * @param col   之前皇后的列影响，每一位的1代表不能放，0代表能放
     * @param left  之前皇后的右上 -> 左下对角线影响，01含义同上
     * @param right 之前皇后的左上 -> 右下对角线影响，01含义同上
     */
    private static int fastProcess(int limit, int col, int left, int right) {
        // 所有皇后放完了！
        if (col == limit) {
            return 1;
        }
        // 总限制，此时1不可放皇后，0可放
        int ban = col | left | right;
        // ban取反得到~ban,对于candidate的每一位，1可放皇后，0不能放
        int candidate = limit & (~ban);
        // 既然candidate的每一位中1是可选的位置，那么我们每次取出最右侧的1，进行尝试
        int mostRightOne = 0;
        int ans = 0;
        while (candidate != 0) {
            // 循环不断提取出最右侧的1
            // 0 0 1 1 1 0
            // 5 4 3 2 1 0
            // mostRightOne :
            // 0 0 0 0 1 0
            // candidate :
            // 0 0 1 1 0 0
            // 5 4 3 2 1 0
            // mostRightOne :
            // 0 0 0 1 0 0
            // candidate :
            // 0 0 1 0 0 0
            // 5 4 3 2 1 0
            // mostRightOne :
            // 0 0 1 0 0 0
            // candidate :
            // 0 0 0 0 0 0
            // 5 4 3 2 1 0
            mostRightOne = candidate & (~candidate + 1);
            candidate -= mostRightOne; // 去掉目前最右侧的1，供下一次循环尝试
            ans += fastProcess(limit,
                    col | mostRightOne,
                    (left | mostRightOne) << 1,   // 左对角线的限制就是列限制左移
                    (right | mostRightOne) >> 1);   // 右对角线的限制就是列限制右移
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(14));
    }
}
