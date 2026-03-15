def product_except_self(nums):
    length = len(nums)
    result = [1] * length
    prefix = 1
    suffix = 1

    for i in range(length):
        result[i] = prefix
        prefix *= nums[i]

    for i in range(length-1, -1, -1):
        result[i] *= suffix
        suffix *= nums[i]

    return result

# Test cases
if __name__ == "__main__":
    test_cases = [
        [1, 2, 3, 4],      # [24, 12, 8, 6]
        [-1, 1, 0, -3, 3], # [0, 0, 9, 0, 0]
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Output: {product_except_self(nums)}")
        print()