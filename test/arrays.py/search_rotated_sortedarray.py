def search_rotated_sorted_array(nums, target):
    left = 0
    right = len(nums) -1

    while left <= right:

        mid = (left + right) // 2

        if nums[mid] == target:
            return mid

        if  nums[left] <= nums[mid]:
            if nums[left] <= target < nums[mid]:
                right = mid -1
            else:
                left = mid + 1

        else:
            if nums[mid] < target <= nums[right]:
                left = mid + 1
            else:
                right = mid -1

    return -1


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


