/**
 * Created by Harry Chou at 2019/6/10.
 */

public class InversePairs {
    public int countPairs(int[] array) {
        int len = array.length;
        if (array == null || len <= 0) {
            return 0;
        }
        return mergeFind(array, 0, len - 1);
    }

    private static int mergeFind(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        int counterLeft = mergeFind(arr, left, mid);
        int counterRight = mergeFind(arr, mid + 1, right);

        int[] help = new int[right - left + 1];
        int copyIndex = right - left;
        int counter = 0;
        // 左半边数组的指针
        int p1 = mid;
        // 右半边数组的指针
        int p2 = right;
        // 左右比较，将较大数填入辅助数组
        while (p1 >= left && p2 >= mid + 1) {
            if (arr[p1] > arr[p2]) {
                help[copyIndex--] = arr[p1--];
                counter += p2 - mid;
                if (counter > 1000000007) {
                    counter %= 1000000007;
                }
            } else {
                help[copyIndex--] = arr[p2--];
            }
        }
        // 向辅助数组中填入剩余数据
        while (p1 >= left) {
            help[copyIndex--] = arr[p1--];
        }
        while (p2 >= mid + 1) {
            help[copyIndex--] = arr[p2--];
        }
        System.arraycopy(help, 0, arr, left, help.length);
        return (counterLeft + counterRight + counter) % 1000000007;
    }
}
