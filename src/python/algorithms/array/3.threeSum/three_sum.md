**Description:**
Given an array of integers, return an array of triplets (in any order) such that `i != j != k` and `nums[i] + nums[j] + nums[k] = 0`. 

Note that the solution set must not include duplicate triplets (i.e., [1, 0, 0] and [0, 1, 0] are duplicative).

## Examples:
Example 1  
Input: `[-1, 0, 1, 2, -1, -4]`  
Output: `[[-1, -1, 2], [-1, 0, 1]]`  

Example 2  
Input: `[1, 4, 5, 1]`  
Output: `[]`  

Example 3  
Input: `[0, 0, 0]`  
Output: `[[0, 0, 0]]`  

---

## **Algorithmic Steps**

The problem is solved using the **two-pointer technique** after sorting the array. Below are the detailed steps:

1. **Sort the Array:**
   - Sort the input array in ascending order. This simplifies the process of finding triplets.

2. **Iterate Over the Array:**
   - Loop through the array using an index `i` from `0` to `length - 2`.

3. **Skip Duplicates for `i`:**
   - To avoid duplicate triplets, skip the iteration if the current element is the same as the previous one.

4. **Two-Pointer Technique:**
   - Initialize two pointers: `left` at `i + 1` and `right` at `length - 1`.

5. **Calculate the Sum:**
   - Compute the sum of `nums[i] + nums[left] + nums[right]`.

6. **Check Conditions:**
   - If the sum is less than zero, increment the `left` pointer.
   - If the sum is greater than zero, decrement the `right` pointer.
   - If the sum equals zero:
     - Add the triplet `[nums[i], nums[left], nums[right]]` to the result list.
     - Move both pointers to the next unique numbers to avoid duplicates.

7. **Repeat:**
   - Continue this process until `left` is no longer less than `right`.

8. **Return Results:**
   - Return the list of unique triplets.

---

## **Time and Space Complexity**

- **Time Complexity:**  
  - Sorting the array takes **O(n log n)**.  
  - The two-pointer technique involves a nested loop, resulting in **O(n²)**.  
  - Overall, the time complexity is **O(n²)**.

- **Space Complexity:**  
  - The space complexity is **O(1)** excluding the output array, as we only use a few pointer variables.
