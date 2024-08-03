from typing import List


class Solution:
    # 暴力法
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n + 1)  # i处结尾的字符串是否完全可以由单词组成
        dp[0] = True

        for i in range(1, n + 1):
            for word in wordDict:
                if i >= len(word) and s[i - len(word):i] == word:
                    dp[i] = dp[i - len(word)]
                if dp[i]:
                    break

        return dp[n]


if __name__ == '__main__':
    s = 'dogs'
    words = ["dog", "s", "gs"]
    print(Solution().wordBreak(s, words))
