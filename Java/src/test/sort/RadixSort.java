package test.sort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int maxVal = Arrays.stream(arr).max().getAsInt(); //获得数组最大值
        int n = arr.length;
        int exp = 1;

        while (maxVal / exp > 0) {
            int[] output = new int[n];
            int[] count = new int[10];

            // count[i]代表当前位（由exp控制）上数字等于i的元素有多少
            for (int j : arr) {
                int index = (j / exp) % 10;
                count[index]++;
            }

            // count[i]代表当前位上数字小等于i的元素有多少
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            // 根据计数数组将元素放置到正确的位置上
            // 由于count[i]现在代表的是在arr里，在当前位上小等于i的元素有多少
            // 因此当我们从arr最右边开始遍历的时候，arr[i]就应该放在本轮桶排序的对应count[index]-1位置上
            for (int i = n - 1; i >= 0; i--) {
                int index = (arr[i] / exp) % 10;
                output[count[index] - 1] = arr[i];
                count[index]--;
            }

            // 将本轮排序好的数组复制回原数组
            System.arraycopy(output, 0, arr, 0, n);

            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66,110,1221};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
