from collections import Counter
from itertools import combinations
import copy


def can_form_four(cards):
    if not cards:
        return True
    cccc = copy.deepcopy(cards)
    for card, count in cccc.items():
        if count >= 3:
            cards[card] -= 3
            if cards[card] == 0:
                del cards[card]
            if can_form_four(cards):
                return True
            cards[card] = count

    sort_cards = sorted(cards.keys())
    for i in range(len(sort_cards) - 2):
        if sort_cards[i] + 1 in cards and sort_cards[i] + 2 in cards:
            cards[sort_cards[i]] -= 1
            cards[sort_cards[i] + 1] -= 1
            cards[sort_cards[i] + 2] -= 1

            if cards[sort_cards[i]] == 0:
                del cards[sort_cards[i]]
            if cards[sort_cards[i] + 1] == 0:
                del cards[sort_cards[i] + 1]
            if cards[sort_cards[i] + 2] == 0:
                del cards[sort_cards[i] + 2]
            if can_form_four(cards):
                return True

            cards[sort_cards[i]] += 1
            cards[sort_cards[i] + 1] += 1
            cards[sort_cards[i] + 2] += 1
    return False


def hu(n):
    if n <= 3:
        return 0
    nums = []
    for i in range(n):
        nums.extend([i + 1 for _ in range(4)])
    res = 0
    for subseq in set(combinations(nums, 14)):
        if ifhu(subseq):
            res += 1
            print(subseq)
    return res


def ifhu(cards):
    cnt = Counter(cards)
    ccc = copy.deepcopy(cnt)
    for card, count in ccc.items():
        if count >= 2:
            cnt[card] -= 2  # 先拿出来做对子
            if cnt[card] == 0:
                del cnt[card]
            if can_form_four(cnt):
                return True
            cnt[card] += 2
    return False


n = int(input())
print(hu(n))
