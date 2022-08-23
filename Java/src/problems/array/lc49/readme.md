# Group Anagrams

链接：[字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/description/)

题意：给定一个字符串数组，将字母异位词（anagrams）组合在一起。

分析：本题的突破口是字母异位词虽然每个都不同，但是排序之后都是一样的。所以遍历字符串数组，将每个元素排序后作为 key 添加进一个 Map 中，最后的输出就是这个 Map 里的所有 value 了。