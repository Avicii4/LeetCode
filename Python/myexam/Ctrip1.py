def convert(string):
    lst = string.split('_')
    lst = [s.title() for s in lst]
    return "".join(lst)


n = int(input())
for _ in range(n):
    s = input().strip()
    print(convert(s))