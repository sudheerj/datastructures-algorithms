**Description:**
Given a string `str`,  return the number of substrings within`str` that are palindromes.

**Note:**A palindrome is a string that reads the same backward as forward.

### Examples
Example 1:
Input: str = "abcd"
Output: 4

Example 2:
Input: str = "aaa"
Output: 3


**Algorithmic Steps**
This problem is solved with the help of **Expand around center** approach. The algorithmic approach can be summarized as follows:

1. Write a preliminary check by just returning the input string length when its size is less than 2.

2. Initialize count(`count`) variable to 0, which is used to store the palindromic substrings count.

3. Iterate over the input string using an iteration variable `i`(from 0 to end of string).

4. For each iteration, calculate the total count of odd palindromic substrings using a separate common function(step6). This common function accepts current iteration variable `i` for both left and right pointer values.

5. For each iteration, calculate the total count of even palindromic substrings using a separate common function(step6). This common function accepts current iteration variable `i` as left and `i+1` as right pointer values.

6. The common function is created to iterate over the given string using starting(i.e, `left`) and ending(i.e, `right`) index arguments. The left pointer is going to be decremented and right pointer is going to be incremented whenever the respective character values are equal.

7. The sum of even and odd palindromic substring's count is going to be returned as total count for palindromic substrings.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n * 2)`(i.e, `O(n * 2) + O(n * 2)`) because finding both odd and event length palindrome takes `O(n) +O(n)` time complexity and it needs to be repeated on each character position which takes O(n). 

Also, it takes space complexity of `O(1)` without using any additional data structure.