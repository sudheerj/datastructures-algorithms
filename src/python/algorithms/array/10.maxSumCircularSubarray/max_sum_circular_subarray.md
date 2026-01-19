# **Maximum Sum Circular Subarray**

## **Problem Statement**
Given a circular integer array `nums`, return the maximum possible sum of a non-empty subarray. A circular array means the end of the array connects to the beginning.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, -2, 3, -2]`
- **Output**: `3`
- **Explanation**: Subarray `[3]` has maximum sum 3.

### Example 2:
- **Input**: `nums = [5, -3, 5]`
- **Output**: `10`
- **Explanation**: Subarray `[5, 5]` (wrapping around) has maximum sum 10.

### Example 3:
- **Input**: `nums = [-3, -2, -3]`
- **Output**: `-2`

---

## **Algorithmic Approach (Kadane's Algorithm Extended)**

This problem extends Kadane's algorithm to handle circular arrays:

1. Use Kadane's algorithm to find the maximum subarray sum (`global_max_sum`).
2. Use Kadane's algorithm to find the minimum subarray sum (`global_min_sum`).
3. Calculate `total_sum` of the array.
4. The maximum circular sum is `total_sum - global_min_sum` (elements not in the minimum subarray).
5. Return `max(global_max_sum, total_sum - global_min_sum)`.
6. Edge case: If all elements are negative, return `global_max_sum`.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
