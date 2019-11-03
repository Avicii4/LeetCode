/**
 * Created by Harry Chou at 2019/11/3.
 * Description: There are two sorted arrays nums1 and nums2 of size m and
 * n respectively. Find the median of the two sorted arrays. The overall run
 * time complexity should be O(log (m+n)). You may assume nums1 and nums2 
 * cannot be both empty.
 */
public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
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
}
