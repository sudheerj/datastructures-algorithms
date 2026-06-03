# Eliminate row or column TC: O(m+n) SC: O(1)
def search_matrix(matrix: list[list[int]], target: int) -> bool:
    rows, cols = len(matrix), len(matrix[0])
    row, col = 0, cols - 1  # start from top-right

    while row < rows and col >= 0:
        if matrix[row][col] == target:
            return True
        if matrix[row][col] < target:
            row += 1   # move down
        else:
            col -= 1   # move left

    return False


if __name__ == "__main__":
    m1 = [
        [1,  4,  7,  11, 15],
        [2,  5,  8,  12, 19],
        [3,  6,  9,  16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30],
    ]
    m2 = [[1, 1]]
    m3 = [[1, 3, 5], [2, 4, 6], [3, 5, 7]]

    test_cases = [
        (m1, 5,  True),
        (m1, 20, False),
        (m1, 15, True),
        (m2, 2,  False),
        (m2, 1,  True),
        (m3, 4,  True),
    ]

    for matrix, target, expected in test_cases:
        result = search_matrix(matrix, target)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] target={target} result={result} expected={expected}")
