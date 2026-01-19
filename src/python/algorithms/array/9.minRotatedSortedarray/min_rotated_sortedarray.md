# **Find Minimum in Rotated Sorted Array**

## **Problem Statement**
Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 4, 5, 1, 2]`
- **Output**: `1`
- **Explanation**: The original array was `[1, 2, 3, 4, 5]` rotated 3 times.

### Example 2:
- **Input**: `nums = [4, 5, 6, 7, 0, 1, 2]`
- **Output**: `0`

### Example 3:
- **Input**: `nums = [11, 13, 15, 17]`
- **Output**: `11`
- **Explanation**: The array was not rotated.

---

## **Algorithmic Approach (Binary Search)**

This problem is solved using **binary search**:

1. Initialize `left = 0` and `right = len(nums) - 1`.
2. While `left < right`:
   - Calculate `mid = (left + right) // 2`.
   - If `nums[mid] > nums[right]`: The minimum is in the right half, so set `left = mid + 1`.
   - Otherwise: The minimum is in the left half (including mid), so set `right = mid`.
3. Return `nums[left]` as the minimum element.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(log n)`  
  Binary search reduces the search space by half each iteration.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
