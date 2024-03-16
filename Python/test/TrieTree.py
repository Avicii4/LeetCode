class TrieNode:
    def __init__(self):
        self.pas, self.end = 0, 0
        self.nexts = {}


class TrieTree:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        cur = self.root
        cur.pas += 1
        for c in word:
            if c not in cur.nexts:
                cur.nexts[c] = TrieNode()
            cur = cur.nexts[c]
            cur.pas += 1
        cur.end += 1  # 若是word的最后一个字符，end+=1

    def search(self, word):
        """
        查询 word 加入的次数
        """
        cur = self.root
        for c in word:
            if c not in cur.nexts:
                return 0
            cur = cur.nexts[c]
        return cur.end

    def delete(self, word):
        if self.search(word) > 0:  # 删除之前先看看word在不在树中
            # 删除方式是，沿途pas-=1
            cur = self.root
            cur.pas -= 1
            for c in word:
                cur.nexts[c].pas -= 1
                if cur.nexts[c].pas == 0:  # 检查下方节点是不是空了
                    cur.nexts[c] = None  # 直接修改父节点的指针为空
                    return
                cur = cur.nexts[c]
            cur.end -= 1  # 到最后一个字符还要end-=1
        print("Word to be deleted does not exist.")

    def prefix_num(self, pre_string):
        """
        所有加入的字符串，有多少是以pre_string为前缀
        """
        cur = self.root
        for c in pre_string:
            if c not in cur.nexts:
                return 0
            cur = cur.nexts[c]
        return cur.pas


if __name__ == '__main__':
    tree = TrieTree()
    word_list = ['abc', 'abcde', 'badd', 'ab', 'a', 'abbd', 'abc']
    for w in word_list:
        tree.insert(w)
    print(tree.search('abc'))
    print(tree.prefix_num('a'))
    print(tree.prefix_num('ab'))
    print(tree.prefix_num('abc'))
    tree.delete('ab')
    tree.delete('bb')
    print(tree.search('ab'))
