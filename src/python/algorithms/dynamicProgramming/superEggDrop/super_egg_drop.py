# Super Egg Drop (LC 887)
# DP + Binary search  TC: O(k * n * log n)  SC: O(k * n)

from functools import lru_cache


def super_egg_drop(n: int, k: int) -> int:
    @lru_cache(maxsize=None)
    def dfs(floors: int, eggs: int) -> int:
        if floors <= 1:
            return floors
        if eggs == 1:
            return floors

        low, high = 1, floors
        min_attempts = float('inf')

        while low <= high:
            mid = low + (high - low) // 2
            break_case   = dfs(mid - 1, eggs - 1)  # egg breaks
            survive_case = dfs(floors - mid, eggs)  # egg survives
            attempts = 1 + max(break_case, survive_case)
            min_attempts = min(min_attempts, attempts)

            if break_case < survive_case:
                low = mid + 1
            else:
                high = mid - 1

        return min_attempts

    return dfs(n, k)


if __name__ == "__main__":
    test_cases = [
        (1,  1, 1),
        (2,  1, 2),
        (6,  2, 3),
        (10, 2, 4),
        (14, 3, 4),
        (2,  2, 2),
    ]

    for n, k, expected in test_cases:
        result = super_egg_drop(n, k)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] n={n} k={k} result={result} expected={expected}")
