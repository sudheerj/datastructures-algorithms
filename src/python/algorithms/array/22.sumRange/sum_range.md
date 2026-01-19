# **Range Sum Query - Immutable**

## **Problem Statement**
Given an integer array `nums`, handle multiple queries of the following type: Calculate the sum of elements between indices `left` and `right` inclusive.

---

## **Examples**

### Example 1:
- **Input**: `nums = [-2, 0, 3, -5, 2, -1]`
- **Queries**: 
  - `sumRange(0, 2)` → `1`
  - `sumRange(2, 5)` → `-1`
  - `sumRange(0, 5)` → `-3`

---

## **Algorithmic Approach (Prefix Sum)**

1. **Initialization**: Build a prefix sum array where `prefix_sum[i]` stores the sum of elements from index 0 to i-1.
2. **Query**: For range `[left, right]`, return `prefix_sum[right + 1] - prefix_sum[left]`.

---

## **Time and Space Complexity**

- **Time Complexity**: 
  - Initialization: `O(n)`
  - Query: `O(1)`

- **Space Complexity**: `O(n)`  
  For storing the prefix sum array.
