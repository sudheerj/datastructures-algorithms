def rotate_right(nums, k):

    n = len(nums)

    if n == 0 or k % n == 0:
        return nums

    k = k % n

    rotate(nums, 0, n-1)
    rotate(nums, 0, k-1)
    rotate(nums, k, n-1)

    return nums

def rotate_left(nums, k):

    n = len(nums)

    if n == 0 or k % n == 0:
        return nums

    k = k % n

    rotate(nums, 0, k-1)
    rotate(nums, k, n-1)
    rotate(nums, 0, n-1)

    return nums

def rotate_right_list(nums, k):
    n = len(nums)

    if n == 0 or k % n == 0:
        return nums
    k = k % n
    results = [0] * n

    for i in range(n):
        results[(i+k) % n] = nums[i]

    return results

def rotate(nums, start, end):

    while start <= end:
        nums[start], nums[end] = nums[end], nums[start]
        start += 1
        end -= 1

    return nums

# Test cases
if __name__ == "__main__":
    # Test rotate right
    nums1 = [1, 2, 3, 4, 5, 6, 7]
    k1 = 3
    print(f"Original: {nums1}, k={k1}")
    print(f"Rotated right: {rotate_right(nums1.copy(), k1)}")  # [5, 6, 7, 1, 2, 3, 4]
    
    # Test rotate left
    nums2 = [1, 2, 3, 4, 5, 6, 7]
    k2 = 3
    print(f"Original: {nums2}, k={k2}")
    print(f"Rotated left: {rotate_left(nums2.copy(), k2)}")  # [4, 5, 6, 7, 1, 2, 3]
    
    # Test rotate using list
    nums3 = [1, 2, 3, 4, 5, 6, 7]
    k3 = 3
    print(f"Original: {nums3}, k={k3}")
    print(f"Rotated (using array): {rotate_right_list(nums3, k3)}")