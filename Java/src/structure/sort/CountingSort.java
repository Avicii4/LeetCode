package structure.sort;


import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    public static List<Integer> countingSort(int[] arr) {
        // 找出数组中的最大值和最小值
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }

        // 统计数组中每个元素出现的次数
        int[] count = new int[maxVal - minVal + 1];
        for (int num : arr) {
            count[num - minVal]++;
        }

        // 根据统计信息重建排序后的数组
        List<Integer> sortedArr = new ArrayList<>();
        for (int i = minVal; i <= maxVal; i++) {
            while (count[i - minVal] > 0) {
                sortedArr.add(i);
                count[i - minVal]--;
            }
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 1, 5, 4, 8, 7};
        List<Integer> sortedArr = countingSort(arr);
        System.out.println(sortedArr);
    }

}
