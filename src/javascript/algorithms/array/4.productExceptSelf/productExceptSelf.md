
## Problem Statement:
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

You must write an algorithm that runs in `O(n)` time and without using the division operation.

---

### Examples:

**Example 1:**

Input:  
`nums = [1, 2, 3, 4, 5]`  

Explanation:  
The product of all elements except `nums[0]` (1) is `2 * 3 * 4 * 5 = 120`, and similarly for other indices.  
Output:  
`[120, 60, 40, 30, 24]`

**Example 2:**

Input:  
`nums = [-3, 3, 2, 0, -4]`  

Explanation:  
For index `i = 3`, the product of all elements except `nums[3]` (0) is `-3 * 3 * 2 * -4 = 72`.  
For other indices, the product results in `0` because of the presence of `0` in the array.  
Output:  
`[0, 0, 0, 72, 0]`

---

### Algorithmic Steps:

This problem is solved using the **prefix and postfix pattern**, which involves multiplying elements to the left and right of each index. The algorithmic approach is as follows:

1. **Initialize Result Array:**  
   Create an empty `result` array to store the product of elements at each index.

2. **Initialize Prefix and Postfix Variables:**  
   Set `prefix` and `postfix` to `1`. These variables will track the product of elements to the left and right of the current index, respectively.

3. **Calculate Prefix Products:**  
   - Iterate through the input array from left to right.
   - For each element, assign the current value of `prefix` to the corresponding index in `result`.
   - Update `prefix` by multiplying it with the current element.

4. **Calculate Postfix Products:**  
   - Iterate through the input array from right to left.
   - For each element, multiply the current value of `postfix` with the value already stored in `result`.
   - Update `postfix` by multiplying it with the current element.

5. **Return the Result:**  
   After both iterations, `result` will contain the product of all elements except the one at the current index.

---

### Edge Cases:

1. Empty array (`nums = []`): Return an empty array.
2. Single-element array (`nums = [a]`): Return `[1]` because there are no other elements.
3. Array with zeros (`nums = [0, a, b]`): Any index with a `0` will result in `0` for all other indices except where the product of the rest is non-zero.

---

### Time and Space Complexity:

- **Time Complexity:**  
  The algorithm runs in `O(n)` because it involves two separate traversals of the array.

- **Space Complexity:**  
  The algorithm uses `O(1)` additional space, as the `result` array is excluded from space complexity calculations (as per the problem statement).

---