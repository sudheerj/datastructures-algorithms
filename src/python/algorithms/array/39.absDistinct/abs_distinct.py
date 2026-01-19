"""
Absolute Distinct

Given a sorted array of integers, compute the number of distinct absolute values.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def abs_distinct(numbers):
    """
    Two pointer approach from both ends.
    TC: O(n), SC: O(n)
    """
    if not numbers:
        return 0
    
    seen = set()
    left = 0
    right = len(numbers) - 1
    
    while left <= right:
        left_abs = abs(numbers[left])
        right_abs = abs(numbers[right])
        
        if left_abs > right_abs:
            seen.add(left_abs)
            left += 1
        else:
            seen.add(right_abs)
            right -= 1
    
    return len(seen)


def abs_distinct_simple(numbers):
    """
    Simple set approach.
    TC: O(n), SC: O(n)
    """
    return len(set(abs(num) for num in numbers))


# Test cases
if __name__ == "__main__":
    test_cases = [
        [-5, -3, -1, 0, 3, 6],  # Output: 5
        [-2, -1, 0, 1, 2, 2],   # Output: 3
        [-1, -1, -1, 1, 1, 1],  # Output: 1
        [],                     # Output: 0
    ]
    
    for nums in test_cases:
        result1 = abs_distinct(nums)
        result2 = abs_distinct_simple(nums)
        print(f"Input: {nums}")
        print(f"  Two pointer: {result1}, Simple: {result2}")
