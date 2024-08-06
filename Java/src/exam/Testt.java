package exam;

// 快速

import structure.sort.QuickSort;
import structure.sort.SortingValidator;

import java.util.Random;

public class Testt {

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
        int randIndex = random.nextInt(right - left + 1) + left;
        swap(arr, randIndex, right);
        int[] equalArea = partition(arr, left, right);
        process(arr, left, equalArea[0] - 1);
        process(arr, equalArea[1] + 1, right);

    }

    private static int[] partition(int[] arr, int left, int right) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        if (left == right) {
            return new int[]{left, right};
        }
        int less = left - 1;
        int more = right;
        int cur = left;
        while (cur < more) {
            if (arr[cur] < arr[right]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] == arr[right]) {
                cur++;
            } else {
                swap(arr, --more, cur);
            }
        }
        swap(arr, more, right);
        return new int[]{left + 1, more};
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
