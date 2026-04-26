## Zigzag Conversion

Given a string s and an integer numRows, arrange the characters in a zigzag pattern and return the string row by row.

### Examples

**Example 1**
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

**Example 2**
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"

**Example 3**
Input: s = "A", numRows = 1
Output: "A"

**Example 4**
Input: s = "AB", numRows = 1
Output: "AB"

**Example 5**
Input: s = "ABC", numRows = 2
Output: "ACB"

### Approach
- Use an array of StringBuilders for each row.
- Traverse the string, changing direction at the top and bottom rows.
- Time Complexity: O(n)
- Space Complexity: O(n)
