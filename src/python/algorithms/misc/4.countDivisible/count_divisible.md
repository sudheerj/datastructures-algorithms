# **Count Divisible**

## **Problem Statement**
Count the number of integers in range [A, B] that are divisible by K.

---

## **Examples**

### Example 1:
- **Input**: `A = 6, B = 11, K = 2`
- **Output**: `3` (6, 8, 10 are divisible by 2)

---

## **Algorithmic Approach**

Use math formula instead of iteration:
1. Count = floor(B/K) - floor((A-1)/K)
2. Or: Count multiples up to B minus multiples below A.

Handle edge case when A = 0.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(1)`  
  Direct calculation.

- **Space Complexity**: `O(1)`  
  Constant extra space.
