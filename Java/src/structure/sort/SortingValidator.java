package structure.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SortingValidator {
    public static void validate(Consumer<int[]> sortFunction){
        int testTimes = 1000; // 设置测试次数
        int maxLength = 100; // 设置数组最大长度
        int maxValue = 100; // 设置数组元素的最大值

        for (int i = 0; i < testTimes; i++) {
            Random random = new Random();
            int length = random.nextInt(maxLength) + 1;
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = random.nextInt(maxValue + 1);
            }

            int[] arr1 = Arrays.copyOf(arr, arr.length); // 复制数组用于排序
            sortFunction.accept(arr1); // 使用你的排序算法进行排序

            int[] arr2 = Arrays.copyOf(arr, arr.length); // 复制数组用于排序
            Arrays.sort(arr2); // 使用系统提供的排序算法进行排序

            // 比较两种排序的结果是否相同
            boolean result = Arrays.equals(arr1, arr2);
            if (!result) {
                System.out.println("Error: Sorting result is incorrect!");
                System.out.println("Original Array: " + Arrays.toString(arr));
                System.out.println("Your Sorted Array: " + Arrays.toString(arr1));
                System.out.println("Correctly Sorted Array: " + Arrays.toString(arr2));
                return;
            }
        }
        System.out.println("All tests passed successfully!");
    }
}
