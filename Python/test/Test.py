from time import time
from typing import List
import random
from Tree import TreeNode


def bubble_sort(nums: List[int]):
    n = len(nums)
    for i in range(n - 1, 0, -1):
        flag = True  # 在一轮中是否产生交换，没交换则为False
        for j in range(i):
            if not flag:
                break
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
                flag = True


def bubble_sort_no(nums: List[int]):
    n = len(nums)
    for i in range(n - 1, 0, -1):
        for j in range(i):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]


def insertion_sort(nums: List[int]):
    n = len(nums)
    for i in range(1, n):
        tmp = nums[i]
        j = i - 1
        while j >= 0 and tmp < nums[j]:  # 注意这里用while
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = tmp


def selection_sort(nums: List[int]):
    n = len(nums)
    for i in range(n):
        cur = i
        for j in range(i + 1, n):  # 注意从i+1位置开始搜
            if nums[cur] > nums[j]:
                cur = j
        nums[i], nums[cur] = nums[cur], nums[i]


def heap_sort(nums: List[int]):
    if nums is None or len(nums) < 2:
        return

    for i in range(len(nums) - 1, -1, -1):
        heapify(nums, i, len(nums))

    heap_size = len(nums) - 1
    nums[0], nums[heap_size] = nums[heap_size], nums[0]
    while heap_size > 0:
        heapify(nums, 0, heap_size)
        heap_size -= 1
        nums[0], nums[heap_size] = nums[heap_size], nums[0]


def heapify(nums, index, heap_size):
    lchild = 2 * index + 1
    while lchild < heap_size:
        larger = lchild
        if lchild + 1 < heap_size and nums[lchild + 1] > nums[lchild]:
            larger += 1
        if nums[index] > nums[larger]:
            larger = index
        if larger == index:
            break
        nums[index], nums[larger] = nums[larger], nums[index]
        index = larger
        lchild = 2 * index + 1


def quick_sort(nums: List[int]):
    if nums is None or len(nums) < 2:
        return
    quick_process(nums, 0, len(nums) - 1)


def quick_process(nums, left, right):
    if left >= right:
        return
    random_loc = random.randint(left, right)
    nums[random_loc], nums[right] = nums[right], nums[random_loc]
    equal_area = partition(nums, left, right)
    quick_process(nums, left, equal_area[0] - 1)
    quick_process(nums, equal_area[1] + 1, right)


def partition(nums, left, right):
    if left > right:
        return -1, -1
    if left == right:
        return left, right
    less = left - 1
    more = right
    i = left
    while i < more:
        if nums[i] == nums[right]:
            i += 1
        elif nums[i] < nums[right]:
            less += 1
            nums[less], nums[i] = nums[i], nums[less]
            i += 1
        else:
            more -= 1
            nums[more], nums[i] = nums[i], nums[more]
    nums[more], nums[right] = nums[right], nums[more]
    return less + 1, more


def pre_no_recur(head: TreeNode):
    if head:
        stack = [head]
        while len(stack) > 0:
            pop_node = stack.pop()
            print(pop_node.val)
            if pop_node.right:
                stack.append(pop_node.right)
            if pop_node.left:
                stack.append(pop_node.left)


def in_no_recur(head: TreeNode):
    if head:
        stack = [head]
        while len(stack) > 0 or head:
            if head:
                stack.append(head)
                head = head.left
            else:
                pop_node = stack.pop()
                print(pop_node.val)
                head = pop_node.right


def bfs(head: TreeNode):
    if head:
        queue = [head]
        while len(queue) > 0:
            node = queue.pop(0)
            print(node.val)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)


def max_depth(head: TreeNode):
    if not head:
        return 0
    queue = [head]
    res = 0
    cur_end, next_end = None, None
    cur_level_width = 0

    while len(queue) > 0:
        node = queue.pop(0)
        cur_level_width += 1
        if node.left:
            queue.append(node.left)
            next_end = node.left
        if node.right:
            queue.append(node.right)
            next_end = node.right
        if node == cur_end:
            if cur_level_width > res:
                res = cur_level_width
            cur_level_width = 0
            cur_end = next_end
    return res


def min_dictionary_order(strs):
    n = len(strs)
    for i in range(n - 1, 0, -1):
        for j in range(i):
            if strs[j] + strs[j + 1] > strs[j + 1] + strs[j]:
                strs[j], strs[j + 1] = strs[j + 1], strs[j]
    return "".join(strs)


if __name__ == '__main__':
    min_dictionary_order(['b', 'c', 'a'])
    # 排序正确性测试
    for _ in range(100):
        array_length = random.randint(1, 1000)
        random_array_1 = [random.randint(-1000, 1000) for _ in range(array_length)]
        random_array_2 = random_array_1.copy()
        quick_sort(random_array_1)
        random_array_2.sort()
        if not random_array_1 == random_array_2:
            print('Wrong!')
            break
    else:
        print('Success!')

    # bubble flag 测试： 至少对于Python来说，这种优化没有效果，if判断还平添时间成本
    # array = [random.randint(-100000, 100000) for _ in range(10000)]
    # array_copy = array.copy()
    # t1 = time()
    # bubble_sort(array)
    # print('With flag: ', time() - t1)
    # t2 = time()
    # bubble_sort_no(array_copy)
    # print('Without flag:', time() - t2)
