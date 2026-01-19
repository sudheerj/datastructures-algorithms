"""
Majority Element

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than n/2 times.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def majority_element(nums):
    """
    Boyer-Moore Voting Algorithm.
    TC: O(n), SC: O(1)
    """
    count = 0
    candidate = None
    
    for num in nums:
        if count == 0:
            candidate = num
        
        count += 1 if num == candidate else -1
    
    return candidate


def majority_element_hashmap(nums):
    """
    Using hashmap to count occurrences.
    TC: O(n), SC: O(n)
    """
    counts = {}
    n = len(nums)
    
    for num in nums:
        counts[num] = counts.get(num, 0) + 1
        if counts[num] > n // 2:
            return num
    
    return None


# Test cases
if __name__ == "__main__":
    test_cases = [
        [5, 4, 5, 5],           # Output: 5
        [3, 4, 3, 5, 3, 3, 1, 3],  # Output: 3
        [3, 2, 3],              # Output: 3
        [2, 2, 1, 1, 1, 2, 2],  # Output: 2
    ]
    
    for nums in test_cases:
        result1 = majority_element(nums)
        result2 = majority_element_hashmap(nums)
        print(f"Input: {nums}")
        print(f"  Boyer-Moore: {result1}")
        print(f"  Hashmap: {result2}")
