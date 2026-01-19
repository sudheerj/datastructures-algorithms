# **Frog River One**

## **Problem Statement**
A frog wants to cross a river by jumping on leaves. Leaves fall at positions given in array A at times 0, 1, 2, etc. Find the earliest time when the frog can jump to position X (all positions 1 to X must be covered).

---

## **Examples**

### Example 1:
- **Input**: `X = 5, A = [1, 3, 1, 4, 2, 3, 5, 4]`
- **Output**: `6` (At time 6, all positions 1-5 are covered)

---

## **Algorithmic Approach**

1. Use a set to track covered positions.
2. Iterate through array (time):
   - Add each position to set.
   - When set size equals X, return current time.
3. Return -1 if impossible.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through array.

- **Space Complexity**: `O(X)`  
  Set to track covered positions.
