"""
Maximum Product Subarray

Given an integer array nums, find a contiguous subarray that has the largest product,
and return the product.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def max_product_subarray(nums):
    """
    Track both max and min products (min can become max when multiplied by negative).
    TC: O(n), SC: O(1)
    """
    if not nums:
        return 0
    
    global_max = nums[0]
    current_max = nums[0]
    current_min = nums[0]
    
    for i in range(1, len(nums)):
        num = nums[i]
        
        # When multiplied by a negative number, max becomes min and vice versa
        if num < 0:
            current_max, current_min = current_min, current_max
        
        current_max = max(num, current_max * num)
        current_min = min(num, current_min * num)
        
        global_max = max(global_max, current_max)
    
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
