def move_zeros(nums):

    left = 0

    for right in range(len(nums)):
        if nums[right]:
            nums[left], nums[right] = nums[right], nums[left]
            left +=1
    return nums


# Test cases
if __name__ == "__main__":
    test_cases = [
        [0, 1, 0, 3, 12],     # [1, 3, 12, 0, 0]
        [0],                    # [0]
        [1, 2, 3],              # [1, 2, 3]
        [0, 0, 0, 1],          # [1, 0, 0, 0]
        [4, 0, 5, 0, 0, 6],   # [4, 5, 6, 0, 0, 0]
    ]

    for nums in test_cases:
        original = nums.copy()
        print(f"Input: {original}")
        print(f"Output: {move_zeros(nums)}")
        print()