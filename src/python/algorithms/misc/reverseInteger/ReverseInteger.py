def reverse_integer(x):
    result = 0
    sign = -1 if x < 0 else 1
    x = abs(x)
    while x != 0:
        digit = x % 10
        x //= 10
        if result > (2**31 - 1) // 10:
            return 0
        result = result * 10 + digit
    result *= sign
    if result < -2**31 or result > 2**31 - 1:
        return 0
    return result

if __name__ == "__main__":
    # Example 1: Positive number
    print(reverse_integer(123)) # Expected: 321
    # Example 2: Negative number
    print(reverse_integer(-456)) # Expected: -654
    # Example 3: Number with trailing zeros
    print(reverse_integer(1200)) # Expected: 21
    # Example 4: Zero
    print(reverse_integer(0)) # Expected: 0
    # Example 5: Overflow positive
    print(reverse_integer(1534236469)) # Expected: 0
    # Example 6: Overflow negative
    print(reverse_integer(-1563847412)) # Expected: 0
