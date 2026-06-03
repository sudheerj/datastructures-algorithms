# Robot Bounded in Circle (LC 1041)
# Simulation  TC: O(n)  SC: O(1)

def is_robot_bounded(instructions: str) -> bool:
    dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # North, East, South, West
    dir = 0  # facing north
    x, y = 0, 0

    for ch in instructions:
        if ch == 'G':
            x += dirs[dir][0]
            y += dirs[dir][1]
        elif ch == 'L':
            dir = (dir + 3) % 4
        elif ch == 'R':
            dir = (dir + 1) % 4

    return (x == 0 and y == 0) or dir != 0


if __name__ == "__main__":
    test_cases = [
        ("GGLLGG",   True),
        ("GG",       False),
        ("GL",       True),
        ("GRGRGRGR", True),
        ("GLGR",     False),
        ("LLLGGG",   True),
    ]

    for instructions, expected in test_cases:
        result = is_robot_bounded(instructions)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] instructions=\"{instructions}\" result={result} expected={expected}")
