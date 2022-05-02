package problems.math.lc278;

import problems.util.VersionControl;

/**
 * Created by Harry Chou at 2018/12/10.
 * Description: Each version is developed based on the previous version, all the
 * versions after a bad version are also bad. Use an API bool
 * isBadVersion(version) which will return whether version is bad.
 * The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);
 */
public class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}