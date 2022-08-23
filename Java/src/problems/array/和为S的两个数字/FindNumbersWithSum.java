/**
 * Created by Harry Chou at 2019/6/24.
 */

public class FindNumbersWithSum {
    public static ArrayList<Integer> findNum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length < 2 || array == null) {
            return list;
        }
        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            if (array[p1] + array[p2] == sum) {
                list.add(array[p1]);
                list.add(array[p2]);
                return list;
            } else if (array[p1] + array[p2] > sum) {
                p2--;
            } else {
                p1++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(findNum(array, 9).toString());
    }
}
