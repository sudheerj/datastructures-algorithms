"""
Three Sum Closest

Given an integer array nums and an integer target, return the sum of the three integers in nums such that the sum is closest to target.
"""

def three_sum_closest(nums, target):
    nums.sort()
    closest_sum = nums[0] + nums[1] + nums[2]
    for i in range(len(nums) - 2):
        left, right = i + 1, len(nums) - 1
        while left < right:
            curr_sum = nums[i] + nums[left] + nums[right]
            if abs(curr_sum - target) < abs(closest_sum - target):
                closest_sum = curr_sum
            if curr_sum < target:
                left += 1
            elif curr_sum > target:
                right -= 1
            else:
                return curr_sum
    return closest_sum

if __name__ == "__main__":
    # Example test cases
    print(three_sum_closest([1, 2, 4, 8, 16, 32, 64, 128], 82))  # Output: 82
    print(three_sum_closest([-1, 2, 1, -4], 1))  # Output: 2
    print(three_sum_closest([0, 0, 0], 1))  # Output: 0
