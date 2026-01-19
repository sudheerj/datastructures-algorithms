# **Tape Equilibrium**

## **Problem Statement**
A non-empty array A of N integers. Find the minimal absolute difference between the sums of two parts when splitting the array at any position P.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 1, 2, 4, 3]`
- **Output**: `1`
- **Explanation**: Split at P=3: |3+1+2 - 4+3| = |6-7| = 1

---

## **Algorithmic Approach**

1. Calculate the total sum of the array.
2. Initialize left sum to 0 and min difference to infinity.
3. Iterate through the array (excluding last element):
   - Add current element to left sum.
   - Calculate right sum as total - left sum.
   - Update min difference if current difference is smaller.
4. Return min difference.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Two passes through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space used.
