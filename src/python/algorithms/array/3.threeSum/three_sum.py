"""
Three Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == target.

Time Complexity: O(n^2)
Space Complexity: O(1) (excluding output)
"""


def three_sum(nums, target=0):
    """
    Two pointer approach.
    Time Complexity: O(n log n) + O(n^2) => O(n^2)
    Space Complexity: O(1)
    """
    # Sort the array to facilitate the two-pointer approach
    nums.sort()
    triplets = []

    for i in range(len(nums) - 2):
        # Skip duplicate numbers to avoid duplicate triplets
        if i > 0 and nums[i] == nums[i - 1]:
            continue

        left, right = i + 1, len(nums) - 1

        # Use two pointers to find the remaining two numbers
        while left < right:
            total = nums[i] + nums[left] + nums[right]

            if total < target:
                left += 1
            elif total > target:
                right -= 1
            else:
                # Found a valid triplet
                triplets.append([nums[i], nums[left], nums[right]])

                # Move left pointer to the next unique number
                left += 1
                while left < right and nums[left] == nums[left - 1]:
                    left += 1

                # Move right pointer to the next unique number
                right -= 1
                while left < right and nums[right] == nums[right + 1]:
                    right -= 1

    return triplets


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"nums": [3, 3, -1, -2, 0, -2, 0, -1, 0, -1], "target": 0},
        {"nums": [1, 3, 5, 1], "target": 0},
        {"nums": [-4, -1, -1, 0, 1, 2], "target": 0},
        {"nums": [0, 0, 0], "target": 0},  # Edge case: all zeroes
    ]

    for i, test in enumerate(test_cases):
        print(f"Test Case {i + 1}: {three_sum(test['nums'], test['target'])}")
