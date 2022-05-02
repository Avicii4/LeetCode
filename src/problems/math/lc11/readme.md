# Container With Most Water

链接：[盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/description/)

题意：给定 *n* 个非负整数 *a<sub>1</sub>*，*a<sub>2</sub>*，...，*a<sub>n</sub>*，每个数代表坐标中的一个点 (*i*, *a<sub>i</sub>*) 。在坐标内画 *n* 条垂直线，垂直线 *i* 的两个端点分别为 (*i*, *a<sub>i</sub>*) 和 (*i*, 0)。找出其中的两条线，使得它们与 *x* 轴共同构成的容器可以容纳最多的水。不能倾斜容器，且 *n* 的值至少为 2。

分析：使用的是双指针法，由于矩形的面积受制于较短一边的长度，所以先从第一根垂线和最后一根垂线开始遍历。然后向中间逼近，每次都是移动两端中的较短边。这里也有更完整的[官方解释](https://leetcode-cn.com/articles/container-with-most-water/)。