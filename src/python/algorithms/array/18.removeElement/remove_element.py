"""
Remove Element

Given an integer array nums and an integer val, remove all occurrences
of val in nums in-place. Return the number of elements in nums which are not equal to val.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def remove_element(nums, val):
    """
    Two pointer approach to remove elements in-place.
    TC: O(n), SC: O(1)
    """
    k = 0
    
    for num in nums:
        if num != val:
            nums[k] = num
            k += 1
    
    return k


# Test cases
if __name__ == "__main__":
    nums1 = [4, 1, 1, 4, 1]
    val1 = 4
    k1 = remove_element(nums1, val1)
    print(f"After removing {val1}: {nums1[:k1]}, count: {k1}")  # [1, 1, 1], 3
    
    nums2 = [0, 3, 5, 5, 3, 1, 5, 2]
    val2 = 5
    k2 = remove_element(nums2, val2)
    print(f"After removing {val2}: {nums2[:k2]}, count: {k2}")  # [0, 3, 3, 1, 2], 5
    
    nums3 = [3, 2, 2, 3]
    val3 = 3
    k3 = remove_element(nums3, val3)
    print(f"After removing {val3}: {nums3[:k3]}, count: {k3}")  # [2, 2], 2
