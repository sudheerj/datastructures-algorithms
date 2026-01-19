"""
Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest
consecutive elements sequence.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def longest_consecutive(nums):
    """
    Using hash set.
    TC: O(n), SC: O(n)
    """
    if not nums:
        return 0
    
    num_set = set(nums)
    longest = 0
    
    for num in num_set:
        # Only start counting if num is the start of a sequence
        if num - 1 not in num_set:
            current_num = num
            current_streak = 1
            
            while current_num + 1 in num_set:
                current_num += 1
                current_streak += 1
            
            longest = max(longest, current_streak)
    
    return longest


# Test cases
if __name__ == "__main__":
    test_cases = [
        [100, 4, 200, 1, 3, 2],        # 4 (sequence: 1,2,3,4)
        [0, 3, 7, 2, 5, 8, 4, 6, 0, 1], # 9 (sequence: 0-8)
    ]
    
    for nums in test_cases:
        print(f"nums: {nums}")
        print(f"Longest consecutive: {longest_consecutive(nums)}")
        print()
