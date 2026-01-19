# **House Robber II**

## **Problem Statement**
Same as House Robber, but houses are arranged in a circle. The first house is adjacent to the last house.

---

## **Examples**

### Example 1:
- **Input**: `nums = [2, 3, 2]`
- **Output**: `3` (Cannot rob both 2s since they're adjacent in circle)

### Example 2:
- **Input**: `nums = [1, 2, 3, 1]`
- **Output**: `4`

---

## **Algorithmic Approach**

Since houses form a circle, we can't rob both first and last house. Solution:
1. Run House Robber on houses `[0, n-2]` (exclude last).
2. Run House Robber on houses `[1, n-1]` (exclude first).
3. Return the maximum of both.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through most of the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space.
