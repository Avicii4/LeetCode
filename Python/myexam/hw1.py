from collections import deque, defaultdict


def func():
    row = int(input())
    col = int(input())
    server = list(map(int, input().split()))  # 机房
    home = list(map(int, input().split()))  # 校区
    block_num = int(input())
    block = defaultdict(list)  # 障碍点位置
    for _ in range(block_num):
        a, b = list(map(int, input().split()))
        block[a].append(b)

    dist = [[-1] * col for _ in range(row)]
    q = deque()  # 队列BFS
    dist[server[0]][server[1]] = 0
    q.append((server[0], server[1]))
    flag = False
    while q:
        i, j = q.popleft()
        for x, y in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
            if 0 <= x < row and 0 <= y < col and (not search(x,y,block)):
                if dist[x][y] == -1:
                    dist[x][y] = dist[i][j] + 1
                    q.append((x, y))
                if x == home[0] and y == home[1]:
                    flag = True
                    break
        if flag:
            break

    print(dist[home[0]][home[1]])


def search(x, y, block):
    if x in block and y in block[x]:
        return True
    else:
        return False


if __name__ == "__main__":
    func()
