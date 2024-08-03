n = int(input())

data = []
for _ in range(n):
    number,c =input().split()
    data.append((int(number),c))

res =0
for elem in data:
    if elem[1]=='O':
        res+=elem[0]

print(res)
