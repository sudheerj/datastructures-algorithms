"""
Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].

Time Complexity: O(n)
Space Complexity: O(1) (excluding output array)
"""


def product_except_self(nums):
    """
    Using prefix and suffix products.
    TC: O(n), SC: O(1)
    """
    n = len(nums)
    result = [1] * n
    
    # Calculate prefix products
    prefix = 1
    for i in range(n):
        result[i] = prefix
        prefix *= nums[i]
    
    # Calculate suffix products and multiply
    suffix = 1
    for i in range(n - 1, -1, -1):
        result[i] *= suffix
        suffix *= nums[i]
    
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 4],      # [24, 12, 8, 6]
        [-1, 1, 0, -3, 3], # [0, 0, 9, 0, 0]
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Output: {product_except_self(nums)}")
        print()
