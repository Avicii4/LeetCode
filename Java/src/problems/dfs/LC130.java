package problems.dfs;

public class LC130 {
    int row;
    int col;
    int[][] directions;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 标记不被包围的O
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
        // 修改所有非T的位置都为X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != 'T') {
                    board[i][j] = 'X';
                }
            }
        }

        // 修改所有T的位置都为O
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    // 从棋盘边缘处的O开始dfs，标记能连通的O
    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') {
            // 这里不能写  board[i][j] == 'X'
            return;
        }
        board[i][j] = 'T';  // 标记这是不被包围的地方
        // 走四个地方
        for (int[] d : directions) {
            dfs(i + d[0], j + d[1], board);
        }
    }

    public static void main(String[] args) {
        //char[][] arr = {{'X', 'X', 'X', 'X'},
        //        {'X', 'O', 'O', 'X'},
        //        {'X', 'X', 'O', 'X'},
        //        {'X', 'O', 'X', 'X'}};
        char[][] arr = {{'O', 'O'}, {'O', 'O'}};

        new LC130().solve(arr);
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
