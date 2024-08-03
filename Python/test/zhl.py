# (x,y,width,height)

def cal_iou(rect1, rect2):
    two_total = rect1[2] * rect1[3] + rect2[2] * rect2[3]
    m = area(rect1, rect2)
    n = area(rect2, rect1)
    if m != 0:
        size = m / (two_total - m)
    elif n != 0:
        size = n / (two_total - n)
    else:
        size = 0
    return size


def area(r1, r2):
    # 检查r2的四个顶点是否在r1里面
    # 就有交集，就返回交集面积，否则直接返回0
    x1, y1, w1, h1 = r1
    x2, y2, w2, h2 = r2
    if (x1 < x2 < x1 + w1 and y1 - h1 < y2 < y1):
        return abs(x1 + w1 - x2) * abs(y2 - y1 + h1)
    elif (x1 < x2 < x1 + w1 and y1 - h1 < y2 - h2 < y1):
        return abs(x1 + w1 - x2) * abs(y1 - y2 + h2)
    elif (x1 < x2 + w2 < x1 + w1 and y1 - h1 < y2 < y1):
        return abs(x2 + w2 - x1) * abs(y2 - y1 + h1)
    elif (x1 < x2 + w2 < x1 + w1 and y1 - h1 < y2 - h2 < y1):
        return abs(x2 + w2 - x1) * abs(y1 - y2 + h2)
    else:
        return 0


if __name__ == '__main__':
    # 1. 有交集
    # 1.1 左上顶点

    # r1 = (0, 1, 1, 1)
    # r2 = (0.5, 0.5, 1, 1)
    # print(cal_iou(r1, r2))
    #
    # # 1.2 左下顶点
    # r1 = (0, 1, 1, 1)
    # r2 = (0.5, 1.5, 1, 1)
    # print(cal_iou(r1, r2))
    #
    # # 1.3 右上顶点
    # r1 = (0, 1, 1, 1)
    # r2 = (-0.5, 0.5, 1, 1)
    # print(cal_iou(r1, r2))
    #
    # # 1.4 右下顶点
    # r1 = (0, 1, 1, 1)
    # r2 = (-0.5, 1.5, 1, 1)
    # print(cal_iou(r1, r2))

    # 包含
    r1 = (0, 4, 4, 4)
    r2 = (0, 2, 2, 2)
    print("包含", cal_iou(r1, r2))

    # # 2. 无交集
    # # 2.1 有边重合
    # r1 = (0, 1, 1, 1)
    # r2 = (1, 1, 1, 1)
    # print(cal_iou(r1, r2))
    #
    # # 2.2 完全分散
    # r1 = (0, 1, 1, 1)
    # r2 = (10, 10, 1, 1)
    # print(cal_iou(r1, r2))
