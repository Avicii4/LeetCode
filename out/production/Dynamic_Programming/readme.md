# Unique Paths

链接：[不同路径](https://leetcode-cn.com/problems/unique-paths/)

题意：一个机器人位于一个 *m x n* 网格的左上角 （起始点在下图中标记为“Start” ）。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。问总共有多少条不同的路径？

![example](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

分析：由于只可以向右和下走，因此走到每个格子的路径数是其上、左的格子所记录的数目之和。注意在此题中，m=n=1 的答案被设置为1。

