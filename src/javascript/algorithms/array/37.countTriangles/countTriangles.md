**Description:**
Given an array of integers, count the number of triplets that can form a triangle. A triplet (P, Q, R) forms a triangle if the sum of any two sides is greater than the third side.

### Examples
Example 1:

Input: numbers = [10, 2, 5, 1, 8, 12]
Output: 4

Example 2:

Input: numbers = [4, 6, 3, 7]
Output: 3

Example 3:

Input: numbers = [1, 1, 1, 1]
Output: 4

Example 4:

Input: numbers = [5, 10, 12, 15]
Output: 3

Example 5:

Input: numbers = [1, 2, 3]
Output: 0

**Algorithmic Steps**
This problem is solved by sorting the array and using a two-pointer approach:

1. Sort the array in non-decreasing order.
2. For each index i from 0 to n-3:
   - Set k = i + 2.
   - For each index j from i+1 to n-2:
     - While k < n and numbers[i] + numbers[j] > numbers[k], increment k.
     - Add (k - j - 1) to the count.
3. Return the total count.

**Time and Space complexity:**
- Time complexity: `O(n^2)`, where `n` is the number of elements in the array.
- Space complexity: `O(1)` (excluding input storage). 