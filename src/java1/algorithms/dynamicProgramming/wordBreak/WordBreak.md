**Description:**
Given a string `str` and a dictionary of strings `wordDict`,  determine if the string `str` can be split into a sequence of one or more words that exist in the dictionary.

**Note:** A word from the dictionary can be used multiple times if required.

## Examples:
Example 1:

Input: str1 = 'applepenapple', wordDict1 = ["pen", "apple"]
Output: true

Example 2: 

Input: str2 = "catsandog", wordDict2 = ["cats","dog","sand","and","cat"]
Output: false

**Algorithmic Steps(Approach 1&2)**
This problem is solved efficiently using **bottom-up dynamic programming** approach by avoiding the recomputations of same subproblems. The algorithmic approach can be summarized as follows: 

1. Create an array(`dp`) with the size of `length+1`, where `length` is the number of characters in a string. This array is used to hold true/false values based on a condition that dictionary words exists in a sentence or not at a particular position. By default, all values are initialized to `false`.
   
2. The main intution of this algorithm is based on bottom up dynamic programming. So the given string is traversed in a reversed order.
   
3. The last element of an array points to out of bounds position in a string. This position is considered as a base case by initializing its value to `true` because empty string always exist in the dictionary.
      
4. Iterate given string(`str`) element from last character to first using an index variable(`i`).

5. For each iteration of step4, verify the existance of each word from dictionary in the given string. i.e, Run another loop to iterate the words from dictionary.

6. If the below two conditions satisfied, update the `dp` value of respective index position(`i`) with preivously calculated word value(`dp[i+word.length]`).
    1. Sum of index variable(`i`) and word length is less than string's length, 
    2. And the substring of a given string exists in dictionary 

7. If the array value at index position `i` is `true`(i.e, there is a word exists in the dictionary), just break from the current iteration to continue with next word.

8. Repeat steps 5-7 until the end of given string.
   
9. Return boolean value at first index position `dp[0]`, which indicates whether all the split words exists in the dictionary or not.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n^2 * m)`, where `n` is the number of characters in a string and `m` is the number of words with in a dictionary. This is because for each character we are comparing the word exists in a string. 

Here, we will use an array datastructure to store true/false value for each index position. Hence, the space complexity will be `O(n)`.
