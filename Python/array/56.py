from typing import List


class Solution:

    @classmethod
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: (x[0], x[1]))
        res = []
        area = intervals[0]
        for i in range(1, len(intervals)):
            if intervals[i][1] <= area[1]:  # 全包括
                continue
            elif intervals[i][0] > area[1]:  # 新的一个区间
                res.append(area)
                area = intervals[i]
            elif intervals[i][1] > area[1]:
                area[1] = intervals[i][1]  # 更新目前的右边界
        if area != res[-1]:
            res.append(area)

        return res


if __name__ == '__main__':
    intervals = [[1, 3], [1, 1], [2, 6], [8, 10], [15, 18]]
    print(Solution.merge(intervals))
