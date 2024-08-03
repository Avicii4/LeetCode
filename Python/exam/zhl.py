def match(string):
    stack = []
    left = ['(', '[', '{']
    right = [')', ']', '}']
    cur_prior = 3   # 当前优先级
    for c in string:
        if c in left:
            if cur_prior >= left.index(c):
                stack.append(c)
                if cur_prior == 3:
                    cur_prior = left.index(c)
                cur_prior = cur_prior if cur_prior > left.index(c) else left.index(c)
            else:
                return False
        elif c in right:
            if len(stack) > 0 and left.index(stack[-1]) == right.index(c):
                stack.pop()
            else:
                return False
        else:
            return False
    return len(stack) == 0


if __name__ == '__main__':
    # print(match('[()]'))
    print(match('([])'))
    # print(match('(())'))
    # print(match("{((()())())[()]}()"))
    # print(match(')'))
    # print(match('{()[]}'))
