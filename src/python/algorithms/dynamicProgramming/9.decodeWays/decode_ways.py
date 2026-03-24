def decode_ways(st):
    dp = {len(st): 1}

    for i in range(len(st)-1, -1, -1):
        if st[i] == "0":
            dp[i] = 0
            continue
        else:
            dp[i] = dp[i+1]

        if (i+1 < len(st) and (st[i] == "1" or (st[i] == "2" and st[i+1] in "0123456"))):
            dp[i] += dp[i+2]

    return dp[0]

# Test cases
if __name__ == "__main__":
    test_cases = [
        {"input": "221", "expected": 3},
        {"input": "12", "expected": 2},
        {"input": "226", "expected": 3},
        {"input": "09", "expected": 0},
        {"input": "0", "expected": 0},
        {"input": "10", "expected": 1},
        {"input": "100", "expected": 0},
        {"input": "11106", "expected": 2},
    ]

    for test in test_cases:
        result = decode_ways(test["input"])
        status = "PASS" if result == test["expected"] else "FAIL"
        print(f"[{status}] Input: '{test['input']}' | Expected: {test['expected']} | Got: {result}")

