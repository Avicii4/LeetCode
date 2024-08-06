package structure.sort;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 建大根堆过程
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int heapSize = arr.length;
        // 交换堆顶（数组中最大值）到最后一个位置上去
        // 此时最后一个位置的值已经确定了
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 从index位置不断往下比较，如果孩子更大就把它移上来，维护大根堆性质 O(logN)
    private static void heapify(int[] arr, int index, int heapSize) {
        int leftChildIndex = 2 * index + 1;
        while (leftChildIndex < heapSize) {
            int largerIndex = leftChildIndex;
            if (leftChildIndex + 1 < heapSize && arr[leftChildIndex + 1] > arr[leftChildIndex]) {
                // 有右孩子而且右孩子更大
                largerIndex++;
            }
            largerIndex = arr[index] > arr[largerIndex] ? index : largerIndex;
            if (largerIndex == index) {
                break;
            }
            swap(arr, largerIndex, index);
            index = largerIndex;
            leftChildIndex = 2 * index + 1;
        }
    }

    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        SortingValidator.validate(HeapSort::heapSort);
    }
}
