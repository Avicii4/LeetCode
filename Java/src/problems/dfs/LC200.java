package problems.dfs;

// 岛屿数量，1代表陆地，0代表水域
public class LC200 {
    int row;
    int col;
    int[][] directions;

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int res = 0;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;

    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'X';  // 标为已经遍历的陆地
        for (int[] d : directions) {
            dfs(i + d[0], j + d[1], grid);
        }
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(new LC200().numIslands(arr));
    }
}
