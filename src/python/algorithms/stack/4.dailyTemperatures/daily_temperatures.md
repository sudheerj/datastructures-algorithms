# **Daily Temperatures**

## **Problem Statement**
Given an array of daily temperatures, return an array where each element tells you how many days until a warmer temperature. If no future day is warmer, put 0.

---

## **Examples**

### Example 1:
- **Input**: `[73, 74, 75, 71, 69, 72, 76, 73]`
- **Output**: `[1, 1, 4, 2, 1, 1, 0, 0]`

---

## **Algorithmic Approach (Monotonic Stack)**

1. Use stack to store indices of temperatures.
2. For each day:
   - While stack not empty AND current temp > temp at stack top:
     - Pop index, calculate days difference.
   - Push current index to stack.
3. Remaining indices in stack have no warmer day (already 0).

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Each index pushed and popped at most once.

- **Space Complexity**: `O(n)`  
  For the stack.
