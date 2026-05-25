# Greedy: sort by (costB - costA), send first n to B, rest to A
# TC: O(n log n)  SC: O(n)
def two_city_scheduling_cost(costs):
    cost_diffs = sorted(costs, key=lambda c: c[1] - c[0])
    n = len(cost_diffs) // 2
    total = 0
    for i, cost in enumerate(cost_diffs):
        if i < n:
            total += cost[1]  # send to city B
        else:
            total += cost[0]  # send to city A
    return total


if __name__ == "__main__":
    costs1 = [[10, 20], [30, 200], [400, 50], [30, 20]]
    r1 = two_city_scheduling_cost(costs1)
    print(f"Test 1 - [[10,20],[30,200],[400,50],[30,20]]: {'[PASS]' if r1 == 110 else '[FAIL]'} result={r1} expected=110")

    costs2 = [[259, 770], [448, 54], [926, 667], [184, 139], [840, 118], [577, 469]]
    r2 = two_city_scheduling_cost(costs2)
    print(f"Test 2 - 6 people: {'[PASS]' if r2 == 1859 else '[FAIL]'} result={r2} expected=1859")

    costs3 = [[1, 2], [3, 4]]
    r3 = two_city_scheduling_cost(costs3)
    print(f"Test 3 - [[1,2],[3,4]]: {'[PASS]' if r3 == 5 else '[FAIL]'} result={r3} expected=5")

    costs4 = [[100, 1], [1, 100]]
    r4 = two_city_scheduling_cost(costs4)
    print(f"Test 4 - [[100,1],[1,100]]: {'[PASS]' if r4 == 2 else '[FAIL]'} result={r4} expected=2")

    costs5 = [[10, 10], [10, 10]]
    r5 = two_city_scheduling_cost(costs5)
    print(f"Test 5 - [[10,10],[10,10]]: {'[PASS]' if r5 == 20 else '[FAIL]'} result={r5} expected=20")
