"""
Min Absolute Sum of Two

Given an array of integers, find the minimum absolute value of the sum
of any two elements (can use the same element twice).

Time Complexity: O(n log n)
Space Complexity: O(1)
"""


def min_abs_sum_of_two(numbers):
    """
    Two pointer approach after sorting.
    TC: O(n log n), SC: O(1)
    """
    numbers.sort()
    left = 0
    right = len(numbers) - 1
    min_abs_sum = float('inf')
    
    while left <= right:
        current_sum = numbers[left] + numbers[right]
        abs_sum = abs(current_sum)
        
        min_abs_sum = min(min_abs_sum, abs_sum)
        
        # Move the pointer that brings us closer to 0
        if current_sum < 0:
            left += 1
        else:
            right -= 1
    
    return min_abs_sum


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 4, -3],         # Output: 1
        [-8, 4, 5, -10, 3], # Output: 1
        [2, 2, 2],          # Output: 4
        [-1, -2, -3],       # Output: 2
        [0, 0],             # Output: 0
    ]
    
    for nums in test_cases:
        result = min_abs_sum_of_two(nums.copy())
        print(f"Input: {nums} => Min abs sum: {result}")
