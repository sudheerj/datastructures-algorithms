# **Rotate Array**

## **Problem Statement**
Given an integer array `nums`, rotate the array to the right by `k` steps.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 2, 3, 4, 5, 6, 7], k = 3`
- **Output**: `[5, 6, 7, 1, 2, 3, 4]`

### Example 2:
- **Input**: `nums = [-1, -100, 3, 99], k = 2`
- **Output**: `[3, 99, -1, -100]`

---

## **Algorithmic Approach (Reversal Algorithm)**

The most efficient in-place approach uses the **reversal algorithm**:

1. Handle edge case: If array is empty or `k % length == 0`, no rotation needed.
2. Normalize `k`: `k = k % length` to handle cases where `k > length`.
3. Reverse the entire array.
4. Reverse the first `k` elements.
5. Reverse the remaining `length - k` elements.

### Example Walkthrough:
- Original: `[1, 2, 3, 4, 5, 6, 7]`, k = 3
- After full reverse: `[7, 6, 5, 4, 3, 2, 1]`
- After reversing first 3: `[5, 6, 7, 4, 3, 2, 1]`
- After reversing last 4: `[5, 6, 7, 1, 2, 3, 4]`

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Each element is moved exactly twice.

- **Space Complexity**: `O(1)`  
  In-place rotation with constant extra space.
