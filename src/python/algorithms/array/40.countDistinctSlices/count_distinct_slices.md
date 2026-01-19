# **Count Distinct Slices**

## **Problem Statement**
Count the number of distinct slices (contiguous subsequences) containing only unique elements.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 4, 5, 5, 2]`
- **Output**: `9`
- **Explanation**: (3), (4), (5), (5), (2), (3,4), (4,5), (5,2), (3,4,5)

---

## **Algorithmic Approach (Sliding Window)**

1. Use a sliding window with a set to track unique elements.
2. Initialize front and back pointers.
3. Expand front while elements are unique:
   - Add count of valid slices ending at front.
4. When duplicate found:
   - Shrink from back until duplicate is removed.
5. Continue until all elements processed.
6. Return count (capped at max integer if needed).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Each element added and removed at most once.

- **Space Complexity**: `O(n)`  
  For the set of unique elements.
