def areAlmostEqual(s1, s2):
    if s1 == s2:
        return True

    diff = []
    for i in range(len(s1)):
        if s1[i] != s2[i]:
            diff.append(i)

            if len(diff) > 2:
                return False 
    
    if len(diff) == 2:
        i, j = diff
        return s1[i] == s2[j] and s1[j] == s2[i]

    return False

def run_tests():
    tests = [
        # (s1, s2, expected)
        ("bank", "kanb", True),
        ("attack", "defend", False),
        ("kelb", "kelb", True),
        ("abcd", "dcba", False),
        ("abcd", "abdc", True),
        ("aa", "aa", True),
        ("ab", "ba", True),
        ("ab", "ab", True),
        ("abc", "acb", True),
        ("abc", "abd", False),
    ]

    for i, (s1, s2, expected) in enumerate(tests, 1):
        result = areAlmostEqual(s1, s2)
        status = "PASS" if result == expected else "FAIL"

        print(f"Test {i}: {status}")
        print(f"  s1 = '{s1}'")
        print(f"  s2 = '{s2}'")
        print(f"  Expected = {expected}")
        print(f"  Got      = {result}\n")


if __name__ == "__main__":
    run_tests()