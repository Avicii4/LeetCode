package exam;


import java.util.Scanner;


// 请看LeetCode 130 & 200
public class EnclosedArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩阵的行数和列数：");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗换行符

        char[][] matrix = new char[m][n];
        System.out.println("请输入矩阵：");
        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }

        System.out.println(count(matrix));
    }



    private static boolean dfs(char[][] matrix, int row, int col, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || matrix[row][col] != '0') {
            return true;
        }

        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                if (matrix[newRow][newCol] == '*') {
                    return true;
                } else if (matrix[newRow][newCol] == '0' && !visited[newRow][newCol]) {
                    if (dfs(matrix, newRow, newCol, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int count(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0' && !visited[i][j]) {
                    if (dfs(matrix, i, j, visited)) {
                        res++;
                    }
                }
            }
        }

        return res;
    }


}
