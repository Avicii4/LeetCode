package exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DU3 {
    private static class Node {
        int x, y, steps, bombs;

        Node(int x, int y, int steps, int bombs) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.bombs = bombs;
        }

    }

    public static int move(char[][] arr, int n, int m) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][4];

        int startX = -1, startY = -1, endX = -1, endY = -1;
        // 先找起点、终点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'B') {
                    startX = i;
                    startY = j;
                } else if (arr[i][j] == '*') {
                    endX = i;
                    endY = j;
                }
            }
        }

        queue.offer(new Node(startX, startY, 0, 3));
        visited[startX][startY][3] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == endX && cur.y == endY) {
                return cur.steps;
            }
            for (int[] dir : directions) {
                int newX = cur.x + dir[0];
                int newY = cur.y + dir[1];

                if (isValid(newX, newY, n, m)) {
                    if (arr[newX][newY] == 'W' && cur.bombs > 0 && !visited[newX][newY][cur.bombs - 1]) {
                        // 用炸弹
                        queue.offer(new Node(newX, newY, cur.steps + 2, cur.bombs - 1));
                        visited[newX][newY][cur.bombs - 1] = true;
                    } else if (arr[newX][newY] != 'W' && !visited[newX][newY][cur.bombs]) {
                        // 不用炸弹
                        queue.offer(new Node(newX, newY, cur.steps + 1, cur.bombs));
                        visited[newX][newY][cur.bombs] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        System.out.println(move(arr, n, m));
    }
}
