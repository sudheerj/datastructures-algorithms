"""
Sort Colors (Dutch National Flag Problem)

Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red (0), white (1), and blue (2).

Time Complexity: O(n)
Space Complexity: O(1)
"""


def sort_colors(nums):
    """
    Dutch National Flag algorithm using three pointers.
    TC: O(n), SC: O(1)
    """
    left = 0      # Boundary for 0s
    i = 0         # Current element
    right = len(nums) - 1  # Boundary for 2s
    
    while i <= right:
        if nums[i] == 0:
            nums[i], nums[left] = nums[left], nums[i]
            left += 1
            i += 1
        elif nums[i] == 2:
            nums[i], nums[right] = nums[right], nums[i]
            right -= 1
        else:
            i += 1
    
    return nums


# Test cases
if __name__ == "__main__":
    nums1 = [2, 1, 0, 1, 2, 0]
    print(f"Input: {nums1}")
    print(f"Output: {sort_colors(nums1)}")  # [0, 0, 1, 1, 2, 2]
    
    nums2 = [2, 1, 0]
    print(f"Input: {nums2}")
    print(f"Output: {sort_colors(nums2)}")  # [0, 1, 2]
