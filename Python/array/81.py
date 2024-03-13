from typing import List
import random


def generate_array():
    # 生成随机数组的长度
    length = random.randint(1, 20)  # 你可以根据需要调整长度的范围
    # 生成随机整数数组并排序
    nums = sorted([random.randint(0, 9) for _ in range(length)])
    shift_amount = random.randint(0, length)
    shifted_array = nums[shift_amount:] + nums[:shift_amount]
    return shifted_array


class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        left, right = 0, len(nums) - 1
        if nums[0]==nums[-1] and nums[0]!=target:
            # 去掉头尾相等的值
            nums=[x for x in nums if x!=nums[0]]

        while left <= right:
            mid = (left + right) >> 1
            if target == nums[mid]:
                return True
            elif nums[0] <= nums[mid]:
                if nums[0] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[-1]:
                    left = mid + 1
                else:
                    right = mid - 1
        return False


if __name__ == '__main__':
    arr = [2, 3, 3, 4, 4, 5, 5, 5, 5, 6, 6, 8, 9, 0, 0, 1, 1, 2, 2, 2]
    print(Solution().search(arr, 1))

    # for _ in range(1000):
    #     arr = generate_array()
    #     num_set=set(arr)
    #     for num in num_set:
    #         ans=Solution().search(arr,num)
    #         if not ans:
    #             print('Wrong!',arr,num)
    #             exit()
    # print('Pass!')
