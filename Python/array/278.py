# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        if n == 1:
            return 1
        left, right = 0, n-1
        res=-1
        while left <= right:
            mid = (left + right) >> 1
            if isBadVersion(mid+1):  # 是错误版本
                res=mid+1
                right=mid-1
            else:
                left=mid+1
        return res



def isBadVersion(n: int) -> bool:
    wanted_res=2
    if n <= wanted_res-1:
        return False
    else:
        return True


if __name__ == '__main__':
    print(Solution().firstBadVersion(2))