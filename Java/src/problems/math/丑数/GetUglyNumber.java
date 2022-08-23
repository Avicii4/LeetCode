
/**
 * Created by Harry Chou at 2019/6/6.
 */

import java.util.List;
import java.util.ArrayList;

public class GetUglyNumber {
    public int getNumber(int index) {
        if (index < 7) {
            return index;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int min = 0;
        while (list.size() < index) {
            int num2 = list.get(p2) * 2;
            int num3 = list.get(p3) * 3;
            int num5 = list.get(p5) * 5;
            min = Math.min(num2, Math.min(num3, num5));
            list.add(min);
            // 不能写 else 的形式
            if (min == num2) {
                p2++;
            }
            if (min == num3) {
                p3++;
            }
            if (min == num5) {
                p5++;
            }
        }
        return min;
    }
}