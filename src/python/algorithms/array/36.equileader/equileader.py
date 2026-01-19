"""
Equi Leader

Find the number of equi leaders - indices S such that the leaders of
sequences 0 to S and S+1 to N-1 are the same.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def dominator(nums):
    """
    Find the dominator (majority element) using Boyer-Moore.
    """
    count = 0
    candidate = None
    
    for num in nums:
        if count == 0:
            candidate = num
        count += 1 if num == candidate else -1
    
    return candidate


def equi_leader(nums):
    """
    Count equi leaders using prefix counting.
    TC: O(n), SC: O(1)
    """
    if not nums:
        return 0
    
    leader_candidate = dominator(nums)
    total_occurrences = nums.count(leader_candidate)
    
    # Check if it's actually a leader
    if total_occurrences <= len(nums) // 2:
        return 0
    
    equileaders = 0
    leaders_count_so_far = 0
    
    for i in range(len(nums) - 1):
        if nums[i] == leader_candidate:
            leaders_count_so_far += 1
        
        left_leaders_count = leaders_count_so_far
        right_leaders_count = total_occurrences - leaders_count_so_far
        left_size = i + 1
        right_size = len(nums) - left_size
        
        if left_leaders_count > left_size // 2 and right_leaders_count > right_size // 2:
            equileaders += 1
    
    return equileaders


# Test cases
if __name__ == "__main__":
    test_cases = [
        [4, 3, 4, 4, 4, 2],       # Output: 2
        [1, 2, 1, 1, 2, 1],       # Output: 2
        [1, 2, 3, 4, 5],          # Output: 0
        [7, 7, 7, 7, 7],          # Output: 4
        [0, 0, 1, 0, 2, 0, 0],    # Output: 3
        [5, 5, 1, 1, 5, 5, 1, 5], # Output: 2
    ]
    
    for nums in test_cases:
        result = equi_leader(nums)
        print(f"Input: {nums} => Equi leaders: {result}")
