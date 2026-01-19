# **Set Mismatch**

## **Problem Statement**
You have a set of integers `s`, which originally contains all numbers from 1 to n. Due to an error, one number is duplicated and another is missing. Find both the duplicate and missing numbers.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 2, 2, 4]`
- **Output**: `[2, 3]` (duplicate = 2, missing = 3)

### Example 2:
- **Input**: `nums = [1, 1]`
- **Output**: `[1, 2]`

---

## **Algorithmic Approach (Index Marking)**

1. Iterate through the array:
   - For each number, mark its corresponding index as negative.
   - If the index is already negative, we found the duplicate.
2. Iterate again to find the positive index - that index + 1 is the missing number.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the array.

- **Space Complexity**: `O(1)`  
  In-place modification with constant extra space.
