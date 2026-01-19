"""
Count Divisible

Count the number of integers divisible by K in range [A..B].

Time Complexity: O(1)
Space Complexity: O(1)
"""


def count_divisible(first_number, second_number, divisor):
    """
    Calculate count using math formula.
    TC: O(1), SC: O(1)
    """
    count_until_second = second_number // divisor
    count_before_first = (first_number - 1) // divisor
    
    return count_until_second - count_before_first


# Test cases
if __name__ == "__main__":
    test_cases = [
        (6, 11, 2),   # Output: 3 (6, 8, 10)
        (0, 0, 11),   # Output: 1 (0 is divisible by 11)
        (10, 10, 5),  # Output: 1 (10 is divisible by 5)
        (10, 10, 7),  # Output: 0 (10 is not divisible by 7)
        (1, 100, 10), # Output: 10
    ]
    
    for first, second, divisor in test_cases:
        result = count_divisible(first, second, divisor)
        print(f"count_divisible({first}, {second}, {divisor}) = {result}")
