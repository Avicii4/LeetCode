package test.sort;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        Random random = new Random();
        int randLoc = random.nextInt((right - left) + 1) + left;
        swap(arr, randLoc, right);
        int[] midArea = partition(arr, left, right);
        process(arr, left, midArea[0] - 1);
        process(arr, midArea[1] + 1, right);
    }

    private static int[] partition(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        int pivot = arr[right];
        int less = left - 1;  // 小于pivot值的区域
        int more = right;   // 大于pivot值的区域
        int cur = left;
        while (cur < more) {
            if (arr[cur] == pivot) {
                cur++;
            } else if (arr[cur] < pivot) {
                // cur要后移，因为交换上来的新值肯定<=pivot值
                swap(arr, ++less, cur++);
            } else {
                // 注意这里cur不用移动，因为交换上来的新值不知道其大小
                swap(arr, --more, cur);
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};

    }

    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        SortingValidator.validate(QuickSort::quickSort);
    }
}
