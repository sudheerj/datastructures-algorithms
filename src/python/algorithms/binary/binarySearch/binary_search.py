def binary_search(nums: list[int], target: int) -> int:
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return -1


print(binary_search([-1, 0, 3, 5, 9, 12], 9))   # 4
print(binary_search([-1, 0, 3, 5, 9, 12], 2))   # -1
print(binary_search([5], 5))                     # 0
print(binary_search([5], 6))                     # -1
print(binary_search([1, 2, 3, 4, 5], 1))        # 0
print(binary_search([1, 2, 3, 4, 5], 5))        # 4
