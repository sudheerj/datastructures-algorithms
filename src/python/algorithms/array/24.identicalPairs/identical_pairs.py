"""
Number of Identical Pairs

Given an array of integers nums, return the number of identical pairs.
A pair (i, j) is identical if nums[i] == nums[j] and i < j.

Time Complexity: O(n)
Space Complexity: O(n)
"""


def find_identical_pairs(nums):
    """
    Using frequency map to count pairs.
    TC: O(n), SC: O(n)
    """
    count = 0
    frequency_map = {}
    
    for num in nums:
        if num in frequency_map:
            count += frequency_map[num]
            frequency_map[num] += 1
        else:
            frequency_map[num] = 1
    
    return count


def find_identical_pairs_formula(nums):
    """
    Using combination formula: n*(n-1)/2 for each repeated element.
    TC: O(n), SC: O(n)
    """
    from collections import Counter
    
    counts = Counter(nums)
    pairs = 0
    
    for count in counts.values():
        if count > 1:
            pairs += (count * (count - 1)) // 2
    
    return pairs


# Test cases
if __name__ == "__main__":
    test_cases = [
        [6, 3, 1, 5, 3, 6, 5, 6],  # Output: 4
        [2, 2, 2, 2],              # Output: 6
        [1, 2, 3, 4],              # Output: 0
    ]
    
    for nums in test_cases:
        result1 = find_identical_pairs(nums)
        result2 = find_identical_pairs_formula(nums)
        print(f"Input: {nums}")
        print(f"  Using frequency map: {result1}")
        print(f"  Using formula: {result2}")
