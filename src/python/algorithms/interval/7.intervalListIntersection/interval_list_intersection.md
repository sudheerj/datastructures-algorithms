# **Interval List Intersections**

## **Problem Statement**
Given two lists of closed intervals, return the intersection of these two interval lists.

---

## **Examples**

### Example 1:
- **Input**: 
  - `firstList = [[0,2],[5,10],[13,23],[24,25]]`
  - `secondList = [[1,5],[8,12],[15,24],[25,26]]`
- **Output**: `[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]`

---

## **Algorithmic Approach (Two Pointers)**

1. Use two pointers, one for each list.
2. At each step:
   - Find intersection of current intervals (max of starts, min of ends).
   - If valid intersection (start <= end), add to result.
   - Move pointer of interval that ends first.
3. Continue until one list is exhausted.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(m + n)`  
  Where m and n are lengths of the two lists.

- **Space Complexity**: `O(m + n)`  
  For the result (worst case all intersect).
