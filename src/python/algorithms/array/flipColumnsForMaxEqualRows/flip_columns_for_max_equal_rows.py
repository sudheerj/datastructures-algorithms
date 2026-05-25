# Normalize rows with hashing — O(m*n) time, O(m*n) space
def max_equal_rows_after_flips(matrix):
    count = {}
    for row in matrix:
        # normalize: if row starts with 1, flip all bits
        key = tuple(1 - b if row[0] == 1 else b for b in row)
        count[key] = count.get(key, 0) + 1
    return max(count.values())


if __name__ == "__main__":
    r1 = max_equal_rows_after_flips([[0,1],[1,1]])
    print(f"Test 1: {'[PASS]' if r1 == 1 else '[FAIL]'} result={r1} expected=1")

    r2 = max_equal_rows_after_flips([[0,1],[1,0]])
    print(f"Test 2: {'[PASS]' if r2 == 2 else '[FAIL]'} result={r2} expected=2")

    r3 = max_equal_rows_after_flips([[0,0,0],[0,0,1],[1,1,0]])
    print(f"Test 3: {'[PASS]' if r3 == 2 else '[FAIL]'} result={r3} expected=2")

    r4 = max_equal_rows_after_flips([[0,1,0,0],[0,0,1,0],[1,0,1,1]])
    print(f"Test 4: {'[PASS]' if r4 == 2 else '[FAIL]'} result={r4} expected=2")

    r5 = max_equal_rows_after_flips([[0,0,1,1],[1,1,0,0],[0,0,1,0]])
    print(f"Test 5: {'[PASS]' if r5 == 2 else '[FAIL]'} result={r5} expected=2")
