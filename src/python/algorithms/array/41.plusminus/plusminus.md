# **Plus Minus**

## **Problem Statement**
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with 6 places after the decimal.

---

## **Examples**

### Example 1:
- **Input**: `arr = [1, 1, 0, -1, -1]`
- **Output**:
  ```
  0.400000
  0.400000
  0.200000
  ```

---

## **Algorithmic Approach**

1. Initialize counters for positive, negative, and zero.
2. Iterate through the array:
   - Increment appropriate counter based on element's sign.
3. Calculate ratios by dividing each count by total length.
4. Print each ratio formatted to 6 decimal places.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only three counters used.
