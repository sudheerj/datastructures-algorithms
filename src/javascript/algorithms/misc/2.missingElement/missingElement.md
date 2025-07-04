**Description:**
Given an array containing n distinct numbers taken from the range 1 to n+1, find the missing number.

### Examples
Example 1:

Input: nums = [2, 3, 1, 5]
Output: 4

Example 2:

Input: nums = [1, 2, 3, 4, 6]
Output: 5

Example 3:

Input: nums = []
Output: 1

**Algorithmic Steps**
This problem is solved using the sum formula for the first n natural numbers:

1. Calculate the expected sum for numbers from 1 to n+1 using the formula `(n+1)*(n+2)/2`.
2. Calculate the actual sum of the elements in the array.
3. The missing number is the difference between the expected sum and the actual sum.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the length of the array.
- Space complexity: `O(1)`. 