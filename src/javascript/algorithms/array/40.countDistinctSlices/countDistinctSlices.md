**Description:**
Given an array of integers and an integer M, count the number of distinct slices (contiguous subarrays with all unique elements) in the array. If the result exceeds 1,000,000,000, return 1,000,000,000.

### Examples
Example 1:

Input: m = 6, numbers = [3, 4, 5, 5, 2]
Output: 9

Example 2:

Input: m = 5, numbers = [1, 2, 3, 4]
Output: 10

Example 3:

Input: m = 2, numbers = [1, 1, 1, 1]
Output: 4

Example 4:

Input: m = 3, numbers = [0, 1, 0, 2, 0]
Output: 10

**Algorithmic Steps**
This problem is solved using a sliding window and a boolean array to track seen elements:

1. Initialize a boolean array of size M+1 to track seen elements.
2. Use two pointers, left and right, to define the window.
3. Expand the window by moving right, marking elements as seen.
4. If a duplicate is found, move left to shrink the window until the duplicate is removed.
5. For each step, add the window size to the total count.
6. If the count exceeds 1,000,000,000, return 1,000,000,000.
7. Return the total count.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of elements in the array.
- Space complexity: `O(M)` for the boolean array. 