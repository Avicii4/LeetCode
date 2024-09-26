class Solution:
    def MaxCollectedWater(self, road):
        p = 0
        q = len(road) - 1
        max_left = road[p]
        max_right = road[q]
        res = 0
        while p < q:
            max_left = max(max_left, road[p])
            max_right = max(max_right, road[q])
            if max_left < max_right:
                res += max_left - road[p]
                p += 1
            else:
                res += max_right - road[q]
                q -= 1
        return res
