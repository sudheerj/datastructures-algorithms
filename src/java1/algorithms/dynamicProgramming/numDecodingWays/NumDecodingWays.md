**Description:**
given a string `str` that consists only of digits. The string can be decoded into a set of alphabet letters where '1' can be indicated as 'A', '2' as 'B', ... , '26' as 'Z'. Calculate the number of different ways the given digit string can be decoded into alphabets.

## Examples:
Example 1:

Input: str1 = "221"
Output: 3

Example 2: 

Input: str2 = "09"
Output: 0

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **Dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

   
1. Add base case conditions for empty and one digit strings. If either length of the string or first character is zero(`str.length === 0 || str[0] === '0'`), return zero as number of possible ways to decode. In case there is only one character(`str.length === 1`), return the one possible way as output.
   
2. Initialize two variables(`prevCount1` and `prevCount2`) which represent number of ways to decode single character and two character digits to 1. This is because there will be only way to decode empty string and one character digit.
   
3. Iterate over each digit starting from second character to end of the string using index variable `i`.

4. For each iteration, calculate the single digit and two digit characters for each character.
   
5. Create a temporary variable(`count=0`) to store the number of possible ways for each digit.

6. If the single digit is greater than or equal to 1, update the `count` value by adding single digit possible ways(i.e, `prevCount1`).
   
7. If the double digit is between 10 and 26, update the `count` value by adding two digit possible ways(i.e, `prevCount2`).
      
8. Move `prevCount1` to `prevCount2` and update `prevCount2` to latest `count` value to proceed with next character.

9.   Repeat steps 4-8 until all digits traversed.

10. Return `prevCount2` which holds the total possible ways to decode the given string. 


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of digits in the given string. This is because we need to traverse each character at most once to find the possible ways to decode. 

Here, we are not using any additonal datastructure other than two variables to store number of ways. Hence, the space complexity will be `O(1)`.
