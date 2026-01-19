# **Third Largest Element**

## **Problem Statement**
Given an integer array, return the third largest distinct element. If it doesn't exist, indicate so.

---

## **Examples**

### Example 1:
- **Input**: `arr = [3, 2, 1]`
- **Output**: `1`

### Example 2:
- **Input**: `arr = [1, 2]`
- **Output**: `"There are no 3 unique elements"`

### Example 3:
- **Input**: `arr = [2, 2, 3, 1]`
- **Output**: `1`

---

## **Algorithmic Approach (Three Variables)**

1. Initialize three variables: `first`, `second`, `third` to negative infinity.
2. Iterate through each element:
   - Skip if it equals any of the three.
   - If > first: Shift all three down and update first.
   - Else if > second: Shift second to third, update second.
   - Else if > third: Update third.
3. Return third if valid, otherwise indicate not found.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only three variables used.
