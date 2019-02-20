/**
 * Created by Harry Chou at 2019/02/16.
 * Description: Implement int sqrt(int x).Compute and return the square root of
 * x, where x is guaranteed to be a non-negative integer.Since the return type
 * is an integer, the decimal digits are truncated and only the integer part of
 * the result is returned.
 */
class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}