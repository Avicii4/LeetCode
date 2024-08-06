package structure.sort;

public class MergeSort {

    /**
     * 归并排序的递归方法
     */
    public static void mergeSortRecursive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        processRecursive(arr, 0, arr.length - 1);

    }

    private static void processRecursive(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        processRecursive(arr, left, mid);
        processRecursive(arr, mid + 1, right);
        mergeBoth(arr, left, mid, right);
    }

    private static void mergeBoth(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p = left;
        int q = mid + 1;
        int index = 0;
        while (p <= mid && q <= right) {
            if (arr[p] <= arr[q]) {
                help[index++] = arr[p++];
            } else {
                help[index++] = arr[q++];
            }
        }
        while (p <= mid) {
            help[index++] = arr[p++];
        }
        while (q <= right) {
            help[index++] = arr[q++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }

    }

    /**
     * 归并排序的非递归方法
     */
    public static void mergerSortUnrecursive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int n = arr.length;
        while (mergeSize < n) {
            int left = 0;
            while (left < n) {
                int mid = left + mergeSize - 1;
                if (mid >= n) { // 无法再划出右半边了
                    break;
                }
                int right = Math.min(mid + mergeSize, n - 1);
                mergeBoth(arr, left, mid, right);
                left = right + 1;
            }
            mergeSize<<=1;
        }
    }

    public static void main(String[] args) {
        SortingValidator.validate(MergeSort::mergeSortRecursive);
        SortingValidator.validate(MergeSort::mergerSortUnrecursive);
    }

}
