/**
 * Created by Harry Chou at 2019/7/4.
 */
public class LastRemain {
    public int solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p;
    }

    public int solution_2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
