def combination_sum(candidates, target):
    result = []

    def dfs(i, current, remaining):
        if remaining == 0:
            result.append(list(current))
            return
        if remaining < 0 or i == len(candidates):
            return
        # include candidates[i]
        current.append(candidates[i])
        dfs(i, current, remaining - candidates[i])
        current.pop()
        # exclude candidates[i]
        dfs(i + 1, current, remaining)

    dfs(0, [], target)
    return result


def normalize(result):
    return set(tuple(sorted(combo)) for combo in result)


if __name__ == "__main__":
    tests = [
        ([2, 3, 6, 7], 7, [[2, 2, 3], [7]]),
        ([2, 3], 6, [[2, 2, 2], [3, 3]]),
        ([2], 1, []),
        ([1], 1, [[1]]),
        ([1, 2], 4, [[1, 1, 1, 1], [1, 1, 2], [2, 2]]),
    ]

    for i, (candidates, target, expected) in enumerate(tests, 1):
        result = combination_sum(candidates, target)
        status = "PASS" if normalize(result) == normalize(expected) else "FAIL"
        print(f"{status} test {i}: result={normalize(result)} expected={normalize(expected)}")
