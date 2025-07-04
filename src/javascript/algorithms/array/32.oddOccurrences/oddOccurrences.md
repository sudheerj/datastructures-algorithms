**Description:**
Given an array of integers, find the element that occurs an odd number of times. It is guaranteed that exactly one such element exists. Return that element.

**Note:** The array may contain both positive and negative integers.

### Examples
Example 1:

Input: nums = [9, 3, 9, 3, 9, 7, 9]
Output: 7

Example 2:

Input: nums = [1, 1, 2]
Output: 2

Example 3:

Input: nums = [4]
Output: 4

Example 4:

Input: nums = [5, 5, 5]
Output: 5

**Algorithmic Steps**
This problem can be solved optimally using the XOR operation, or with a frequency map. The XOR approach is summarized as follows:

1. Initialize a variable `result` to 0.
2. Iterate through the array, XOR-ing each element with `result`.
3. After the loop, `result` will hold the element that occurs an odd number of times.

Alternative approaches include using an object or set to track frequencies, but the XOR method is optimal for time and space.

**Time and Space complexity:**
- Time complexity: `O(n)`, where `n` is the number of elements in the array.
- Space complexity: `O(1)` for the XOR approach, `O(n)` for the frequency map approach.

