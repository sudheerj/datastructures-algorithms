# **Maximum Product Subarray**

## **Problem Statement**
Given an integer array `nums`, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

---

## **Examples**

### Example 1:
- **Input**: `nums = [2, 3, -2, 4]`
- **Output**: `6`
- **Explanation**: `[2, 3]` has the largest product 6.

### Example 2:
- **Input**: `nums = [-2, 0, -1]`
- **Output**: `0`
- **Explanation**: The result cannot be 2, because `[-2, -1]` is not a contiguous subarray.

---

## **Algorithmic Approach (Dynamic Programming)**

This problem is solved by tracking both maximum and minimum products at each position:

1. Initialize `max_product`, `min_product`, and `result` to the first element.
2. Iterate through the array starting from index 1:
   - Store `max_product` in a temporary variable.
   - Update `max_product` to be the maximum of:
     - Current element
     - Current element × previous max_product
     - Current element × previous min_product
   - Update `min_product` to be the minimum of the same three values.
   - Update `result` to be the maximum of `result` and `max_product`.
3. Return `result`.

The key insight is that a negative number can turn a minimum product into a maximum product.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
