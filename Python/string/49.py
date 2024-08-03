from typing import List
from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = defaultdict(list)
        for str in strs:
            freq_list = [0] * 26
            for char in str:
                freq_list[ord(char) - ord('a')] += 1
            map[tuple(freq_list)].append(str)  # 字典的key只能是tuple
        return list(map.values())


if __name__ == '__main__':
    s = ["eat", "tea", "tan", "ate", "nat", "bat"]
    print(Solution().groupAnagrams(s))
