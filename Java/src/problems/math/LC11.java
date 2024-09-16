package problems.math;

// 双指针解法
public class LC11 {
    public static int maxArea(int[] height) {
        int p = 0, q = height.length - 1;
        int res = 0;
        while (p < q) {
            int curArea = Math.min(height[p], height[q]) * (q - p);
            res = Math.max(curArea, res);
            // p、q指针谁更小就移动谁
            if (height[p] <= height[q]) {
                p++;
            } else {
                q--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr = {1, 1};
        System.out.println(maxArea(arr));
    }
}
