**Description:**
Given an input string `str` which consists of words and spaces, Return the length of last word in the string.

**Note:** The word is considered as a maximal substring with non-space characters.

### Examples
Example 1:
Input: "Welcome to DSA"
Output: 3

Example 2:
Input: " My pet is fluffy  "
Output: 6

**Algorithmic Steps**
This problem is solved with the help of string traversal. The algorithmic approach can be summarized as follows:

1. Define the last index(i.e,`i`) of the given string and initialize length of last word(i.e, `length`) to 0.

2. Trim the ending spaces to find the last non-space character's index. This can be done through iteration from the end of a string.
   
3. Find the length of last word by iterating the string until the space character is found.

4. Return length of last word as an output.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` where `n` is the length of given string. This is because we may need to iterate entire string incase of single word string(worst case scenario).

Also, it takes constant( `O(1)`) space complexity because of no additional variables required other than length output variable.