# **Minimum Absolute Sum of Two**

## **Problem Statement**
Given a sorted array, find two elements whose sum has the minimum absolute value.

---

## **Examples**

### Example 1:
- **Input**: `nums = [-8, 4, 5, -10, 3]`
- **Output**: `1` (|3 + (-8)| = 5, |-8 + 5| = 3, |4 + (-3)| = 1)

### Example 2:
- **Input**: `nums = [1, 4, -3]`
- **Output**: `1`

---

## **Algorithmic Approach (Two Pointers)**

1. Sort the array.
2. Initialize two pointers: left at 0, right at end.
3. Initialize minimum to infinity.
4. While left <= right:
   - Calculate sum of elements at left and right.
   - Update minimum if absolute sum is smaller.
   - If sum < 0: increment left (need larger sum).
   - Else: decrement right (need smaller sum).
5. Return minimum.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(1)`  
  Constant extra space.
