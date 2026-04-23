def plus_one(digits):
    if not digits:
        return [1]
    for i in range(len(digits) - 1, -1, -1):
        if digits[i] < 9:
            digits[i] += 1
            return digits
        digits[i] = 0
    return [1] + digits

if __name__ == "__main__":
    # Example 1: No carry
    print("Input: [1, 2, 3] -> Output:", plus_one([1, 2, 3]))
    # Example 2: Carry at the end
    print("Input: [1, 2, 9] -> Output:", plus_one([1, 2, 9]))
    # Example 3: All 9's
    print("Input: [9, 9, 9] -> Output:", plus_one([9, 9, 9]))
    # Example 4: Single digit, no carry
    print("Input: [5] -> Output:", plus_one([5]))
    # Example 5: Single digit, carry
    print("Input: [9] -> Output:", plus_one([9]))
    # Example 6: Leading zeros
    print("Input: [0, 0, 1] -> Output:", plus_one([0, 0, 1]))
    # Example 7: Empty array (edge case)
    print("Input: [] -> Output:", plus_one([]))
