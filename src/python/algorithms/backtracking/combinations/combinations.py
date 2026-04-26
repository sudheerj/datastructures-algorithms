def combine(n, k):
    result = []
    def backtrack(start, comb):
        if len(comb) == k:
            result.append(comb[:])
            return
        for i in range(start, n + 1):
            comb.append(i)
            backtrack(i + 1, comb)
            comb.pop()
    backtrack(1, [])
    return result

if __name__ == "__main__":
    test_cases = [
        (4, 2),  # [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        (1, 1),  # [[1]]
        (3, 1),  # [[1],[2],[3]]
        (3, 3),  # [[1,2,3]]
        (5, 3)   # 10 combinations
    ]
    for i, (n, k) in enumerate(test_cases, 1):
        print(f"Test case {i}: n={n}, k={k}")
        res = combine(n, k)
        print("Output:", res)
        print("Total combinations:", len(res))
