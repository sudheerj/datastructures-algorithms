def minAddToMakeValid(s):
    open_count = 0
    additions = 0

    for ch in s:
        if ch == '(':
            open_count += 1
        else:
            if open_count > 0:
                open_count -= 1
            else:
                additions += 1
    return open_count + additions

def run_tests():
    tests = [
        ("())", 1),
        ("(((", 3),
        ("()", 0),
        ("()))((", 3),
        ("", 0),
        ("(()", 1),
        (")(", 2),
        ("(()())", 0),
        ("()))", 2),
        ("(()))(", 2),
    ]

    for i, (s, expected) in enumerate(tests, 1):
        result = minAddToMakeValid(s)
        status = "PASS" if result == expected else "FAIL"

        print(f"Test {i}: {status}")
        print(f"  s = '{s}'")
        print(f"  Expected = {expected}")
        print(f"  Got      = {result}\n")


if __name__ == "__main__":
    run_tests()