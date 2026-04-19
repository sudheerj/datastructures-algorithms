def median_sorted_arrays(nums1, nums2):
    # Ensure nums1 is the smaller array
    if len(nums1) > len(nums2):
        return median_sorted_arrays(nums2, nums1)
    n1, n2 = len(nums1), len(nums2)
    total = n1 + n2
    half = total // 2
    left, right = 0, n1 - 1
    while True:
        i = (left + right) // 2 if n1 > 0 else -1
        j = half - i - 2
        first_left = nums1[i] if i >= 0 else float('-inf')
        first_right = nums1[i+1] if (i+1) < n1 else float('inf')
        second_left = nums2[j] if j >= 0 else float('-inf')
        second_right = nums2[j+1] if (j+1) < n2 else float('inf')
        if first_left <= second_right and second_left <= first_right:
            if total % 2:
                return min(first_right, second_right)
            return (max(first_left, second_left) + min(first_right, second_right)) / 2
        elif first_left > second_right:
            right = i - 1
        else:
            left = i + 1

if __name__ == "__main__":
    # Test case 1: Even total length
    nums1 = [1, 3]
    nums2 = [2, 4]
    print("Median (Even total):", median_sorted_arrays(nums1, nums2))  # Expected: 2.5

    # Test case 2: Odd total length
    nums3 = [1, 2]
    nums4 = [3, 4, 5]
    print("Median (Odd total):", median_sorted_arrays(nums3, nums4))  # Expected: 3.0

    # Test case 3: One array empty
    nums5 = []
    nums6 = [1]
    print("Median (One empty):", median_sorted_arrays(nums5, nums6))  # Expected: 1.0

    # Test case 4: Both arrays empty
    nums7 = []
    nums8 = []
    try:
        print("Median (Both empty):", median_sorted_arrays(nums7, nums8))  # Expected: Exception or error
    except Exception as e:
        print("Exception:", e)

    # Test case 5: Arrays with negative numbers
    nums9 = [-5, 3, 6]
    nums10 = [-2, 4, 10]
    print("Median (Negatives):", median_sorted_arrays(nums9, nums10))  # Expected: 3.5
