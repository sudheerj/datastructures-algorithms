"""
Find Minimum in Rotated Sorted Array

Given the sorted rotated array nums of unique elements,
return the minimum element of this array.

Time Complexity: O(log n)
Space Complexity: O(1)
"""


def find_min_rotated_sorted_array(nums):
    """
    Binary search approach.
    TC: O(log n), SC: O(1)
    """
    if len(nums) == 1:
        return nums[0]
    if len(nums) == 2:
        return min(nums[0], nums[1])
    
    left = 0
    right = len(nums) - 1
    
    while left < right:
        # If array is already sorted
        if nums[left] < nums[right]:
            return nums[left]
        
        mid = (left + right) // 2
        
        if nums[mid] > nums[right]:
            # Minimum is in the right half
            left = mid + 1
        else:
            # Minimum is in the left half (including mid)
            right = mid
    
    return nums[left]


# Test cases
if __name__ == "__main__":
    nums1 = [3, 4, 5, 6, 7, 1, 2]
    print(f"Input: {nums1}")
    print(f"Output: {find_min_rotated_sorted_array(nums1)}")  # 1
    
    nums2 = [0, 1, 2, 4, 5, 6, 7, 8]
    print(f"Input: {nums2}")
    print(f"Output: {find_min_rotated_sorted_array(nums2)}")  # 0
    
    nums3 = [4, 5, 6, 7, 0, 1, 2]
    print(f"Input: {nums3}")
    print(f"Output: {find_min_rotated_sorted_array(nums3)}")  # 0
