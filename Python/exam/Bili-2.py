def max_length(string):
    stack = []
    idx, res = len(string) - 1, 0
    while string[idx] == '(' and idx > 0:
        idx -= 1
    string = string[:idx + 1]
    if string[0] == ')':
        return 0
    m = res
    for ch in string:
        if ch == '(':
            stack.append('(')
            m = res
        else:
            if len(stack) > 0 and stack[-1] == '(':
                stack.pop()
                res += 2
    if len(stack) == 0:
        return m
    else:
        return 0


n = int(input().strip())
s = input().strip()
print(max_length(s))
