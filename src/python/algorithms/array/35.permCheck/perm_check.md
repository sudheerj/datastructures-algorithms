# **Permutation Check**

## **Problem Statement**
Check whether an array is a permutation of integers from 1 to N.

---

## **Examples**

### Example 1:
- **Input**: `nums = [4, 1, 3, 2]`
- **Output**: `1` (Valid permutation)

### Example 2:
- **Input**: `nums = [4, 1, 3]`
- **Output**: `0` (Missing 2)

### Example 3:
- **Input**: `nums = [1, 2, 2, 3]`
- **Output**: `0` (Duplicate)

---

## **Algorithmic Approach (Set or Array)**

### Using Set:
1. Iterate through the array.
2. For each element:
   - Check if out of range [1, n] or already seen.
   - If so, return 0.
   - Otherwise, add to seen set.
3. Return 1 if all elements valid.

### Using Boolean Array:
Same logic but with a boolean array for tracking.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(n)`  
  For tracking seen elements.
