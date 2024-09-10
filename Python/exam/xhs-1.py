from collections import Counter

def remaining_robot(n, m, grid):
    res = 0
    for i in range(n):
        for j in range(m):
            path = [grid[i][j]]
            if dfs(i, j, 0, path, n, m, grid):
                res += 1
    return res


def dfs(x, y, cur_step, path, n, m, grid):
    if cur_step == 1e8:
        return True
    nx, ny = x, y
    if grid[x][y] == 'L':
        ny -= 1
    elif grid[x][y] == 'R':
        ny += 1
    elif grid[x][y] == 'U':
        nx -= 1
    elif grid[x][y] == 'D':
        nx += 1
    if 0 <= nx < n and 0 <= ny < m:
        path.append(grid[nx][ny])
        if is_repeat(path):
            return True
        else:
            return dfs(nx, ny, cur_step + 1, path, n, m, grid)
    else:  # 走出去了
        return False


def is_repeat(arr):
    n = len(arr)
    for i in range(n):
        if (n - i) % 2 == 1:
            continue
        else:
            half = (n - i) // 2
            a = ''.join(arr[i:i + half])
            b = ''.join(arr[i + half:])
            if a == b and len(set(a)) > 1:
                cnt =Counter(a)
                if cnt['R']==cnt['L'] and cnt['D']==cnt['U']:
                    return True
    return False


n, m = map(int, input().split())
grid = []
for _ in range(n):
    l = list(input())
    grid.append(l)

print(remaining_robot(n, m, grid))
