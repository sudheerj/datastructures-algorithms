# **Binary to Decimal**

## **Problem Statement**
Given head of a singly linked list containing binary digits (0 or 1), return the decimal value of the number.

---

## **Examples**

### Example 1:
- **Input**: `[1,0,1]`
- **Output**: `5` (binary 101 = decimal 5)

### Example 2:
- **Input**: `[0]`
- **Output**: `0`

---

## **Algorithmic Approach**

1. Initialize result to 0.
2. Traverse the list:
   - result = result * 2 + current.val
   - Or: result = (result << 1) | current.val
3. Return result.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  Only one variable used.
