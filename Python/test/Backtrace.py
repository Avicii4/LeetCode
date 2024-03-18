from typing import List


def all_strings(strs: List[str]):
    def backtrack(start, path):
        if start == len(strs):
            result.append(''.join(path))
            return

        for i in range(len(strs)):
            if not used[i]:
                used[i] = True
                path.append(strs[i])
                backtrack(start + 1, path)
                path.pop()
                used[i] = False

    result = []
    used = [False] * len(strs)
    backtrack(0, [])
    return result


if __name__ == '__main__':
    strs = ['a', 'b', 'c']
    print(all_strings(strs))
