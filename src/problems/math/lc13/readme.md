# Roman to Integer

链接：[罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/description/)

题意：罗马数字包含以下七种字符: `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。

<table>
<tr>
    <td>字符</td>
    <td>I</td>
    <td>V</td>
    <td>X</td>
    <td>L</td>
    <td>C</td>
    <td>D</td>
    <td>M</td>
</tr>
<tr>
    <td>数值</td>
    <td>1</td>
    <td>5</td>
    <td>10</td>
    <td>50</td>
    <td>100</td>
    <td>500</td>
    <td>1000</td>
</tr>
</table>

通常情况下，罗马数字中小的数字在大的数字的右边。但是也有特殊规则：
* I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
* X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
* C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

分析：判断假如放在右边的字符所表示的数较大，那么就加，否则就是减。

