def equilibrium_index(nums):
    total = sum(nums)
    left_sum = 0
    for i, num in enumerate(nums):
        right_sum = total - left_sum - num
        if left_sum == right_sum:
            return i
        left_sum += num
    return 0 if len(nums) == 1 else -1
