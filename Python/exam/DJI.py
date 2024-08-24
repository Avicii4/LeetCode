def numberOfPatrolBlocks(block):
    visited = [[False for _ in range(block_cols)] for _ in range(block_rows)]
    cur_direction = 0  # 0向右 1向下 2向左 3向上
    return dfs(block, 0, 0, visited, cur_direction,0)


def dfs(mat, x, y, visited, cur_direction,turn):
    if x < 0 or x >= block_rows or y < 0 or y >= block_cols or turn==4:
        return 0
    if mat[x][y] == 1 or visited[x][y]:
        dfs(mat,x,y,visited,(cur_direction+1)%4,turn+1)
    visited[x][y] = True
    count = 1
    turn=0
    if cur_direction == 0:
        count += dfs(mat, x, y + 1, visited, cur_direction,turn)
    elif cur_direction == 1:
        count += dfs(mat, x + 1, y, visited, cur_direction,turn)
    elif cur_direction == 2:
        count += dfs(mat, x, y - 1, visited, cur_direction,turn)
    else:
        count += dfs(mat, x - 1, y, visited, cur_direction,turn)
    return count


block_rows, block_cols = list(map(int, input().split()))

block = []
for block_i in range(block_rows):
    block.append(list(map(int, input().split())))

res = numberOfPatrolBlocks(block)

print(res)
