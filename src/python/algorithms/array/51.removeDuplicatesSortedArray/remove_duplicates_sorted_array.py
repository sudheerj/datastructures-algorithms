# TC: O(n) SC: O(1)
def remove_duplicates(nums):
    left = 0

    for j in range(1, len(nums)):
        if nums[j] != nums[left]:
            left += 1
            nums[left] = nums[j]

    return left + 1


# Test cases
if __name__ == "__main__":
    # Test 1: General case with duplicates
    nums1 = [1, 1, 2]
    count1 = remove_duplicates(nums1)
    print("Test 1:", nums1[:count1])  # [1, 2]

    # Test 2: Multiple duplicates
    nums2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    count2 = remove_duplicates(nums2)
    print("Test 2:", nums2[:count2])  # [0, 1, 2, 3, 4]

    # Test 3: No duplicates
    nums3 = [1, 2, 3, 4, 5]
    count3 = remove_duplicates(nums3)
    print("Test 3:", nums3[:count3])  # [1, 2, 3, 4, 5]

    # Test 4: Single element
    nums4 = [1]
    count4 = remove_duplicates(nums4)
    print("Test 4:", nums4[:count4])  # [1]

    # Test 5: All same elements
    nums5 = [7, 7, 7, 7]
    count5 = remove_duplicates(nums5)
    print("Test 5:", nums5[:count5])  # [7]

    # Test 6: Negative numbers
    nums6 = [-3, -1, -1, 0, 0, 2]
    count6 = remove_duplicates(nums6)
    print("Test 6:", nums6[:count6])  # [-3, -1, 0, 2]

    # Test 7: Two elements - duplicates
    nums7 = [5, 5]
    count7 = remove_duplicates(nums7)
    print("Test 7:", nums7[:count7])  # [5]
