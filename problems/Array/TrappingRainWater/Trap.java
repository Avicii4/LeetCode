/**
 * Description: Given n non-negative integers representing an elevation map
 * where the width of each bar is 1, compute how much water it is able to trap
 * after raining.
 */
public class Trap {
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 0) {
            return res;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}