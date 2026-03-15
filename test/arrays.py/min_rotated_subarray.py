def min_rotated_subarray(nums):
    left=0
    right = len(nums)-1

    while left < right:
        if nums[left] < nums[right]:
            return nums[left]
        
        mid = (left + right) // 2

        if nums[mid] > nums[right]:
            left = mid + 1
        else: 
            right = mid
    
    return nums[left]

# Test cases
if __name__ == "__main__":
    nums1 = [3, 4, 5, 6, 7, 1, 2]
    print(f"Input: {nums1}")
    print(f"Output: {min_rotated_subarray(nums1)}")  # 1
    
    nums2 = [0, 1, 2, 4, 5, 6, 7, 8]
    print(f"Input: {nums2}")
    print(f"Output: {min_rotated_subarray(nums2)}")  # 0
    
    nums3 = [4, 5, 6, 7, 0, 1, 2]
    print(f"Input: {nums3}")
    print(f"Output: {min_rotated_subarray(nums3)}")  # 0