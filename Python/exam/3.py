def cut(n, q, color, cuts):
    unique_color = len(set(color))
    left, right = 0, n - 1
    for cut in cuts:
        if cut[0] == 'L':
            end = cut[1] + left
            if end < n:
                print(len(set(color[left:end + 1])))
                left = (end + 1) % n
            else:
                if end // n <= 1:  # 不满一整条
                    a = len(set(color[left:]))
                    left = (end + 1) % n
                    b = len(set(color[0:left]))
                    print(a + b)

                else:
                    print(unique_color)
                    left = (end + 1) % n
        else:
            end = n - cut[1]
            if end >= 0:
                print(len(set(color[end:right + 1])))
                right = n - (end - 1)
            else:
                if (-end) // n <= 1:
                    a = len(set(color[(-end):right + 1]))
                    right = n - (end - 1)
                    b = len(set(color[0:right]))
                    print(a + b)


n, q = map(int, input().split())
color = list(map(int, input().split()))
cuts = []
for _ in range(q):
    c, x = input().split()
    cuts.append((c, x))
