from collections import Counter


def convertible(s1, s2):
    cnt1, cnt2 = Counter(s1), Counter(s2)
    a = len(cnt1.keys() - cnt2.keys())
    b = len(cnt2.keys() - cnt1.keys())
    if a == 0 or b == 0:
        return 'false'
    if a>b:
        return 'true' if len(cnt1 - cnt2) <= a else 'false'
    else:
        return 'true' if len(cnt2 - cnt1) <= b else 'false'


s1, s2 = input().split()
print(convertible(s1, s2))
# aabcc ccdda  aabcc ccdee
