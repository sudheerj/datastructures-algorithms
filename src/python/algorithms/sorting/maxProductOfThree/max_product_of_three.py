"""
Maximum Product of Three

Given a non-empty array of integers, return the maximum product
that can be obtained by multiplying any three integers.

Time Complexity: O(n log n)
Space Complexity: O(1)
"""


def max_product_of_three(numbers):
    """
    After sorting, check two cases:
    1. Three largest numbers
    2. Two smallest (possibly negative) and the largest
    TC: O(n log n), SC: O(1)
    """
    numbers.sort()
    n = len(numbers)
    
    # Product of three largest numbers
    product1 = numbers[n - 1] * numbers[n - 2] * numbers[n - 3]
    # Product of two smallest (possibly negative) and the largest
    product2 = numbers[0] * numbers[1] * numbers[n - 1]
    
    return max(product1, product2)


def max_product_of_three_linear(numbers):
    """
    O(n) approach by tracking min and max values.
    TC: O(n), SC: O(1)
    """
    min1 = min2 = float('inf')
    max1 = max2 = max3 = float('-inf')
    
    for num in numbers:
        # Update three largest
        if num > max1:
            max3 = max2
            max2 = max1
            max1 = num
        elif num > max2:
            max3 = max2
            max2 = num
        elif num > max3:
            max3 = num
        
        # Update two smallest
        if num < min1:
            min2 = min1
            min1 = num
        elif num < min2:
            min2 = num
    
    return max(max1 * max2 * max3, min1 * min2 * max1)


# Test cases
if __name__ == "__main__":
    test_cases = [
        [-3, 1, 2, -2, 5, 6],  # 60 (2 * 5 * 6)
        [-10, -10, 1, 3, 2],   # 300 (-10 * -10 * 3)
        [1, 2, 3],             # 6 (1 * 2 * 3)
        [-1, -2, -3, -4],      # -6 (-1 * -2 * -3)
    ]
    
    for nums in test_cases:
        result1 = max_product_of_three(nums.copy())
        result2 = max_product_of_three_linear(nums)
        print(f"Input: {nums}")
        print(f"  Sorting: {result1}, Linear: {result2}")
