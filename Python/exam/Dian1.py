class Solution:
    def binary_fill(self , n: int) -> int:
        bn=list(bin(n)[2:])
        flag = False
        for i in range(len(bn)-1,-1,-1):
            if flag:
                bn[i]="1"
            elif bn[i]=="1":
                flag=True
            else:
                continue
        return int("".join(bn),2)

if __name__ == '__main__':
    num = 18
    print(bin(num))
    print(Solution().binary_fill(18))
