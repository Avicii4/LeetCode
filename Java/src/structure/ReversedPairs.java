package structure;

public class ReversedPairs {
    public static int reversedPair(int[] arr) {
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


    // 因为求逆序对，所以让数组整体从大到小排列比较好
    private static int mergeBoth(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p = left;
        int q = mid + 1;
        int cur = 0;
        int res = 0;
        while (p <= mid && q <= right) {
            // 对于arr[p]来说，arr[q]之后所有的值都比它小，故都要记入逆序对结果中
            if (arr[p] > arr[q]) {
                res += right - q + 1;
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
        int[] nums={5,4,3,2,1};
        System.out.println(reversedPair(nums));
    }
}
