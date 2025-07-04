**Description:**
Given an array of integers, check if it is a permutation of the first `n` positive integers (i.e., contains all numbers from 1 to n exactly once). Return 1 if it is a permutation, otherwise return 0.

**Note:** The array may contain duplicates or numbers outside the range 1 to n.

### Examples
Example 1:

Input: nums = [4, 1, 3, 2]
Output: 1

Example 2:

Input: nums = [4, 1, 3]
Output: 0

Example 3:

Input: nums = [1, 2, 2, 3]
Output: 0

Example 4:

Input: nums = [1]
Output: 1

Example 5:

Input: nums = [2, 1, 4, 3, 5]
Output: 1

**Algorithmic Steps**
This problem can be solved using a set or boolean array to track seen numbers:

1. Initialize a set or boolean array of size n.
2. Iterate through the array:
   - If the number is out of range or already seen, return 0.
   - Mark the number as seen.
3. If all numbers from 1 to n are seen exactly once, return 1.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of elements in the array.
- Space complexity: `O(n)`.

