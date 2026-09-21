def jelly_beans(n, operations):
    diff = [0] * (n + 2)

    for left, right, beans in operations:
        diff[left] += beans
        diff[right + 1] -= beans

    result = [0] * n
    current = 0
    for i in range(1, n + 1):
        current += diff[i]
        result[i - 1] = current

    return result


if __name__ == "__main__":
    n = 5
    operations = [
        [1, 3, 10],
        [2, 5, 5],
        [3, 4, 2],
    ]

    result = jelly_beans(n, operations)
    expected = [10, 15, 17, 7, 5]
    status = "PASS" if result == expected else "FAIL"
    print(f"Output: {result} | Expected: {expected} | {status}")