# **Contains Duplicate**

## **Problem Statement**
Given an integer array `nums`, return `True` if any value appears at least twice in the array, and return `False` if every element is distinct.

---

## **Examples**

### Example 1:
- **Input**: `nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]`  
- **Output**: `True`  

### Example 2:
- **Input**: `nums = [1, 2, 3, 4, 5]`  
- **Output**: `False`  

---

## **Algorithmic Approach (Using Set)**

This problem can be solved optimally using a `set` to detect duplicate elements. Below is the step-by-step approach:

1. Create an empty `set` to store elements from the array.
2. Iterate through the input array using a loop.
3. For each element:
   - If the current element already exists in the `set`, return `True` immediately (indicating duplicates exist).
   - Otherwise, add the current element to the `set`.
4. If the loop completes without finding any duplicates, return `False`.

---

## **Time and Space Complexity**

- **Time Complexity**:  
  The time complexity of this algorithm is **O(n)**, where `n` is the number of elements in the array. This is because we iterate through the array once, and operations like adding or checking membership in a `set` are constant time on average.

- **Space Complexity**:  
  The space complexity is **O(n)** as we use an additional data structure (`set`) to store elements from the array.

---
