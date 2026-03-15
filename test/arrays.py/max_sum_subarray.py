def max_subarray(nums):
    curr_max_sum = global_max_sum = nums[0]

    for i in range(1, len(nums)):
        curr_max_sum = max(nums[i], curr_max_sum+nums[i])
        global_max_sum = max(global_max_sum, curr_max_sum)

    return global_max_sum

def max_subarray_with_indices(nums):
    if not nums:
        return 0, -1, -1
        
    curr_max_sum = global_max_sum = nums[0]
    start = temp_start = end = 0

    for i in range(1, len(nums)):
        if nums[i] > curr_max_sum+nums[i]:
            curr_max_sum = nums[i]
            temp_start = i
        else:
            curr_max_sum =curr_max_sum + nums[i]

        if curr_max_sum > global_max_sum:
            global_max_sum = curr_max_sum
            start = temp_start
            end = i

    return global_max_sum, start, end

# Test cases
if __name__ == "__main__":
    test_cases = [
        [-2, 1, -3, 4, -1, 2, 1, -5, 4],  # 6 (subarray [4,-1,2,1])
        [1],                               # 1
        [5, 4, -1, 7, 8],                  # 23
    ]
    
    for nums in test_cases:
        print(f"Input: {nums}")
        print(f"Max sum: {max_subarray(nums)}")
        result = max_subarray_with_indices(nums)
        print(f"Max sum with indices: sum={result[0]}, start={result[1]}, end={result[2]}")
        print()
