def walk(string):
    # W 向前
    # A 左转90
    # D 右转90
    # S 忽略
    coord = [0, 0]
    # face = [0, 1, 2, 3]  # list('东南西北')
    cur_face = 3
    for char in string:
        if char == 'S':
            continue
        elif char == 'A':
            cur_face -= 1
            if cur_face == -1:
                cur_face = 3
        elif char == 'D':
            cur_face += 1
            if cur_face == 4:
                cur_face = 0
        elif char == 'W':
            if cur_face == 3:
                coord[1] += 1
            elif cur_face == 1:
                coord[1] -= 1
            elif cur_face == 0:
                coord[0] += 1
            else:
                coord[0] -= 1
    print(coord[0], coord[1])


s = input().strip()
walk(s)
