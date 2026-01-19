"""
Missing Element

Find the missing element in an array containing numbers from 1 to N+1.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def missing_element(nums):
    """
    Using sum formula to find missing element.
    TC: O(n), SC: O(1)
    """
    length = len(nums)
    actual_sum = sum(nums)
    expected_sum = (length + 1) * (length + 2) // 2
    
    return expected_sum - actual_sum


def missing_element_xor(nums):
    """
    Using XOR to find missing element.
    TC: O(n), SC: O(1)
    """
    result = len(nums) + 1
    
    for i, num in enumerate(nums):
        result ^= (i + 1) ^ num
    
    return result


# Test cases
if __name__ == "__main__":
    test_cases = [
        [2, 3, 1, 5],    # Output: 4
        [1, 2, 3, 4, 6], # Output: 5
        [],              # Output: 1
        [1],             # Output: 2
    ]
    
    for nums in test_cases:
        result1 = missing_element(nums)
        result2 = missing_element_xor(nums)
        print(f"Input: {nums}")
        print(f"  Using sum: {result1}, Using XOR: {result2}")
