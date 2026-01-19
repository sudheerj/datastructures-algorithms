"""
Count Distinct Slices

Count the number of distinct slices (contiguous subsequences) 
where all elements are unique.

Time Complexity: O(n)
Space Complexity: O(m) where m is the max value
"""


def count_distinct_slices(m, numbers):
    """
    Sliding window approach.
    TC: O(n), SC: O(m)
    """
    length = len(numbers)
    seen = [False] * (m + 1)
    
    left = 0
    right = 0
    total = 0
    
    while right < length:
        if not seen[numbers[right]]:
            seen[numbers[right]] = True
            total += right - left + 1
            if total > 1000000000:
                return 1000000000
            right += 1
        else:
            seen[numbers[left]] = False
            left += 1
    
    return total


def count_distinct_slices_set(numbers):
    """
    Using set for tracking seen elements.
    TC: O(n), SC: O(n)
    """
    length = len(numbers)
    seen = set()
    
    left = 0
    total = 0
    
    for right in range(length):
        while numbers[right] in seen:
            seen.remove(numbers[left])
            left += 1
        
        seen.add(numbers[right])
        total += right - left + 1
        
        if total > 1000000000:
            return 1000000000
    
    return total


# Test cases
if __name__ == "__main__":
    test_cases = [
        (6, [3, 4, 5, 5, 2]),   # Output: 9
        (5, [1, 2, 3, 4]),      # Output: 10
        (2, [1, 1, 1, 1]),      # Output: 4
        (3, [0, 1, 0, 2, 0]),   # Output: 10
    ]
    
    for m, nums in test_cases:
        result1 = count_distinct_slices(m, nums)
        result2 = count_distinct_slices_set(nums)
        print(f"Input: m={m}, nums={nums}")
        print(f"  Array: {result1}, Set: {result2}")
