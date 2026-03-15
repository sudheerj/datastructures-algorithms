def find_two_sum_indices(nums, target):
    left, right = 0, len(nums) -1

    while left < right:
        sum = nums[left] + nums[right]

        if sum == target:
            return [left+1, right+1]
        elif sum < target:
            left += 1
        else:
            right -= 1
        
    return [-1, -1]


# Test cases
if __name__ == "__main__":
    # Note: Array must be sorted for two-pointer approach to work
    nums1 = [2, 7, 11, 15]
    target1 = 9
    nums2 = [-2, 0, 3, 5]
    target2 = 1
    
    print(f"Indices for target {target1} in {nums1}: {find_two_sum_indices(nums1, target1)}")  # [1, 2]
    print(f"Indices for target {target2} in {nums2}: {find_two_sum_indices(nums2, target2)}")  # [2, 3]
