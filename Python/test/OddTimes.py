from typing import List
from random import randint


def odd_times_number(nums: List[int]):
    """
    一个数组中有两种数出现了奇数次，其余数都出现了偶数次，找出这两种数
    """
    eor = 0
    for num in nums:
        eor ^= num
    # eor = a^b, eor!=0 找出eor二进制里最右侧的1
    right_one = eor & (~eor + 1)
    one_answer = 0
    for num in nums:
        # 只将第k位为1的所有数异或起来
        if right_one & num != 0:
            one_answer ^= num
    return one_answer, one_answer ^ eor


def count_one(n):
    """
    计算二进制的n中的1的个数
    """
    res = 0
    while n != 0:
        right_one = n & (~n + 1)  # 取出最右的1
        res += 1
        n ^= right_one  # 删掉最右的1
    return res


if __name__ == '__main__':
    # lst = [1, 1, 2, 2, 2, 3, 3, 6, 6, 0, 0, 0, 0, 0, 8, 8, 8, 8]
    # print(odd_times_number(lst))
    for _ in range(100):
        num = randint(0,1000)
        res = count_one(num)
        ground_truth=bin(num).count('1')
        if res!=ground_truth:
            exit('{} {} {}'.format(num,res,ground_truth))
    else:
        print('Happy!')


# 测试结果：右移确实比除法快
