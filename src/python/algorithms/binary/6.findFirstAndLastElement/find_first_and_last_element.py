# TC: O(log n) SC: O(1)
def find_bound(nums, target, find_first):
    left, right, index = 0, len(nums) - 1, -1

    while left <= right:
        mid = left + (right - left) // 2

        if nums[mid] == target:
            index = mid
            if find_first:
                right = mid - 1  # shrink to left part
            else:
                left = mid + 1  # shrink to right part
        elif nums[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return index


def search_range(nums, target):
    return [find_bound(nums, target, True), find_bound(nums, target, False)]


# Test cases
if __name__ == "__main__":
    # Test 1: Target appears multiple times
    print("Test 1:", search_range([5, 7, 7, 8, 8, 10], 8))  # [3, 4]

    # Test 2: Target not found
    print("Test 2:", search_range([5, 7, 7, 8, 8, 10], 6))  # [-1, -1]

    # Test 3: Empty array
    print("Test 3:", search_range([], 0))  # [-1, -1]

    # Test 4: Single element - found
    print("Test 4:", search_range([5], 5))  # [0, 0]

    # Test 5: Single element - not found
    print("Test 5:", search_range([5], 3))  # [-1, -1]

    # Test 6: All same elements
    print("Test 6:", search_range([2, 2, 2, 2, 2], 2))  # [0, 4]

    # Test 7: Target at the beginning
    print("Test 7:", search_range([1, 1, 3, 5, 7], 1))  # [0, 1]

    # Test 8: Target at the end
    print("Test 8:", search_range([1, 3, 5, 7, 7], 7))  # [3, 4]
