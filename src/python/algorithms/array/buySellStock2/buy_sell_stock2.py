# Approach 1: Greedy (accumulate positive daily gains) — O(n) time, O(1) space
def max_profit1(prices):
    max_profit = 0
    for i in range(1, len(prices)):
        if prices[i] - prices[i - 1] > 0:
            max_profit += prices[i] - prices[i - 1]
    return max_profit


# Approach 2: Peak-Valley — O(n) time, O(1) space
def max_profit2(prices):
    max_profit = 0
    i = 0
    while i < len(prices) - 1:
        while i < len(prices) - 1 and prices[i] >= prices[i + 1]:
            i += 1
        valley = prices[i]
        while i < len(prices) - 1 and prices[i] <= prices[i + 1]:
            i += 1
        peak = prices[i]
        max_profit += peak - valley
    return max_profit


if __name__ == "__main__":
    t1, t2, t3, t4, t5 = [7,1,5,3,6,4], [1,2,3,4,5], [7,6,4,3,1], [1,2,1,3,1,4], [2,1,2,0,1]
    e1, e2, e3, e4, e5 = 7, 4, 0, 6, 2

    # Approach 1: greedy
    r1 = max_profit1(t1)
    print(f"Test 1 (greedy): {'[PASS]' if r1 == e1 else '[FAIL]'} result={r1} expected={e1}")
    r2 = max_profit1(t2)
    print(f"Test 2 (greedy): {'[PASS]' if r2 == e2 else '[FAIL]'} result={r2} expected={e2}")
    r3 = max_profit1(t3)
    print(f"Test 3 (greedy): {'[PASS]' if r3 == e3 else '[FAIL]'} result={r3} expected={e3}")
    r4 = max_profit1(t4)
    print(f"Test 4 (greedy): {'[PASS]' if r4 == e4 else '[FAIL]'} result={r4} expected={e4}")
    r5 = max_profit1(t5)
    print(f"Test 5 (greedy): {'[PASS]' if r5 == e5 else '[FAIL]'} result={r5} expected={e5}")

    # Approach 2: peak-valley
    r6 = max_profit2(t1)
    print(f"Test 1 (peak-valley): {'[PASS]' if r6 == e1 else '[FAIL]'} result={r6} expected={e1}")
    r7 = max_profit2(t2)
    print(f"Test 2 (peak-valley): {'[PASS]' if r7 == e2 else '[FAIL]'} result={r7} expected={e2}")
    r8 = max_profit2(t3)
    print(f"Test 3 (peak-valley): {'[PASS]' if r8 == e3 else '[FAIL]'} result={r8} expected={e3}")
    r9 = max_profit2(t4)
    print(f"Test 4 (peak-valley): {'[PASS]' if r9 == e4 else '[FAIL]'} result={r9} expected={e4}")
    r10 = max_profit2(t5)
    print(f"Test 5 (peak-valley): {'[PASS]' if r10 == e5 else '[FAIL]'} result={r10} expected={e5}")
