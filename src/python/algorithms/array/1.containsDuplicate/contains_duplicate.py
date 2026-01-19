"""
Contains Duplicate

Given an integer array nums, return true if any value appears at least twice
in the array, and return false if every element is distinct.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def contains_duplicate(nums):
    """
    Using Set for early exit.
    TC: O(n), SC: O(n)
    """
    seen = set()
    for num in nums:
        if num in seen:
            return True  # Duplicate found
        seen.add(num)
    return False  # No duplicates


def contains_duplicate_using_dict(nums):
    """
    Using dictionary for early exit.
    TC: O(n), SC: O(n)
    """
    seen = {}
    for num in nums:
        if num in seen:
            return True  # Duplicate found
        seen[num] = True
    return False  # No duplicates


def contains_duplicate_using_size(nums):
    """
    Using Set size comparison.
    TC: O(n), SC: O(n)
    """
    return len(set(nums)) != len(nums)


def contains_duplicate_using_sort(nums):
    """
    Using sort and iteration.
    TC: O(n log n), SC: O(1) (modifies input array)
    """
    nums.sort()
    for i in range(1, len(nums)):
        if nums[i] == nums[i - 1]:
            return True  # Duplicate found
    return False  # No duplicates


def contains_duplicate_bruteforce(nums):
    """
    Using brute-force.
    TC: O(n^2), SC: O(1) (inefficient for large arrays)
    """
    for i in range(len(nums) - 1):
        for j in range(i + 1, len(nums)):
            if nums[i] == nums[j]:
                return True  # Duplicate found
    return False  # No duplicates


# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 1],      # True
        [1, 2, 3, 4],      # False
        [1, 1, 1, 3, 3, 4, 3, 2, 4, 2],  # True
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Contains duplicate: {contains_duplicate(nums)}")
        print()
