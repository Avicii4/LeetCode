package problems.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC994 {
    int row;
    int col;
    int[][] directions;
    int freshCounter;

    public int orangesRotting1(int[][] grid) {
        // 0是空，1是新鲜橘子，2是腐烂橘子
        row = grid.length;
        col = grid[0].length;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int res = 0;
        freshCounter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    freshCounter++;
                }
            }
        }

        while (freshCounter > 0) {
            boolean flag = false;
            res++;
            // 1 首先标记一下本轮的腐烂橘子 (2->3)
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 2) {
                        grid[i][j] = 3;  // 表示这是本轮需要扩张的腐烂橘子
                    }
                }
            }

            // 2 本轮进行扩张 (3四周的1->2)
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == 3) {
                        for (int[] d : directions) {
                            int x = i + d[0], y = j + d[1];
                            if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1) {
                                continue;
                            }
                            grid[x][y] = 2;
                            flag = true;
                            freshCounter--;
                        }
                    }
                }
            }

            // 3 如果本轮没有任何扩张，结束
            if (!flag && freshCounter != 0) {
                return -1;
            }


        }
        return res;
    }

    // BFS的标准实现是用队列
    public int orangesRotting2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int freshCounter = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    freshCounter++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int res = 0;
        while (freshCounter > 0 && !queue.isEmpty()) {
            res++;  // 轮数加一
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] o = queue.poll();

                // 检查四周4个位置
                if (o[0] - 1 >= 0 && grid[o[0] - 1][o[1]] == 1) {
                    grid[o[0] - 1][o[1]] = 2;
                    freshCounter--;
                    queue.add(new int[]{o[0] - 1, o[1]});
                }

                if (o[1] - 1 >= 0 && grid[o[0]][o[1] - 1] == 1) {
                    grid[o[0]][o[1] - 1] = 2;
                    freshCounter--;
                    queue.add(new int[]{o[0], o[1] - 1});
                }

                if (o[0] + 1 < row && grid[o[0] + 1][o[1]] == 1) {
                    grid[o[0] + 1][o[1]] = 2;
                    freshCounter--;
                    queue.add(new int[]{o[0] + 1, o[1]});
                }

                if (o[1] + 1 < col && grid[o[0]][o[1] + 1] == 1) {
                    grid[o[0]][o[1] + 1] = 2;
                    freshCounter--;
                    queue.add(new int[]{o[0], o[1] + 1});
                }
            }
        }
        return freshCounter > 0 ? -1 : res;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(new LC994().orangesRotting1(arr));
        System.out.println(new LC994().orangesRotting2(arr));
    }
}
