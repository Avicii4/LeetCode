n,q=list(map(int,input().split()))

keywords = input().split()

items=[]
score=[]
for _ in range(n):
    name = input().split()[0]
    attrs = input().split()
    items.append([name,attrs])
    score.append([name,0])


for i in range(q):
    for j in range(n):
        if keywords[i] in items[j][1]:
            score[j][1]+=1

score.sort(key=lambda x:-x[1])
for elem in score:
    print(elem[0])







