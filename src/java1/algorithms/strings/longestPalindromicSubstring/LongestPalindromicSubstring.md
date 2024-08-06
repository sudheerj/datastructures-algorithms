**Description:**
Given a string `str`, return the longest palindromic substring of `str`.

**Note:**A palindrome is a string that reads the same backward as forward. If the characters includes non-alphanumerical letters, they needs to be removed and uppercase letters should be converted in a lowercase format. If there are multiple palindromic substrings that have the same length, return any one of them.

### Examples
Example 1:
Input: str = "ababd"
Output: "aba"

Example 2:
Input: str = "dbbc"
Output: "bb"

**Algorithmic Steps**
This problem is solved with the help of **expanding around center** approach where we expand the input string at each position. The algorithmic approach can be summarized as follows:

1. Add a preliminary check by returning `str` if the length of the string is less than or equal to 1.

2. Initialize longest palindromic substring(`maxPalindromicSubstr`) to first character of given string.

3. Iterate over an input string until the end of string.

4. Create a method(`expandAroundCenter`) to expand the string from center for each character position. This function iterates over the string based on left and right pointers. The left pointer will be decremented and right pointer will be incremented when the characters are equals from both the ends and also both pointers exists with in the range of string boundaries.

5. Invoke the method created in the previous step to find both odd(`left = right = i`) and even(`left = i`, `right = i+1`) longest palindromes.

6. Update the longest palindrome by comparing the current longest palindrome with odd and even palindromes. 

7. Repeat steps 4-6 until all the characters traversed within given input string.

8. Return longest palindromic substring(`maxPalindromicSubstr`) from the main function.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n*2)` because expanding a palindrome around its center could take `O(n)` and it needs to repeated for each character(i.e, `n` times). 

Also, it doesn't requires any additional data structure. So the space complexity is `O(1)`.