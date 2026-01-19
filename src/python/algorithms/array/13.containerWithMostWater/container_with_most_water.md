# **Container With Most Water**

## **Problem Statement**
Given `n` non-negative integers `height` where each represents a point at coordinate `(i, height[i])`, find two lines that together with the x-axis form a container, such that the container holds the most water.

---

## **Examples**

### Example 1:
- **Input**: `height = [1, 8, 6, 2, 5, 4, 8, 3, 7]`
- **Output**: `49`
- **Explanation**: Lines at index 1 and 8 form the container with most water.

### Example 2:
- **Input**: `height = [1, 1]`
- **Output**: `1`

---

## **Algorithmic Approach (Two Pointers)**

This problem is solved using the **two pointer** technique:

1. Initialize `left = 0` and `right = len(height) - 1`.
2. Initialize `max_area = 0`.
3. While `left < right`:
   - Calculate current area: `min(height[left], height[right]) * (right - left)`.
   - Update `max_area` if current area is larger.
   - Move the pointer pointing to the shorter line:
     - If `height[left] < height[right]`: Increment `left`.
     - Else: Decrement `right`.
4. Return `max_area`.

The key insight is that moving the shorter line might find a taller line that increases the area, while moving the taller line can only decrease the area.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array with two pointers.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
