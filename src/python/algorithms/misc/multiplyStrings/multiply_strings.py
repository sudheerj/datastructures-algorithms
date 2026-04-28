def multiply_strings(num1, num2):
    if num1 == "0" or num2 == "0":
        return "0"
    m, n = len(num1), len(num2)
    res = [0] * (m + n)
    num1, num2 = num1[::-1], num2[::-1]
    for i in range(m):
        for j in range(n):
            digit = int(num1[i]) * int(num2[j])
            res[i + j] += digit
            res[i + j + 1] += res[i + j] // 10
            res[i + j] %= 10
    # Remove leading zeros
    while len(res) > 1 and res[-1] == 0:
        res.pop()
    return ''.join(map(str, res[::-1]))

if __name__ == "__main__":
    test_cases = [
        ("2", "3"),           # 6
        ("123", "456"),       # 56088
        ("0", "12345"),       # 0
        ("999", "999"),       # 998001
        ("123456789", "987654321") # 121932631112635269
    ]
    for i, (num1, num2) in enumerate(test_cases, 1):
        print(f"Test case {i}: num1 = '{num1}', num2 = '{num2}'")
        print("Output:", multiply_strings(num1, num2))
