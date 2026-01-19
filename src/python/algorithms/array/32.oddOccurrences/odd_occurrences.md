# **Odd Occurrences in Array**

## **Problem Statement**
Given an array of integers, find the element that appears an odd number of times. There is exactly one such element.

---

## **Examples**

### Example 1:
- **Input**: `nums = [9, 3, 9, 3, 9, 7, 9]`
- **Output**: `7`

### Example 2:
- **Input**: `nums = [1, 2, 1, 2, 3]`
- **Output**: `3`

---

## **Algorithmic Approach (XOR)**

The XOR approach is optimal:
1. Initialize result to 0.
2. XOR all elements together.
3. The result is the element appearing odd times.

This works because:
- `x ^ x = 0` (same numbers cancel out)
- `x ^ 0 = x` (XOR with 0 gives the number)

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only one variable used.
