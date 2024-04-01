package test.sort;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int tempMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[tempMinIndex]) {
                    tempMinIndex = j;
                }
            }
            swap(arr, tempMinIndex, i);
        }
    }

    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        SortingValidator.validate(SelectionSort::selectionSort);
    }
}
