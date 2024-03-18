from typing import List
import random


class Program:
    def __init__(self, start, end):
        self.start = start
        self.end = end


def violence(programs: List[Program]) -> int:
    if not programs or len(programs) == 0:
        return 0
    return process_violence(programs, 0, 0)


def process_violence(programs, arranged, cur_time):
    """
    :param programs: 剩下没有安排的会议
    :param arranged: 已经安排了多少会议的数量
    :param cur_time: 目前来到的时间点
    :return: 最大的安排会议的数量
    """
    if len(programs) == 0:
        return arranged
    max_num = arranged
    # 当前安排的会议是什么会，每一个都枚举
    for i in range(len(programs)):
        if programs[i].start >= cur_time:
            next = programs[:i] + programs[i + 1:]
            max_num = max(max_num, process_violence(next, arranged + 1, programs[i].end))
    return max_num


def greedy(programs):
    programs.sort(key=lambda x: x.end)
    cur_time = 0
    res = 0
    for i in range(len(programs)):
        if cur_time <= programs[i].start:
            res += 1
            cur_time = programs[i].end
    return res


def generate_programs(program_size, time_max):
    ans = []
    for _ in range(random.randint(10, program_size)):
        r1 = random.randint(0, time_max)
        r2 = random.randint(0, time_max)
        if r1 == r2:
            ans.append(Program(r1, r1 + 1))
        else:
            ans.append(Program(min(r1, r2), max(r1, r2)))
    return ans


if __name__ == '__main__':
    program_size = 100
    time_max = 50
    programs = generate_programs(program_size, time_max)
    ground_truth = violence(programs)
    ans = greedy(programs)
    print(ground_truth, ans)
