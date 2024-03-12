from typing import List


class Solution:
    # 最靠近 x 的 k 个数
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        最后的结果一定是原数组中连续的k个数，所以用一个宽为k的窗口进行搜索
        数组有序，所以肯定用二分法
        用 left 作为窗口的左边界，右边界就是 left+k，由于惰性，找到的边界总是 left-biased
        如果

        """
        left, right = 0, len(arr) - k
        while left < right:
            mid = (left + right) >> 1
            # {mid,mid+k}是一个比{left,left+k}更为右倾的区间
            # 现在连{mid,mid+k}都太过靠左了，别说{left,left+k}了
            # 因此{left,left+k}整体右移
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            # {mid,mid+k}太靠右了，那我最终的窗口肯定不可能再往右边跑了
            # 此时果断收缩右边界
            else:
                right = mid
        return arr[left:left + k]
