# **Intersection of Two Arrays**

## **Problem Statement**
Given two integer arrays `nums1` and `nums2`, return an array of their intersection. Each element in the result must be unique.

---

## **Examples**

### Example 1:
- **Input**: `nums1 = [1, 2, 2, 1], nums2 = [2, 2]`
- **Output**: `[2]`

### Example 2:
- **Input**: `nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]`
- **Output**: `[9, 4]`

---

## **Algorithmic Approach (Set)**

1. Convert `nums1` to a set.
2. Iterate through `nums2`:
   - If the element exists in the set, add to result and remove from set.
3. Return the result.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n + m)`  
  Where n and m are lengths of the arrays.

- **Space Complexity**: `O(min(n, m))`  
  For the set and result.
