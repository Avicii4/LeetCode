class Solution:
    def FindSpecialUser(self, n, relations):
        followers = [set() for _ in range(n + 1)]  # 存储每个人被谁关注了
        has_follow = [False for _ in range(n + 1)]  # 存储是否关注了别人
        for arr in relations:
            followers[arr[1]].add(arr[0])
            has_follow[arr[0]] = True
        print(followers)
        print(has_follow)
        for i in range(1, n + 1):
            l = len(followers[i])
            if l == n - 1 and has_follow[i] == False:
                return i
        return -1


if __name__ == '__main__':
    arr = [[1, 2]]
    print(Solution().FindSpecialUser(2, arr))


class UnionFindSet:
    def __init__(self, size):
        self.parent = list(range(size))

    def find(self, p):
        if self.parent[p] != p:
            self.parent[p] = self.find(self.parent[p])
        return self.parent[p]

    def union(self, p, q):
        rootp = self.find(p)
        rootq = self.find(q)

        if rootp != rootq:
            self.parent[rootq] = rootp

    def get_set(self):
        root_set = set()
        for key in self.parent:
            root_set.add(self.find(key))
        return root_set
