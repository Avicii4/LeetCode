/**
 * Created by Harry Chou at 2019/6/16.
 */

public class FindNumsAppearOnce {
    public static void findNum(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp ^= array[i];
        }
        int bitNo = findFirstBitOne(temp);
        for (int i = 0; i < array.length; i++) {
            if (judgeBit(array[i], bitNo)) {
                num2[0] ^= array[i];
            } else {
                num1[0] ^= array[i];
            }
        }

    }

    // 从数的右边起寻找第一个为1的位数
    private static int findFirstBitOne(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num = num >> 1;
            index++;
        }
        return index;
    }

    // 判断第index位是否是1
    private static boolean judgeBit(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;

    }

    public static void main(String[] args) {
        int[] testArr = { 2, 7, 8, 2, 7, 1, 0, 5, 4, 1, 4, 5 };
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNum(testArr, num1, num2);
        System.out.println("The 2 number you're looking for are: " + num1[0] + " and " + num2[0]);
    }
}
