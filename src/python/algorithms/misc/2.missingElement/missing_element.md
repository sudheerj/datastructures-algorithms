# **Missing Element**

## **Problem Statement**
Find the missing element in an array containing n-1 integers in the range 1 to n.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 2, 4, 5]`, n = 5
- **Output**: `3`

---

## **Algorithmic Approach**

### XOR Method:
1. XOR all numbers 1 to n.
2. XOR all array elements.
3. Result is the missing number.

### Sum Method:
1. Calculate expected sum: n*(n+1)/2
2. Subtract actual sum of array.
3. Difference is the missing number.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through array.

- **Space Complexity**: `O(1)`  
  Constant extra space.
