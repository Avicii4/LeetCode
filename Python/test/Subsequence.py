# 求子序列
def dfs(s):
    res = []
    size = len(s)
    total_num = 1 << size
    for idx in range(total_num):
        cur_seq = ''
        for j in range(size):
            if (idx >> j) % 2:  # 最后一位是0，则不取；最后一位是1，则取
                cur_seq += s[j]
        res.append(cur_seq)
    return res


# 求子序列，递归
def subsequence(s):
    def process(s, index, ans, cur_path):
        if index == len(s):
            ans.append(cur_path)
            return
        process(s, index + 1, ans, cur_path)  # 不要当前位置
        process(s, index + 1, ans, cur_path + s[index])  # 要当前位置

    res = []
    process(s, 0, res, "")
    return res


# 求子串
def substring(s):
    return {s[i:i + k] for i in range(len(s)) for k in range(1, len(s) - i + 1)}


# 求全排列
def all_combinations(s):
    """用回溯的方法找全排列"""
    result = []
    visited = [False] * len(s)

    def generate_permutations(s, index, current):
        if index == len(s):
            result.append(current)
            return
        for i in range(len(s)):
            if not visited[i]:
                visited[i] = True
                generate_permutations(s, index + 1, current + s[i])
                visited[i] = False

    generate_permutations(s, 0, '')
    return result


# 求全排列（但是会有重复）
def all_combinations_2(s):
    """用交换的思想实现全排列"""

    def process(arr, i, ans):
        if i == len(arr):
            ans.append(''.join(arr))
        for j in range(i, len(arr)):  # 尝试：arr[i]及其以后的字符都有机会来到i位置
            arr[i], arr[j] = arr[j], arr[i]
            process(arr, i + 1, ans)
            arr[i], arr[j] = arr[j], arr[i]  # 恢复现场

    string_list = list(s)
    res = []
    process(string_list, 0, res)
    return res


# 求全排列，且不重复
def all_combinations_nonrepeat(s):
    def process(arr, i, ans):
        if i == len(arr):
            ans.append(''.join(arr))
            return

        visited = set()
        for j in range(i, len(arr)):
            # 查看当前字符有没有在i位置出现过，如果已经出现过，直接不考虑
            if arr[j] not in visited:
                visited.add(arr[j])
                arr[i], arr[j] = arr[j], arr[i]
                process(arr, i + 1, ans)
                arr[i], arr[j] = arr[j], arr[i]

    string_list = list(s)
    res = []
    process(string_list, 0, res)
    return res


if __name__ == '__main__':
    string = 'aba'
    # print(dfs(string))
    print(subsequence(string))
    # print(substring(string))
    # print(all_combinations_nonrepeat(string))
