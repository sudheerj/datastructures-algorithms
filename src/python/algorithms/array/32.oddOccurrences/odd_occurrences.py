"""
Odd Occurrences in Array

Given an array of integers, find the element that appears an odd number of times.
There is exactly one such element.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def find_odd_number(nums):
    """
    Using XOR - optimal solution.
    TC: O(n), SC: O(1)
    """
    result = 0
    
    for num in nums:
        result ^= num
    
    return result


def find_odd_number_dict(nums):
    """
    Using dictionary for frequencies.
    TC: O(n), SC: O(n)
    """
    freq = {}
    
    for num in nums:
        freq[num] = freq.get(num, 0) + 1
    
    for key, value in freq.items():
        if value % 2 != 0:
            return key
    
    return None


def find_odd_number_toggle(nums):
    """
    Using dictionary with toggle (delete if exists).
    TC: O(n), SC: O(n)
    """
    obj = {}
    
    for num in nums:
        if num in obj:
            del obj[num]
        else:
            obj[num] = True
    
    return list(obj.keys())[0] if obj else None


# Test cases
if __name__ == "__main__":
    test_cases = [
        [9, 3, 9, 3, 9, 7, 9],   # Output: 7
        [1, 2, 1, 2, 3],         # Output: 3
        [1],                      # Output: 1
        [5, 5, 5],               # Output: 5
    ]
    
    for nums in test_cases:
        result1 = find_odd_number(nums)
        result2 = find_odd_number_dict(nums)
        result3 = find_odd_number_toggle(nums)
        print(f"Input: {nums}")
        print(f"  XOR: {result1}, Dict: {result2}, Toggle: {result3}")
