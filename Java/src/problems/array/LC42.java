package problems.array;

// 接雨水
public class LC42 {
    // 双指针解法
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        // mLeft和mRight两者的较小值减去当前位置的高度，就是当前位置能接的水量
        int mLeft = height[l], mRight = height[r];
        int res = 0;
        while (l <= r) {
            if (mLeft <= mRight) {
                if (mLeft - height[l] > 0) {
                    res += mLeft - height[l];
                }
                mLeft = Math.max(mLeft, height[l]);
                l++;
            } else {
                if (mRight - height[r] > 0) {
                    res += mRight - height[r];
                }
                mRight = Math.max(mRight, height[r]);
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
    }
}
