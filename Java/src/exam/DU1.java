package exam;

import java.util.Scanner;

public class DU1 {
    public static int[] fruit(int n, int l, int r) {
        int least, most;
        if (l % n == 0) {
            least = l / n;
        } else {
            int tmp = l / n;
            if ((tmp + 1) * n > r) {
                return new int[]{-1};
            } else {
                least = tmp + 1;
            }
        }
        if (r % n == 0) {
            most = r / n;
        } else {
            int tmp = r / n;
            if (tmp * n <= r && tmp * n >= l) {
                most = tmp;
            } else {
                return new int[]{-1};
            }

        }
        return new int[]{least, most};
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int[] res = fruit(n, l, r);
            if (res.length == 1) {
                System.out.println(-1);
            } else {
                System.out.println(res[0] + " " + res[1]);
            }
        }

    }

}
