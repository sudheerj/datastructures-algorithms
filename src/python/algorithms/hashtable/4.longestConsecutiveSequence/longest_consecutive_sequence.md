# **Longest Consecutive Sequence**

## **Problem Statement**
Given an unsorted array of integers, return the length of the longest consecutive elements sequence.

---

## **Examples**

### Example 1:
- **Input**: `nums = [100, 4, 200, 1, 3, 2]`
- **Output**: `4` (sequence: 1, 2, 3, 4)

### Example 2:
- **Input**: `nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]`
- **Output**: `9`

---

## **Algorithmic Approach (Hash Set)**

1. Convert array to hash set.
2. For each number:
   - Check if it's a sequence start (num-1 not in set).
   - If yes, count consecutive numbers (num+1, num+2, ...).
   - Track maximum length found.
3. Return maximum length.

This ensures each number is processed at most twice.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Each number visited at most twice.

- **Space Complexity**: `O(n)`  
  For the hash set.
