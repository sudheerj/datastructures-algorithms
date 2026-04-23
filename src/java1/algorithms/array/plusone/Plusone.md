## Plus One

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer. The digits are stored such that the most significant digit is at the head of the list.

### Examples

**Example 1**
Input: [1, 2, 3]
Output: [1, 2, 4]

**Example 2**
Input: [1, 2, 9]
Output: [1, 3, 0]

**Example 3**
Input: [9, 9, 9]
Output: [1, 0, 0, 0]

**Example 4**
Input: [5]
Output: [6]

**Example 5**
Input: [9]
Output: [10]

**Example 6**
Input: [0, 0, 1]
Output: [0, 0, 2]

**Example 7**
Input: []
Output: [1]

### Approach
- Traverse the array from the end.
- If a digit is less than 9, increment and return.
- If a digit is 9, set to 0 and continue.
- If all digits are 9, create a new array with 1 at the front.

### Complexity
- Time: O(n)
- Space: O(n)
