# **Special Array**

## **Problem Statement**
You are given an array `nums` of non-negative integers. The array is special if there exists a number `x` such that there are exactly `x` numbers in `nums` that are greater than or equal to `x`. Return `x` if it exists, otherwise return `-1`.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 5]`
- **Output**: `2` (There are 2 values >= 2)

### Example 2:
- **Input**: `nums = [0, 0]`
- **Output**: `-1`

---

## **Algorithmic Approach (Counting Sort)**

1. Create a counts array of size `n + 1`.
2. Count frequencies, grouping values >= n at index n.
3. Iterate from n down to 1:
   - Accumulate counts of elements >= x.
   - If count equals x, return x.
4. Return -1 if not found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the array.

- **Space Complexity**: `O(n)`  
  For the counts array.
