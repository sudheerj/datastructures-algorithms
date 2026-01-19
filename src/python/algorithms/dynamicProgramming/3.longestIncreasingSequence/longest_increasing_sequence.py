"""
Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.

Time Complexity: O(n^2) or O(n log n) with binary search
Space Complexity: O(n)
"""


def length_of_lis(nums):
    """
    Dynamic programming approach.
    TC: O(n^2), SC: O(n)
    """
    if not nums:
        return 0
    
    n = len(nums)
    dp = [1] * n
    
    for i in range(1, n):
        for j in range(i):
            if nums[j] < nums[i]:
                dp[i] = max(dp[i], dp[j] + 1)
    
    return max(dp)


def length_of_lis_binary_search(nums):
    """
    Binary search approach.
    TC: O(n log n), SC: O(n)
    """
    import bisect
    
    if not nums:
        return 0
    
    tails = []
    
    for num in nums:
        pos = bisect.bisect_left(tails, num)
        if pos == len(tails):
            tails.append(num)
        else:
            tails[pos] = num
    
    return len(tails)


# Test cases
if __name__ == "__main__":
    test_cases = [
        [10, 9, 2, 5, 3, 7, 101, 18],  # 4 ([2,3,7,101])
        [0, 1, 0, 3, 2, 3],             # 4
        [7, 7, 7, 7, 7, 7, 7],          # 1
    ]
    
    for nums in test_cases:
        print(f"nums: {nums}")
        print(f"LIS length (DP): {length_of_lis(nums)}")
        print(f"LIS length (Binary Search): {length_of_lis_binary_search(nums)}")
        print()
