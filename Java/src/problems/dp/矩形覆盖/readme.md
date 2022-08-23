# 矩形覆盖

**题目描述：**

我们可以用 2×1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 *n* 个 2×1 的小矩形无重叠地覆盖一个 2×n 的大矩形，总共有多少种方法？

**分析：**

小矩形横放或者竖放，长度为1或者2，要达到n的长度，不难发现这和 [跳台阶](<https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking>) 其实是一个问题。