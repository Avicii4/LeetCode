# Integer to Roman

链接：[整数转罗马数字](https://leetcode-cn.com/problems/integer-to-roman/description/)

题意：给出的信息与另一题（[罗马数字转整数](../lc13)）一样。要求给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

分析：完整的罗马数字与阿拉伯数字对照如下

<table>
<tr>
    <td>字符</td>
    <td>I</td>
    <td>IV</td>
    <td>V</td>
    <td>IX</td>
    <td>X</td>
    <td>XL</td>
    <td>L</td>
    <td>XC</td>
    <td>C</td>
    <td>CD</td>
    <td>D</td>
    <td>CM</td>
    <td>M</td>
</tr>
<tr>
    <td>数值</td>
    <td>1</td>
    <td>4</td>
    <td>5</td>
    <td>9</td>
    <td>10</td>
    <td>40</td>
    <td>50</td>
    <td>90</td>
    <td>100</td>
    <td>400</td>
    <td>500</td>
    <td>900</td>
    <td>1000</td>
</tr>
</table>


选择与给定的 *num* 最接近但不超过的数值，就可以得出结果。