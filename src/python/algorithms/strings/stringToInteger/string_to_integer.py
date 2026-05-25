# String traversal  TC: O(n) SC: O(1)
INT_MAX =  2**31 - 1
INT_MIN = -2**31

def my_atoi(s):
    n = len(s)
    i = 0
    result = 0
    sign = 1

    # Skip leading whitespace
    while i < n and s[i] == ' ':
        i += 1

    # Check sign (only once)
    if i < n and s[i] in ('+', '-'):
        sign = -1 if s[i] == '-' else 1
        i += 1

    # Convert digits
    while i < n and s[i].isdigit():
        result = result * 10 + int(s[i])
        i += 1

        # Handle overflow
        if sign * result > INT_MAX:
            return INT_MAX
        if sign * result < INT_MIN:
            return INT_MIN

    return sign * result


if __name__ == "__main__":
    test_cases = [
        ("42",             42),
        ("   -042",        -42),
        ("1337c0d3",       1337),
        ("0-1",            0),
        ("-91283472332",   INT_MIN),
    ]

    for s, expected in test_cases:
        result = my_atoi(s)
        status = "PASS" if result == expected else "FAIL"
        print(f"[{status}] result={result} expected={expected}")
