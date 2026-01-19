# **Majority Element**

## **Problem Statement**
Given an array `nums` of size `n`, return the majority element. The majority element is the element that appears more than `n/2` times.

---

## **Examples**

### Example 1:
- **Input**: `nums = [3, 2, 3]`
- **Output**: `3`

### Example 2:
- **Input**: `nums = [2, 2, 1, 1, 1, 2, 2]`
- **Output**: `2`

---

## **Algorithmic Approach (Boyer-Moore Voting Algorithm)**

1. Initialize `count = 0` and `candidate = None`.
2. Iterate through each element:
   - If `count == 0`: Set current element as `candidate`.
   - If current element equals `candidate`: Increment `count`.
   - Else: Decrement `count`.
3. Return `candidate`.

The algorithm works because the majority element's count will always remain positive after all cancellations.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the array.

- **Space Complexity**: `O(1)`  
  Only constant extra space is used.
