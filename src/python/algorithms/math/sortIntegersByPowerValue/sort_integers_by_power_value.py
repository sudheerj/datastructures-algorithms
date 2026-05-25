import sys
sys.setrecursionlimit(10000)


def power(x, memo):
    if x in memo:
        return memo[x]
    if x % 2 == 0:
        steps = 1 + power(x // 2, memo)
    else:
        steps = 1 + power(3 * x + 1, memo)
    memo[x] = steps
    return steps


def get_kth(low, high, k):
    memo = {1: 0}
    pairs = []
    for i in range(low, high + 1):
        pairs.append((i, power(i, memo)))
    pairs.sort(key=lambda x: (x[1], x[0]))
    return pairs[k - 1][0]


if __name__ == "__main__":
    r1 = get_kth(12, 15, 2)
    print(f"Test 1 - lo=12 hi=15 k=2: {'[PASS]' if r1 == 13 else '[FAIL]'} result={r1} expected=13")

    r2 = get_kth(7, 11, 4)
    print(f"Test 2 - lo=7 hi=11 k=4: {'[PASS]' if r2 == 7 else '[FAIL]'} result={r2} expected=7")

    r3 = get_kth(1, 5, 3)
    print(f"Test 3 - lo=1 hi=5 k=3: {'[PASS]' if r3 == 4 else '[FAIL]'} result={r3} expected=4")

    r4 = get_kth(3, 5, 2)
    print(f"Test 4 - lo=3 hi=5 k=2: {'[PASS]' if r4 == 5 else '[FAIL]'} result={r4} expected=5")

    r5 = get_kth(1, 3, 1)
    print(f"Test 5 - lo=1 hi=3 k=1: {'[PASS]' if r5 == 1 else '[FAIL]'} result={r5} expected=1")
