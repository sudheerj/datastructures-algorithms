**Description:**
Given an array of integers, find the number of equi leaders. An equi leader is an index where the same leader occurs in both the left and right parts of the array. A leader is a value that occurs in more than half of the elements of a segment.

### Examples
Example 1:

Input: nums = [4, 3, 4, 4, 4, 2]
Output: 2

Example 2:

Input: nums = [1, 2, 1, 1, 2, 1]
Output: 2

Example 3:

Input: nums = [1, 2, 3, 4, 5]
Output: 0

Example 4:

Input: nums = [7, 7, 7, 7, 7]
Output: 4

Example 5:

Input: nums = [0, 0, 1, 0, 2, 0, 0]
Output: 3

**Algorithmic Steps**
This problem is solved using the concept of leader and prefix sums:

1. Find the leader candidate using the Boyer-Moore majority vote algorithm.
2. Count the total occurrences of the leader candidate.
3. If the candidate is not a leader (does not occur in more than half the array), return 0.
4. Iterate through the array, maintaining a count of the leader in the left part.
5. For each index, check if the leader is a leader in both left and right parts. If so, increment the equi leader count.
6. Return the total number of equi leaders.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of elements in the array.
- Space complexity: `O(1)` (excluding input storage). 