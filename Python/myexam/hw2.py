from collections import deque, defaultdict


def func():
    N = int(input())
    time = list(map(int, input().split()))
    depend = dict()
    for i in range(N):
        x = list(map(int, input().split()))
        if len(x) == 1 and x[0] == -1:
            continue
        else:
            depend[i] = [e-1 for e in x]

    indegree = [0] * N
    graph = defaultdict(list)  # graph[i]记录i是谁的依赖项

    for step, deps in depend.items():
        for dep in deps:
            graph[dep].append(step)
            indegree[step] += 1
    q = deque()
    complete_time = [0] * N
    for i in range(N):
        if indegree[i] == 0:
            q.append(i)
            complete_time[i] = time[i]

    while q:
        cur = q.popleft()
        for next_step in graph[cur]:
            complete_time[next_step] = max(complete_time[next_step], complete_time[cur] + time[next_step])
            indegree[next_step] -= 1
            if indegree[next_step] == 0:
                q.append(next_step)

    print(max(complete_time))


if __name__ == "__main__":
    func()
