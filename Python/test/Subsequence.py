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


# 求子串
def substring(s):
    return {s[i:i + k] for i in range(len(s)) for k in range(1, len(s) - i + 1)}


# 求全排列
def all_combinations(s):
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


if __name__ == '__main__':
    string = 'abcd'
    print(dfs(string))
    print(substring(string))
    print(all_combinations(string))
