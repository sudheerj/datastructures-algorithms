"""
Search in Rotated Sorted Array

Given the sorted rotated array nums of unique elements, and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

Time Complexity: O(log n)
Space Complexity: O(1)
"""


def search_rotated_sorted_array(nums, target):
    """
    Modified binary search.
    TC: O(log n), SC: O(1)
    """
    left = 0
    right = len(nums) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        # Found the target
        if nums[mid] == target:
            return mid
        
        # Determine which half is sorted
        if nums[left] <= nums[mid]:
            # Left side is sorted
            if nums[left] <= target < nums[mid]:
                right = mid - 1  # Target in left half
            else:
                left = mid + 1   # Target in right half
        else:
            # Right side is sorted
            if nums[mid] < target <= nums[right]:
                left = mid + 1   # Target in right half
            else:
                right = mid - 1  # Target in left half
    
    return -1  # Target not found


# Test cases
if __name__ == "__main__":
    nums1 = [3, 4, 5, 6, 7, 0, 1, 2]
    print(f"Input: {nums1}, target = 7")
    print(f"Output: {search_rotated_sorted_array(nums1, 7)}")  # 4
    
    nums2 = [3, 4, 5, 6, 7, 0, 1, 2]
    print(f"Input: {nums2}, target = 9")
    print(f"Output: {search_rotated_sorted_array(nums2, 9)}")  # -1
    
    nums3 = [4, 5, 6, 7, 0, 1, 2]
    print(f"Input: {nums3}, target = 0")
    print(f"Output: {search_rotated_sorted_array(nums3, 0)}")  # 4
