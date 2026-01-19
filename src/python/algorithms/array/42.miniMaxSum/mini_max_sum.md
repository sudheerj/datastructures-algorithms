# **Mini-Max Sum**

## **Problem Statement**
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.

---

## **Examples**

### Example 1:
- **Input**: `arr = [1, 2, 3, 4, 5]`
- **Output**: `10 14`
- **Explanation**: Min sum = 1+2+3+4 = 10, Max sum = 2+3+4+5 = 14

---

## **Algorithmic Approach**

1. Calculate the total sum of all elements.
2. Find the minimum and maximum elements.
3. Minimum sum = total sum - maximum element.
4. Maximum sum = total sum - minimum element.
5. Print both values.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass to find sum, min, and max.

- **Space Complexity**: `O(1)`  
  Only constant extra space used.
