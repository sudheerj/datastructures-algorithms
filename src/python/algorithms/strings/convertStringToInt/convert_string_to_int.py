# Convert String to Integer (atoi)
# TC: O(n), SC: O(1)

def my_atoi(s: str) -> int:
    if not s:
        return 0

    INT_MAX = 2**31 - 1
    INT_MIN = -(2**31)
    i, n = 0, len(s)

    # Skip leading whitespace
    while i < n and s[i] == ' ':
        i += 1

    # Check sign
    sign = 1
    if i < n and s[i] in ('+', '-'):
        sign = -1 if s[i] == '-' else 1
        i += 1

    # Convert digits
    result = 0
    while i < n and s[i].isdigit():
        result = result * 10 + int(s[i])
        if result * sign > INT_MAX:
            return INT_MAX
        if result * sign < INT_MIN:
            return INT_MIN
        i += 1

    return result * sign


# Test cases
test_cases = ["42", "   -42", "4193 with words", "", "   ", "+1", "words and 987", "-91283472332", "91283472332", "  0012a42"]
expected   = [42,   -42,      4193,              0,  0,     1,    0,               -2147483648,    2147483647,    12]

for i in range(len(test_cases)):
    result = my_atoi(test_cases[i])
    status = "✓" if result == expected[i] else f"✗ (expected {expected[i]})"
    print(f'"{test_cases[i]}" => {result} {status}')
