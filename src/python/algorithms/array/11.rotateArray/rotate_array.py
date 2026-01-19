"""
Rotate Array

Given an integer array nums, rotate the array to the right by k steps.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def rotate_right(nums, k):
    """
    Rotate array right using reversal algorithm.
    TC: O(n), SC: O(1)
    """
    length = len(nums)
    if length == 0 or k % length == 0:
        return nums
    
    k = k % length  # Handle k > length
    
    # Reverse entire array
    reverse(nums, 0, length - 1)
    # Reverse first part
    reverse(nums, 0, k - 1)
    # Reverse second part
    reverse(nums, k, length - 1)
    
    return nums


def rotate_left(nums, k):
    """
    Rotate array left using reversal algorithm.
    TC: O(n), SC: O(1)
    """
    length = len(nums)
    if length == 0 or k % length == 0:
        return nums
    
    k = k % length  # Handle k > length
    
    # Reverse first part
    reverse(nums, 0, k - 1)
    # Reverse second part
    reverse(nums, k, length - 1)
    # Reverse entire array
    reverse(nums, 0, length - 1)
    
    return nums


def reverse(arr, start, end):
    """Helper function to reverse elements between two indices."""
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1


def rotate_using_array(nums, k):
    """
    Rotate using additional array.
    TC: O(n), SC: O(n)
    """
    length = len(nums)
    if length == 0:
        return nums
    
    k = k % length
    result = [0] * length
    
    for i in range(length):
        result[(i + k) % length] = nums[i]
    
    return result


# Test cases
if __name__ == "__main__":
    # Test rotate right
    nums1 = [1, 2, 3, 4, 5, 6, 7]
    k1 = 3
    print(f"Original: {nums1}, k={k1}")
    print(f"Rotated right: {rotate_right(nums1.copy(), k1)}")  # [5, 6, 7, 1, 2, 3, 4]
    
    # Test rotate left
    nums2 = [1, 2, 3, 4, 5, 6, 7]
    k2 = 3
    print(f"Original: {nums2}, k={k2}")
    print(f"Rotated left: {rotate_left(nums2.copy(), k2)}")  # [4, 5, 6, 7, 1, 2, 3]
    
    # Test rotate using array
    nums3 = [1, 2, 3, 4, 5, 6, 7]
    k3 = 3
    print(f"Original: {nums3}, k={k3}")
    print(f"Rotated (using array): {rotate_using_array(nums3, k3)}")
