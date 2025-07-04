**Description:**
Given an array `nums` of `n` integers, find the minimal absolute difference between the sum of the first part and the second part when the array is split at any index `P`, where `1 ≤ P < n`.

### Examples
Example 1:

Input: nums = [3, 1, 2, 4, 3]
Output: 1

Example 2:

Input: nums = [5, 6, 2, 4, 1]
Output: 4

Example 3:

Input: nums = [1, 2]
Output: 1

**Algorithmic Steps**
This problem is solved by iterating through the array and maintaining running sums:

1. Compute the total sum of the array.
2. Initialize `leftSum` to 0 and `minDiff` to infinity.
3. Iterate through the array (except the last element):
   - Add the current element to `leftSum`.
   - Compute `rightSum` as `totalSum - leftSum`.
   - Calculate the absolute difference between `leftSum` and `rightSum`.
   - Update `minDiff` if the current difference is smaller.
4. Return `minDiff` after the loop.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of elements in the array.
- Space complexity: `O(1)`.