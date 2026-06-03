# Robot Return to Origin (LC 657)
# TC: O(n)  SC: O(1)


def judge_circle(moves: str) -> bool:
    x = y = 0
    for ch in moves:
        if ch == 'U':   y += 1
        elif ch == 'D': y -= 1
        elif ch == 'L': x -= 1
        elif ch == 'R': x += 1
    return x == 0 and y == 0


if __name__ == "__main__":
    test_cases = [
        ("UD",          True),
        ("LL",          False),
        ("LRUD",        True),
        ("LDRRUUUDDL",  True),
        ("",            True),
        ("UDLR",        True),
    ]

    for moves, expected in test_cases:
        result = judge_circle(moves)
        status = "PASS" if result == expected else "FAIL"
        print(f'[{status}] moves="{moves}" result={result} expected={expected}')
