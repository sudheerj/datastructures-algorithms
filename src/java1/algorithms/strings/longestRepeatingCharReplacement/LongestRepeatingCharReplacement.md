**Description:**
Given a string `str` and an integer `n`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `n` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

### Examples

Example 1:
Input: str = "AAABABBAA", n = 2
Output: 6

Example 2:
Input: str = "BBBB", n = 2
Output: 4

**Algorithmic Steps**
This problem is solved with the help of **sliding window** approach using two pointer variables. The algorithmic approach can be summarized as follows:

1. Initialize character count variable(i.e, `charCount`) to store the number of times a capital letter appears.

2. Initialize maximum length of the substring(`maxLength`), maximum character frequency(`maxCharFrequency`), left and right pointers(`left` & `right`) to 0.

3. Iterate over the input string using right pointer.

4. Calculate the maximum character freuency by taking the maximum between itself and character count of current character.

5. Create a nested loop to shrink(i.e, increasing left pointer) the substring's left boundary incase of repeatitive character found. This loop is executed until the difference between substring length and maximum character frequency is greater than given target.

6. For each nested iteration, the character count is decreased and left pointer incremented.

7. Calculate the maximum substring length by taking maximum between maximum itself and substring length.

8. Return `maxLength` to indicate the longest repeating character replacement substring.


**Time and Space complexity:**

This algorithm takes a time complexity of `O(n)`(`O(26 * n)`) because we are traversing the string only once. 
Also, the character count requires 26 letters to provide character frequency. i.e, It requires space complexity of `O(1)`(~`O(26)`).