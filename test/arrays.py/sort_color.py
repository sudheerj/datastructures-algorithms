def sort_colors(nums):
    left = i = 0
    right = len(nums) -1

    while i < right:
        if nums[i] == 0:
            [nums[i], nums[left]] = [nums[left], nums[i]]
            left += 1
            i += 1
        elif nums[i] == 2:
            [nums[i], nums[right]] = [nums[right], nums[i]]
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
