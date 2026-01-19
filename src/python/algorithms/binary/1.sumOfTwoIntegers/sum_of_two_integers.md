# **Sum of Two Integers**

## **Problem Statement**
Given two integers `a` and `b`, return the sum of the two integers without using the operators `+` and `-`.

---

## **Examples**

### Example 1:
- **Input**: `a = 1, b = 2`
- **Output**: `3`

### Example 2:
- **Input**: `a = 2, b = 3`
- **Output**: `5`

---

## **Algorithmic Approach (Bit Manipulation)**

The approach uses bit manipulation:
1. `a XOR b` gives sum without carry.
2. `(a AND b) << 1` gives the carry.
3. Repeat until no carry remains.

For Python, handle negative numbers with masking.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(1)`  
  Maximum 32 iterations for 32-bit integers.

- **Space Complexity**: `O(1)`  
  Only constant extra space used.
