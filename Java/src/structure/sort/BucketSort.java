package structure.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSort {
    public static void bucketSort(int[] arr){
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        // 找到数组中的最大值和最小值
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }
        // 计算桶的数量
        int bucketCount = (maxVal - minVal) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        // 初始化桶
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将元素分配到各个桶中
        for (int num : arr) {
            int index = (num - minVal) / n;
            buckets.get(index).add(num);
        }

        // 对每个桶内部进行排序
        for (List<Integer> bucket : buckets) {
            bucket.sort(Comparator.comparingInt(o -> o));
        }

        // 将桶中的元素按顺序放回原数组
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43,888};
        bucketSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
