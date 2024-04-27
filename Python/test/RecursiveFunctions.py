def hanoi(n):
    step = [0]
    hanoi_process(n, "Left", "Right", "Mid", step)
    print('{} steps in total.'.format(step[0]))


def hanoi_process(n, f, t, h, step):  # from  to  help
    if n == 1:
        print('Move 1 from {} to {}'.format(f, t))
        step[0] += 1
    else:
        hanoi_process(n - 1, f, h, t, step)
        print('Move {} from {} to {}'.format(n, f, t))
        step[0] += 1
        hanoi_process(n - 1, h, t, f, step)


def reverse_stack(stack):
    """逆序一个栈"""
    if len(stack) == 0:
        return
    i = remove_bottom(stack)
    reverse_stack(stack)
    stack.append(i)


def remove_bottom(stack):
    """给一个栈，将栈底的元素抽出并返回，其余元素都不动"""
    result = stack.pop()
    if len(stack) == 0:
        return result
    else:
        last = remove_bottom(stack)
        stack.append(result)
        return last


# 规定 1 和 A 对应，2 和 B 对应，3 和 C 对应……
# 那么一个数字字符串，比如 111就可以转化为：AAA,KA,AK
# 现在给定一个只有数字字符组成的字符串string，返回有多少种转化结果
def convert2string(string) -> int:
    if string is None or len(string) == 0:
        return 0
    return convert2string_process(list(string), 0)


def convert2string_process(arr, idx) -> int:
    if idx == len(arr):  # base case，因为我0~idx-1位置已经全部探索完了，就得到了一种可能的结果，返回1
        return 1
    if arr[idx] == '0':  # 因为0没有对应字母，没有转换方案
        return 0
    if arr[idx] == '1':  # 有两种选择：arr[idx]单独一个转，或者arr[idx]+arr[idx+1]一起转
        res = convert2string_process(arr, idx + 1)
        if idx + 1 < len(arr):
            # i和i+1位置组合转成一个字符（即10~19的转换），后面还有多少可能方案
            res += convert2string_process(arr, idx + 2)
        return res
    if arr[idx] == '2':  # 有两种选择：arr[idx]单独一个转，或者arr[idx]+arr[idx+1]一起转
        res = convert2string_process(arr, idx + 1)
        if idx + 1 < len(arr) and '0' <= arr[idx + 1] <= '6':
            # i和i+1位置组合转成一个字符（即20~26的转换），后面还有多少可能方案
            res += convert2string_process(arr, idx + 2)
        return res
    return convert2string_process(arr, idx + 1)


def knapsack(weights, values, bag):
    return knapsack_process(weights, values, 0, bag)


def knapsack_process(weights, values, idx, rest_weight):
    """只剩rest_weight的空间，返回获得的最大价值"""
    if rest_weight <= 0:
        return 0
    if idx == len(weights):
        return 0
    # 不要当前的货物
    p1 = knapsack_process(weights, values, idx + 1, rest_weight)
    p2 = -float('inf')
    if rest_weight >= weights[idx]:
        # 要当前的货物且空间足够
        p2 = values[idx] + knapsack_process(weights, values, idx + 1, rest_weight - weights[idx])
    return max(p1, p2)


def draw_cards(arr):
    """两个玩家先后抽牌的游戏"""
    n = len(arr)
    return first_hand(arr, 0, n - 1), second_hand(arr, 0, n - 1)


def first_hand(arr, left, right):
    if left == right:
        # 就剩一张牌，那就让先手玩家直接拿走
        return arr[left]
    else:
        # 先手玩家拿左边或者右边的牌，两种情况下择优选择
        m = arr[left] + second_hand(arr, left + 1, right)
        n = arr[right] + second_hand(arr, left, right - 1)
        return max(m, n)


def second_hand(arr, left, right):
    if left == right:
        # 就剩一张牌，那后手玩家什么也拿不到
        return 0
    else:
        # 后手玩家只能从两种情况较差的情况下选择
        m = first_hand(arr, left + 1, right)
        n = first_hand(arr, left, right - 1)
        return min(m, n)


if __name__ == '__main__':
    # weights = [2, 3, 4, 5, 8]  # 物品的重量
    # values = [3, 4, 5, 6, 102]  # 物品的价值
    # bag = 8
    # print(knapsack(weights, values, bag))
    cards = [4,7,9,5]
    res = draw_cards(cards)
    print("Player A:{}, Player B:{}".format(res[0], res[1]))

    # stack = [1, 2, 3, 4, 5]
    # reverse_stack(stack)
    # print(stack)
    # print(convert2string("111"))
