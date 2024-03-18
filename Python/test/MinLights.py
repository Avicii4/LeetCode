def violence(road):
    if not road:
        return 0
    return process(list(road), 0, set())


def process(road, index, lights):
    """
    遍历所有能照亮.的方案，且在这些方案中，最少需要多少灯
    :param road: 路的字符串
    :param index: 当前位置
    :param lights: 安排了灯的位置，记录为road字符串的下标
    :return:
    """
    if index == len(road):
        for i in range(len(road)):  # 本轮遍历结束了
            if road[i] == '.':
                # 灯无法照亮所有居民区，返回
                if (i - 1) not in lights and i not in lights and (i + 1) not in lights:
                    return float('inf')
        return len(lights)
    else:
        no = process(road, index + 1, lights)  # 当前位置不放灯的情况
        yes = float('inf')  # 当前位置放灯的情况（需要当前位置是.）
        if road[index] == '.':
            lights.add(index)
            yes = process(road, index + 1, lights)
            lights.remove(index)  # 这里要回溯恢复现场
        return min(no, yes)


def greedy(road):
    index = 0
    light = 0
    while index < len(road):
        if road[index] == 'X':
            index += 1
        else:  # idx位置是.
            light += 1  # 不管怎么样会放一盏灯，具体放哪里是下面讨论的
            if index + 1 == len(road):  # 此时我把灯放在idx位置，且流程结束了
                break
            else:
                if road[index + 1] == 'X':  # 此时我把灯放在idx位置，所以直接跳到idx+2位置
                    index += 2
                else:  # 此时我把灯放在idx+1位置，所以直接跳到idx+3位置
                    index += 3
    return light


if __name__ == '__main__':
    road = "..X.X."
    print(violence(road))
    print(greedy(road))