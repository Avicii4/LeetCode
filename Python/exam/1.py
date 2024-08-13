def try_pwd(n, truth, lst):
    least, most = 0, 0
    lst = list(set(lst))
    for string in lst:
        if len(string) < len(truth):
            least += 1
        if len(string) <= len(truth):
            most += 1

    print(least + 1, most)


n = int(input().strip())
truth = input().strip()
lst = []
for _ in range(n):
    lst.append(input())

try_pwd(n, truth, lst)
