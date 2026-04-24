## Search Matrix

Given an m x n matrix where each row is sorted and the first integer of each row is greater than the last integer of the previous row, write an algorithm to search for a target value.

### Examples

**Example 1**
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

**Example 2**
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

**Example 3**
Input: matrix = [[1,2,3,4,5]], target = 4
Output: true

**Example 4**
Input: matrix = [[1],[3],[5]], target = 5
Output: true

**Example 5**
Input: matrix = [[7]], target = 7
Output: true

**Example 6**
Input: matrix = [[7]], target = 2
Output: false

**Example 7**
Input: matrix = [], target = 1
Output: false

### Approach
- Treat the matrix as a 1D sorted array and use binary search.
- Time Complexity: O(log(m*n))
- Space Complexity: O(1)
