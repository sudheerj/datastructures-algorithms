def three_sum(nums, target):
    nums.sort()

    triplets = []

    for i in range(len(nums)-2):
        if i > 0 and nums[i] == nums[i-1]:
            continue

        left, right = i + 1, len(nums) -1

        while left < right:
            sum = nums[i] + nums[left] + nums[right]

            if sum < target:
                left += 1
            elif sum > target:
                right -= 1
            else:
                triplets.append([nums[i], nums[left], nums[right]])

                left += 1
                while left < right and nums[left] == nums[left-1]:
                    left += 1

                right -=1
                while left < right and nums[right] == nums[right+1]:
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
            