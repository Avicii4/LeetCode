/**
 * Created by Harry Chou at 2019/6/16.
 */

public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findAllSequence(int sum) {
        int p1 = 1;
        int p2 = 2;

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        while (p1 < p2) {
            if (getSum(p1, p2) > sum) {
                p1++;
            } else if (getSum(p1, p2) < sum) {
                p2++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = p1; i <= p2; i++) {
                    list.add(i);
                }
                resultList.add(list);
                p1++;
            }
        }
        return resultList;
    }

    private static int getSum(int num1, int num2) {
        return (num1 + num2) * (num2 - num1 + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(findAllSequence(100));
    }
}
