"""
Count Triangles

Given an array of integers, count the number of triangles that can be formed.
A triangle can be formed if a + b > c (triangle inequality).

Time Complexity: O(n^2)
Space Complexity: O(1)
"""


def count_triangles(numbers):
    """
    Two pointer approach after sorting.
    TC: O(n^2), SC: O(1)
    """
    numbers.sort()
    length = len(numbers)
    count = 0
    
    for i in range(length - 2):
        k = i + 2
        for j in range(i + 1, length - 1):
            while k < length and numbers[i] + numbers[j] > numbers[k]:
                k += 1
            count += k - j - 1
    
    return count


# Test cases
if __name__ == "__main__":
    test_cases = [
        ([10, 2, 5, 1, 8, 12], 4),
        ([4, 6, 3, 7], 3),
        ([1, 1, 1, 1], 4),
        ([5, 10, 12, 15], 3),
        ([1, 2, 3], 0),  # Cannot form any triangle
    ]
    
    for nums, expected in test_cases:
        result = count_triangles(nums.copy())
        print(f"Input: {nums} => Count: {result} (Expected: {expected})")
