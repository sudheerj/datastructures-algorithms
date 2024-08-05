**Description:**
Given a string `str`, return true if it is a palindrome, or false otherwise.
 
**Note:**A palindrome is a string that reads the same backward as forward. If the characters includes non-alphanumerical letters, they needs to be removed and uppercase letters should be converted in a lowercase format.

### Examples
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: s = "Hello World"
Output: false

Example 3:
Input: s = " "
Output: true

**Algorithmic Steps**
This problem is solved with the help of **two pointer** approach by traversing over the input string. The algorithmic approach can be summarized as follows:

1. Add a preliminary check by returning `true` if the length of the string is less than or equal to 1.

2. Initialize left and right pointers to starting and ending index of a string.

3. Iterate over an input string until left pointer not crossed right pointer position.

4. Find the characters at each index position of left and right.

5. If the left character is not an alphanumeric letter, increment the left pointer. Whereas if the right character is not an alphanumeric letter, decrement the right pointer.

6. If both the characters are valid alphanumeric letters, compare both characters by converting them into lowercase. If they are not equal, just return as `false` indicating that not a palindrome. Otherwise shrink the window by incrementing left pointer and decrementing right pointer.

7. After the end of iteration, return `true` saying it as a palindrome.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` because we are traversing the string only once. 
Also, it doesn't requires any additional data structure. So the space complexity is `O(1)`.