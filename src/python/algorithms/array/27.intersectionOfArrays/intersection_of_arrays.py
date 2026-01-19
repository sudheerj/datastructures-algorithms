"""
Intersection of Two Arrays

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must be unique and may appear once in the output.

Time Complexity: O(n + m)
Space Complexity: O(min(n, m))
"""


def intersection(nums1, nums2):
    """
    Using set for O(n + m) time complexity.
    TC: O(n + m), SC: O(n)
    """
    num_set = set(nums1)
    result = []
    
    for num in nums2:
        if num in num_set:
            result.append(num)
            num_set.remove(num)
    
    return result


def intersection_with_duplicates(nums1, nums2):
    """
    Return intersection including duplicates (intersection II).
    TC: O(n + m), SC: O(n)
    """
    from collections import Counter
    
    count1 = Counter(nums1)
    result = []
    
    for num in nums2:
        if count1[num] > 0:
            result.append(num)
            count1[num] -= 1
    
    return result


# Test cases
if __name__ == "__main__":
    # Test unique intersection
    nums1, nums2 = [5, 3, 3, 5], [5, 3]
    print(f"Intersection of {nums1} and {nums2}: {intersection(nums1.copy(), nums2)}")  # [5, 3]
    
    nums3, nums4 = [1, 3, 5], [2, 4]
    print(f"Intersection of {nums3} and {nums4}: {intersection(nums3.copy(), nums4)}")  # []
    
    # Test intersection with duplicates
    nums5, nums6 = [1, 2, 2, 1], [2, 2]
    print(f"Intersection with duplicates of {nums5} and {nums6}: {intersection_with_duplicates(nums5, nums6)}")  # [2, 2]
