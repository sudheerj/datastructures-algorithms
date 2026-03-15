def max_circular_subarray_sum(nums):

    if not nums:
        return
        
    global_max = global_min = nums[0]
    curr_max = curr_min = 0
    total = 0

    for num in nums:

        curr_max = max(num, curr_max+num)
        curr_min = min(num, curr_min+num)

        total += num
        global_max = max(global_max, curr_max)
        global_min = min(global_min, curr_min)

    return max(global_max, total-global_min) if global_max > 0 else global_max


# Test cases
if __name__ == "__main__":
    test_cases = [
        [9, -9, 6, 11, -6, -10, 15, 1],
        [6, -2, 6],
        [-6, -2, -6],
        []
    ]
    
    for nums in test_cases:
        result = max_circular_subarray_sum(nums)
        print(f"Input: {nums} => Max Circular Subarray Sum: {result}")


