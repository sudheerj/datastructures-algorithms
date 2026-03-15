def max_product_subarray(nums):
    global_max = curr_max = curr_min = nums[0]

    for i in range(1, len(nums)):
        if nums[i] < 0:
            curr_max, curr_min = curr_min, curr_max

        curr_max = max(nums[i], nums[i] * curr_max)
        curr_min = min(nums[i], nums[i] * curr_min)

        global_max = max(global_max, curr_max)

    return global_max

# Test cases
if __name__ == "__main__":
    nums1 = [6, 7, -4, 5, 8, 1]
    print(f"Input: {nums1}")
    print(f"Output: {max_product_subarray(nums1)}")  # 840
    
    nums2 = [2, -7, -4, 0, 3, 3]
    print(f"Input: {nums2}")
    print(f"Output: {max_product_subarray(nums2)}")  # 56
    
    nums3 = [2, 3, -2, 4]
    print(f"Input: {nums3}")
    print(f"Output: {max_product_subarray(nums3)}")  # 6