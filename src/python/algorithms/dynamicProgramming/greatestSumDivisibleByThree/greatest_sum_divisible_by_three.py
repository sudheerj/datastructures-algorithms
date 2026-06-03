def max_sum_div_three(nums):
    """
    Find the maximum sum of array elements that is divisible by 3.
    
    TC: O(n * 3) ~= O(n) where n is the length of nums
    SC: O(3) ~= O(1) as we only use fixed-size array
    
    Args:
        nums: List of integers
        
    Returns:
        Maximum sum divisible by 3
    """
    # dp[i] stores the maximum sum with remainder i when divided by 3
    dp = [0, 0, 0]
    
    for num in nums:
        # Take snapshot of previous state to avoid overwriting during iteration
        temp = dp[:]
        
        for sum_val in temp:
            new_sum = sum_val + num
            remainder = new_sum % 3
            
            # Update best sum for this remainder
            dp[remainder] = max(dp[remainder], new_sum)
    
    return dp[0]


if __name__ == "__main__":
    # Test case 1
    nums1 = [3, 6, 5, 1, 8]
    result1 = max_sum_div_three(nums1)
    print("Test case 1: nums = [3,6,5,1,8]")
    print(f"Output: {result1}")
    print("Expected: 18")
    print("Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).")
    print()

    # Test case 2
    nums2 = [4]
    result2 = max_sum_div_three(nums2)
    print("Test case 2: nums = [4]")
    print(f"Output: {result2}")
    print("Expected: 0")
    print("Explanation: Since 4 is not divisible by 3, do not pick any number.")
    print()

    # Test case 3
    nums3 = [1, 2, 3, 4, 4]
    result3 = max_sum_div_three(nums3)
    print("Test case 3: nums = [1,2,3,4,4]")
    print(f"Output: {result3}")
    print("Expected: 12")
    print("Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).")
    print()

    # Test case 4
    nums4 = [2, 6, 2, 2, 7]
    result4 = max_sum_div_three(nums4)
    print("Test case 4: nums = [2,6,2,2,7]")
    print(f"Output: {result4}")
    print("Expected: 15")
    print("Explanation: Pick numbers 6, 2, and 7 their sum is 15.")
    print()

    # Test case 5
    nums5 = [5, 3, 1, 2]
    result5 = max_sum_div_three(nums5)
    print("Test case 5: nums = [5,3,1,2]")
    print(f"Output: {result5}")
    print("Expected: 9")
    print("Explanation: Pick numbers 5, 3, and 1 their sum is 9.")
