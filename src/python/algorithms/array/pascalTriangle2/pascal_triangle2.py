# Copy from previous row TC: O(k^2) SC: O(k)
def get_row1(row_index: int) -> list[int]:
    row = [1]
    for i in range(1, row_index + 1):
        next_row = [1]
        for j in range(1, i):
            next_row.append(row[j - 1] + row[j])
        next_row.append(1)
        row = next_row
    return row


# In-place right-to-left TC: O(k^2) SC: O(k)
def get_row2(row_index: int) -> list[int]:
    row = [1] * (row_index + 1)
    for i in range(2, row_index + 1):
        for j in range(i - 1, 0, -1):
            row[j] = row[j - 1] + row[j]
    return row


if __name__ == "__main__":
    test_cases = [
        (0, [1]),
        (1, [1, 1]),
        (2, [1, 2, 1]),
        (3, [1, 3, 3, 1]),
        (4, [1, 4, 6, 4, 1]),
        (5, [1, 5, 10, 10, 5, 1]),
    ]

    print("=== get_row1 (copy from previous row) ===")
    for row_index, expected in test_cases:
        result = get_row1(row_index)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] row_index={row_index} result={result} expected={expected}")

    print("=== get_row2 (in-place right-to-left) ===")
    for row_index, expected in test_cases:
        result = get_row2(row_index)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] row_index={row_index} result={result} expected={expected}")
