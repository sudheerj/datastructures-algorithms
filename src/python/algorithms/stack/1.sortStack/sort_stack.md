# **Sort Stack**

## **Problem Statement**
Sort a stack such that the smallest items are on top. You can only use an additional temporary stack.

---

## **Examples**

### Example 1:
- **Input**: Stack [34, 3, 31, 98, 92, 23] (top is 23)
- **Output**: Stack [3, 23, 31, 34, 92, 98] (top is 3)

---

## **Algorithmic Approach**

1. Use a temporary stack.
2. While input stack is not empty:
   - Pop element from input.
   - While temp stack not empty AND top of temp > current:
     - Move elements back to input.
   - Push current to temp.
3. Transfer all from temp back to input.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n²)`  
  Each element may be moved multiple times.

- **Space Complexity**: `O(n)`  
  For the temporary stack.
