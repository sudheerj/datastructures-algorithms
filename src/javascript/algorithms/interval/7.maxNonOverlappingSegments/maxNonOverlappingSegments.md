**Description:**
Given two arrays A and B representing N segments [A[K], B[K]], find the maximal number of non-overlapping segments.

### Examples
Example 1:

Input: A = [1, 3, 7, 9, 9], B = [5, 6, 8, 9, 10]
Output: 3

**Algorithmic Steps**
This problem is solved using a greedy approach:

1. Initialize a variable to track the end of the last added segment.
2. Iterate through the segments:
   - If the start of the current segment is after the end of the last added segment, add it to the count and update the end.
3. Return the count of non-overlapping segments.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of segments.
- Space complexity: `O(1)`. 