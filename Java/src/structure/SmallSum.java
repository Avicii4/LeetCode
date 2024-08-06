package structure;

// 在一个数组中，一个数左边比它小的数的总和，叫数的小和。
// 所有数的小和累加起来，叫数组小和，求数组小和。
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid)
                + process(arr, mid + 1, right)
                + mergeBoth(arr, left, mid, right);
    }

    private static int mergeBoth(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p = left;
        int q = mid + 1;
        int cur = 0;
        int res = 0;
        while (p <= mid && q <= right) {
            // 对于arr[p]来说，arr[q]之后所有的值都比它大，故都要记入小和结果中
            if (arr[p] < arr[q]) {
                res += arr[p] * (right - q + 1);
                help[cur++] = arr[p++];
            } else {
                help[cur++] = arr[q++];
            }
        }
        while (p <= mid) {
            help[cur++] = arr[p++];
        }
        while (q <= right) {
            help[cur++] = arr[q++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 5};
        System.out.println(smallSum(nums));
    }

}
