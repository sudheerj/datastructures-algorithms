# Reaching Points (LC 780)
# Backward simulation  TC: O(log(max(tx, ty)))  SC: O(1)

def reaching_points(sx: int, sy: int, tx: int, ty: int) -> bool:
    while tx >= sx and ty >= sy:
        if tx == sx and ty == sy:
            return True

        if tx > ty:
            if ty == sy:
                return (tx - sx) % ty == 0
            tx %= ty
        else:
            if tx == sx:
                return (ty - sy) % tx == 0
            ty %= tx

    return False


if __name__ == "__main__":
    test_cases = [
        (1, 1, 3, 5,   True),
        (1, 1, 2, 2,   False),
        (3, 5, 3, 5,   True),
        (1, 2, 5, 4,   True),
        (2, 3, 8, 3,   True),
        (1, 3, 10, 12, False),
    ]

    for sx, sy, tx, ty, expected in test_cases:
        result = reaching_points(sx, sy, tx, ty)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] sx={sx} sy={sy} tx={tx} ty={ty} result={result} expected={expected}")
