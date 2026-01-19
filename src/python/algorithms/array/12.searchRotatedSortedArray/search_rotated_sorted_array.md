# **Search in Rotated Sorted Array**

## **Problem Statement**
Given the array `nums` after rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not.

---

## **Examples**

### Example 1:
- **Input**: `nums = [4, 5, 6, 7, 0, 1, 2], target = 0`
- **Output**: `4`

### Example 2:
- **Input**: `nums = [4, 5, 6, 7, 0, 1, 2], target = 3`
- **Output**: `-1`

### Example 3:
- **Input**: `nums = [1], target = 0`
- **Output**: `-1`

---

## **Algorithmic Approach (Modified Binary Search)**

This problem is solved using **modified binary search**:

1. Initialize `left = 0` and `right = len(nums) - 1`.
2. While `left <= right`:
   - Calculate `mid = (left + right) // 2`.
   - If `nums[mid] == target`: Return `mid`.
   - Determine which half is sorted:
     - If `nums[left] <= nums[mid]` (left half is sorted):
       - If `nums[left] <= target < nums[mid]`: Search left (`right = mid - 1`).
       - Else: Search right (`left = mid + 1`).
     - Else (right half is sorted):
       - If `nums[mid] < target <= nums[right]`: Search right (`left = mid + 1`).
       - Else: Search left (`right = mid - 1`).
3. Return `-1` if not found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(log n)`  
  Binary search divides the search space by half each iteration.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
