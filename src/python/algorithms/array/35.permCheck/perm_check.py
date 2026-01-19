"""
Permutation Check

Check whether array is a permutation of integers from 1 to N.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def perm_check_using_set(nums):
    """
    Using set to track seen numbers.
    TC: O(n), SC: O(n)
    """
    seen = set()
    
    for num in nums:
        if num < 1 or num > len(nums) or num in seen:
            return 0
        seen.add(num)
    
    return 1


def perm_check_using_array(nums):
    """
    Using boolean array to track seen numbers.
    TC: O(n), SC: O(n)
    """
    seen = [False] * len(nums)
    
    for num in nums:
        if num < 1 or num > len(nums) or seen[num - 1]:
            return 0
        seen[num - 1] = True
    
    return 1


# Test cases
if __name__ == "__main__":
    test_cases = [
        [4, 1, 3, 2],     # Output: 1 (Valid permutation)
        [4, 1, 3],        # Output: 0 (Missing 2)
        [1, 2, 2, 3],     # Output: 0 (Duplicate)
        [1],              # Output: 1
        [2, 1, 4, 3, 5],  # Output: 1
    ]
    
    for nums in test_cases:
        result1 = perm_check_using_set(nums)
        result2 = perm_check_using_array(nums)
        print(f"Input: {nums}")
        print(f"  Using set: {result1}, Using array: {result2}")
