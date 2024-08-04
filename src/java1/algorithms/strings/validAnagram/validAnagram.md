**Description:**
Given two strings `str1` and `str2`, return `true` if `str2` is an anagram of `str1`, and `false` otherwise.

**Note:**An Anagram is defined as a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

### Examples
Example 1:
Input: str1 = "anagram", str2 = "nagaram"
Output: true

Example 2:
Input: str1 = "rat", str2 = "cat"
Output: false

**Algorithmic Steps**
This problem is solved with the help of **frequency counting** approach using an array. The algorithmic approach can be summarized as follows:

1. Add a preliminary check whether both string lengths are equal or not. If they are not equal, return `false` because they cannot be anagrams anymore.

2. Create an array named `charcharFrequencyArr` to hold the alphabetic(i.e, a-z) letter frequencies. By default, their count is initialized with 0.

3. Iterate any of the input string to find the unicode of each character.

4. Find the unicode for each index in both the strings.

5. Calculate the index position of frequency array by substring the letter's ASCII value from unicode. Increment the frequency for first string and decrement the frequency for second string to balance the frequencies.

6. Repeat steps 4-5 until there are no more characters in the string.

7. Return `true` if every element's frequency is zero. Otherwise return `false` indicating that those two strings are not anagrams.

**Time and Space complexity:**
This algorithm takes a time complexity of `O(n)`, where `n` represents length of the string. This is because we are traversing the string at most once. 

Also, it requires space complexity of `O(1)`(i.e, `O(26)`) due to no other data structure used except fixed 26 letter array for the character frequencies.