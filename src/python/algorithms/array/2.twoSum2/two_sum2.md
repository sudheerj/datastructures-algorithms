# Two Sum II - Algorithm Explanation

## **Problem Description**
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function `find_two_sum_indices` should return the indices of the two numbers such that they add up to the target, where `index1` must be less than `index2`.

---

## **Example**
### Input: 
```plaintext
numbers = [2, 7, 11, 15], target = 9
```

### Output:
```plaintext
[1, 2]  # 1-based indices
```

---

## **Algorithmic Steps**
The problem is solved using the **two pointers** technique. The algorithm can be summarized as follows:

1. **Initialize Pointers:**
   - Set the `left` pointer to the start of the array (index `0`).
   - Set the `right` pointer to the last index of the array (`len(nums) - 1`).

2. **Iterate and Calculate:**
   - Compute the `total` by summing the elements at the `left` and `right` pointers.

3. **Check Conditions:**
   - If `total == target`:
     - Return the indices `[left + 1, right + 1]` (convert 0-based indices to 1-based).
   - If `total > target`:
     - Decrement the `right` pointer to reduce the `total`.
   - If `total < target`:
     - Increment the `left` pointer to increase the `total`.

4. **Repeat:**
   - Continue steps 2 and 3 until the two numbers sum up to the `target`.

5. **Handle Edge Cases:**
   - If no such numbers exist that sum to the `target`, return `[-1, -1]`.

---

## **Time and Space Complexity**
- **Time Complexity:** 
  - The algorithm runs in **O(n)**, where `n` is the number of elements in the array. This is because we traverse the array at most once.

- **Space Complexity:** 
  - The space complexity is **O(1)**, as only two pointer variables are used, and no additional data structures are required.
