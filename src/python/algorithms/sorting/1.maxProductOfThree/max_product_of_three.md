# **Max Product of Three**

## **Problem Statement**
Given a non-empty array of integers, find the maximum product of any three elements.

---

## **Examples**

### Example 1:
- **Input**: `[-3, 1, 2, -2, 5, 6]`
- **Output**: `60` (5 * 6 * 2)

### Example 2:
- **Input**: `[-5, 5, -5, 4]`
- **Output**: `125` (-5 * -5 * 5)

---

## **Algorithmic Approach**

Two candidates for maximum product:
1. Three largest positive numbers.
2. Two smallest (most negative) numbers × largest positive.

### Steps:
1. Sort the array.
2. Calculate: max(arr[-1] × arr[-2] × arr[-3], arr[0] × arr[1] × arr[-1])
3. Return the maximum.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n log n)`  
  Dominated by sorting.

- **Space Complexity**: `O(1)` or `O(n)`  
  Depends on sorting implementation.
