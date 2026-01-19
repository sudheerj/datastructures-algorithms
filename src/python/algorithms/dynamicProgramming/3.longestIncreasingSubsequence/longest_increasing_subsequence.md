# **Longest Increasing Subsequence**

## **Problem Statement**
Given an integer array `nums`, return the length of the longest strictly increasing subsequence.

---

## **Examples**

### Example 1:
- **Input**: `nums = [10, 9, 2, 5, 3, 7, 101, 18]`
- **Output**: `4` ([2, 3, 7, 101])

### Example 2:
- **Input**: `nums = [0, 1, 0, 3, 2, 3]`
- **Output**: `4`

---

## **Algorithmic Approach (Binary Search)**

1. Maintain a "tails" array where `tails[i]` is the smallest tail of all increasing subsequences of length `i+1`.
2. For each number:
   - Binary search for the position in tails.
   - Replace or extend tails array.
3. Return length of tails.

**Alternative O(n²) DP:**
- `dp[i]` = longest subsequence ending at index i.

---

## **Time and Space Complexity**

**Binary Search:**
- **Time Complexity**: `O(n log n)`
- **Space Complexity**: `O(n)`

**DP Approach:**
- **Time Complexity**: `O(n²)`
- **Space Complexity**: `O(n)`
