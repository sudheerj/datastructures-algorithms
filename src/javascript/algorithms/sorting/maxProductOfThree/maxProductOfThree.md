**Description:**
Given an array of integers, find the maximal product of any triplet.

### Examples
Example 1:

Input: numbers = [-3, 1, 2, -2, 5, 6]
Output: 60

Example 2:

Input: numbers = [-5, -6, -4, -7, -10]
Output: -120

**Algorithmic Steps**
This problem is solved by sorting the array and considering the product of the three largest numbers or the product of the two smallest and the largest number:

1. Sort the array in non-decreasing order.
2. Compute the product of the last three numbers.
3. Compute the product of the first two numbers and the last number.
4. Return the maximum of the two products.

**Time and Space complexity:**
- Time complexity: `O(n log n)`, where `n` is the number of elements (due to sorting).
- Space complexity: `O(1)`. 