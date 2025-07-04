**Description:**
Given two integers `firstNumber` and `secondNumber` and a divisor, count the number of integers within the range [firstNumber, secondNumber] that are divisible by the divisor.

### Examples
Example 1:

Input: firstNumber = 6, secondNumber = 11, divisor = 2
Output: 3

Example 2:

Input: firstNumber = 0, secondNumber = 0, divisor = 11
Output: 1

Example 3:

Input: firstNumber = 10, secondNumber = 10, divisor = 5
Output: 1

Example 4:

Input: firstNumber = 10, secondNumber = 10, divisor = 7
Output: 0

**Algorithmic Steps**
This problem is solved using simple arithmetic:

1. Compute the number of divisible numbers up to `secondNumber` by dividing it by the divisor and taking the floor.
2. Compute the number of divisible numbers before `firstNumber` by dividing (`firstNumber` - 1) by the divisor and taking the floor.
3. Subtract the two results to get the count of divisible numbers in the range.

**Time and Space complexity:**
- Time complexity: `O(1)`.
- Space complexity: `O(1)`.
