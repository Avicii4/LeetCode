# Search2D a 2D Matrix II

链接：[搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

题意：在一个二维数组里寻找是否存在一个值。

分析：此题与 [搜索二维矩阵](../lc74) 这题相比多了由上到下递增的条件。用一个巧妙的方法可解，由左下角的元素开始遍历，如果元素大于目标值，则向上移一格（减小）；如果元素小于目标值，则向右移一格（增大）；如果相等，直接返回。同样的，也就可以从左上角开始遍历，这里不再赘述。