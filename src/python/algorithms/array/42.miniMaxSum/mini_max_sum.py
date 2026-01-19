"""
Mini-Max Sum

Given five positive integers, find the minimum and maximum values 
that can be calculated by summing exactly four of the five integers.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def mini_max_sum(arr):
    """
    Find min and max sum of 4 elements.
    TC: O(n), SC: O(1)
    """
    min_val = min(arr)
    max_val = max(arr)
    total_sum = sum(arr)
    
    min_sum = total_sum - max_val
    max_sum = total_sum - min_val
    
    print(f"{min_sum} {max_sum}")
    return (min_sum, max_sum)


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 4, 5],        # Output: 10 14
        [7, 69, 2, 221, 8974],  # Output: 299 9271
        [1, 3, 5, 7, 9],        # Output: 16 24
    ]
    
    for arr in test_cases:
        print(f"Array: {arr}")
        mini_max_sum(arr)
        print()
