package problems.dfs;

public class LC79 {
    public static boolean exist(char[][] board, String word) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    boolean a = dfs(i, j, 0, visited, board, row, col, word, directions);
                    if (a) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int x, int y, int step, boolean[][] visited, char[][] board,
                               int row, int col, String word, int[][] directions) {
        if (step == word.length() - 1) {
            return true;
        }
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY]) {
                if (board[newX][newY] == word.charAt(step + 1)) {
                    visited[newX][newY] = true;
                    boolean ans = dfs(newX, newY, step + 1, visited, board, row, col, word, directions);
                    if (ans) {
                        return true;
                    }
                    visited[newX][newY] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //char[][] arr = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }};
        //String word = "ABCCED";
        char[][] arr = {{'A', 'B', 'C','E'}, {'S', 'F', 'E','S'}, {'A', 'D', 'E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(arr, word));
    }
}
