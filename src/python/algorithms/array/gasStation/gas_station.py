# Greedy  TC: O(n) SC: O(1)
def can_complete_circuit(gas, cost):
    if sum(gas) < sum(cost):
        return -1

    total = 0
    res = 0

    for i in range(len(gas)):
        total += gas[i] - cost[i]

        if total < 0:
            total = 0
            res = i + 1

    return res


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 3, 4, 5], [3, 4, 5, 1, 2], 3),
        ([2, 3, 4],        [3, 4, 3],       -1),
        ([5, 1, 2, 3, 4],  [4, 4, 1, 5, 1], 4),
        ([3, 3, 4],        [3, 4, 4],       -1),
        ([1, 2],           [2, 1],           1),
    ]

    for gas, cost, expected in test_cases:
        result = can_complete_circuit(gas, cost)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
