"""
Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.

Time Complexity: O(n)
Space Complexity: O(1)
"""


def find_two_sum_indices(nums, target):
    """
    Two pointer approach for sorted array.
    TC: O(n), SC: O(1)
    """
    left, right = 0, len(nums) - 1

    while left < right:
        total = nums[left] + nums[right]

        if total == target:
            return [left + 1, right + 1]  # Return 1-based indices
        elif total > target:
            right -= 1  # Move the right pointer leftward
        else:
            left += 1  # Move the left pointer rightward

    return [-1, -1]


# Test cases
if __name__ == "__main__":
    # Note: Array must be sorted for two-pointer approach to work
    nums1 = [2, 7, 11, 15]
    target1 = 9
    nums2 = [-2, 0, 3, 5]
    target2 = 1
    
    print(f"Indices for target {target1} in {nums1}: {find_two_sum_indices(nums1, target1)}")  # [1, 2]
    print(f"Indices for target {target2} in {nums2}: {find_two_sum_indices(nums2, target2)}")  # [2, 3]
