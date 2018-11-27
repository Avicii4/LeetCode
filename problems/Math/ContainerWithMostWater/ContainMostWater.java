/**
 * Created by Harry Chou at 2018/11/27.
 * Description: Given n non-negative integers a1, a2, ..., an , where each
 * represents a point at coordinate (i, ai). n vertical lines are drawn such
 * that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container
 * contains the most water.
 */
public class ContainMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int temp = 0;
        int result = 0;
        while (left < right) {
            temp = Math.min(height[left], height[right]) * (right - left);
            result = temp > result ? temp : result;
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}