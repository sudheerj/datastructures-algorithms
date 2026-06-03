def count_texts(pressed_keys):
    """
    Count the number of possible text messages from pressed keys.
    TC: O(n) SC: O(n)
    """
    MOD = 1000000007
    n = len(pressed_keys)
    dp = [0] * (n + 1)
    dp[0] = 1
    
    for i in range(1, n + 1):
        c = pressed_keys[i - 1]
        max_press = 4 if c in ['7', '9'] else 3
        
        dp[i] = dp[i - 1]
        
        for j in range(2, max_press + 1):
            if i - j >= 0:
                all_same = all(pressed_keys[k] == c for k in range(i - j, i - 1))
                if all_same:
                    dp[i] = (dp[i] + dp[i - j]) % MOD
                else:
                    break
    
    return dp[n]


if __name__ == "__main__":
    tests = [
        ("22233", 8),
        ("222222222222222222222222222222222222", 82876089),
        ("2", 1),
        ("23", 2),
        ("77799", 12),
        ("777", 4),
        ("9999999999", 40),
        ("234", 4),
        ("33", 2),
        ("7777777777", 196),
    ]
    
    print("Count Number of Texts - Test Results:")
    print("=" * 70)
    
    passed = 0
    for i, (input_str, expected) in enumerate(tests, 1):
        result = count_texts(input_str)
        pass_test = result == expected
        
        if pass_test:
            passed += 1
        
        display_input = input_str if len(input_str) <= 15 else input_str[:12] + "..."
        print(f"Test {i:2d} | Input: {display_input:<15} | Output: {result:<10} | Expected: {expected:<10} | {'PASS' if pass_test else 'FAIL'}")
    
    print("=" * 70)
    print(f"Tests Passed: {passed}/{len(tests)}")
