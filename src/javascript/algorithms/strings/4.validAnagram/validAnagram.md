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
This problem is solved with the help of **frequency counting** approach using an array. 

#### 1. Frequency Array (for lowercase a-z)

1. If the strings are not the same length, return `false`.
2. Create an array of size 26 to count letter frequencies.
3. For each character in both strings, increment for `str1` and decrement for `str2`.
4. If all counts are zero, the strings are anagrams.

Note:There are other approaches as well to validate anagrams

#### 2. Hash Map (for any characters)

1. If the strings are not the same length, return `false`.
2. Count the frequency of each character in `str1` using a map.
3. Decrement the count for each character in `str2`.
4. If any count goes negative or a character is missing, return `false`.
5. If the map is empty at the end, the strings are anagrams.

#### 3. Sort and Compare

1. If the strings are not the same length, return `false`.
2. Sort both strings and compare them.


**Time and Space complexity:**
This algorithm takes a time complexity of `O(n)`, where `n` represents length of the string. This is because we are traversing the string at most once. 

Also, it requires space complexity of `O(1)`(i.e, `O(26)`) due to no other data structure used except fixed 26 letter array for the character frequencies.

The complexity of all approaches can be summarized as below,

| Approach         | Time Complexity | Space Complexity |
|------------------|----------------|-----------------|
| Frequency Array  | O(n)           | O(1)            |
| Hash Map         | O(n)           | O(n)            |
| Sort & Compare   | O(n log n)     | O(n)            |