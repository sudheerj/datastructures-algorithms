from is_pangram import is_pangram

def run_tests():
    test_cases = [
        ("abcdefghijklmnopqrstuvwxyz", "pangram"),
        ("abcdefghijklmnopqrstuvwxy", "not pangram"),
        ("Abcdefghijklmnopqrstuvwxyz", "pangram"),
        ("A quick brown fox", "not pangram"),
        ("Mr. Jock, TV quiz PhD, bags few lynx.", "pangram"),
        ("Waltz, nymph, for quick jigs vex Bud.", "pangram"),
        ("John Doe", "not pangram"),
        ("Pack my box with five dozen liquor jugs.", "pangram"),
    ]
    for s, expected in test_cases:
        result = is_pangram(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"Input: '{s}' | Output: '{result}' | Expected: '{expected}' | {status}")

if __name__ == "__main__":
    run_tests()
