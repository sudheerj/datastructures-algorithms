## Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product as a string.

### Examples

**Example 1**
Input: num1 = "2", num2 = "3"
Output: "6"

**Example 2**
Input: num1 = "123", num2 = "456"
Output: "56088"

**Example 3**
Input: num1 = "0", num2 = "12345"
Output: "0"

**Example 4**
Input: num1 = "999", num2 = "999"
Output: "998001"

**Example 5**
Input: num1 = "123456789", num2 = "987654321"
Output: "121932631112635269"

### Approach
- Simulate multiplication as done by hand, storing intermediate results in an array.
- Time Complexity: O(m * n), where m and n are the lengths of num1 and num2.
- Space Complexity: O(m + n)
