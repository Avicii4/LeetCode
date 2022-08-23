package problems.array.lc88;

/**
 * Created by Harry Chou at 2018/11/16.
 * Description: Given two sorted integer arrays nums1 and nums2, merge nums2
 * into nums1 as one sorted array.
 */
public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[k - 1] = nums1[m - 1];
                k--;
                m--;
            } else {
                nums1[k - 1] = nums2[n - 1];
                k--;
                n--;
            }
        }
        while (n > 0) {
            nums1[k - 1] = nums2[n - 1];
            k--;
            n--;
        }
    }
}