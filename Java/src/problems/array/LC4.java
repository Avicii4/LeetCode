package problems.array;

public class LC4 {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double mid = (m + n) / 2.0;
        boolean isOdd = mid != (int) mid;  // m+n是否是奇数
        int i = 0, j = 0;
        int cur = -1;
        while (i < m && j < n && i + j < mid) {
            if (nums1[i] <= nums2[j]) {
                cur = nums1[i++];
            } else {
                cur = nums2[j++];
            }
        }
        // 类似归并，有两个while
        while (i + j < mid && i < m) {
            cur = nums1[i++];
        }
        while (i + j < mid && j < n) {
            cur = nums2[j++];
        }
        if (isOdd) {
            return cur;
        } else {
            if (i == m) {  // 在nums1上走完了
                return (nums2[j] + cur) / 2.0;
            } else if (j == n) {  // 在nums2上走完了
                return (nums1[i] + cur) / 2.0;
            } else {
                return (cur + Math.min(nums1[i], nums2[j])) / 2.0;
            }
        }
    }

    /**
     * Created by Harry Chou at 2019/11/3.
     * 方法二：二分法
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays2(nums2, nums1);
        }

        int leftMax1 = 0, leftMax2 = 0, rightMin1 = 0, rightMin2 = 0;
        int cut1, cut2;
        int low = 0;
        int high = 2 * m;

        while (low <= high) {
            cut1 = (low + high) >> 1;
            cut2 = m + n - cut1;

            leftMax1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[(cut1 - 1) / 2];
            rightMin1 = (cut1 == 2 * m) ? Integer.MAX_VALUE : nums1[cut1 / 2];
            leftMax2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[(cut2 - 1) / 2];
            rightMin2 = (cut2 == 2 * n) ? Integer.MAX_VALUE : nums2[cut2 / 2];

            if (leftMax1 > rightMin2) {
                high = cut1 - 1;
            } else if (leftMax2 > rightMin1) {
                low = cut1 + 1;
            } else {
                break;
            }
        }
        return (double) (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {};
        System.out.println(findMedianSortedArrays1(a, b));
        System.out.println(findMedianSortedArrays2(a, b));
    }

}
