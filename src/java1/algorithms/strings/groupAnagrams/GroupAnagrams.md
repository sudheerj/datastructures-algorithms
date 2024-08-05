**Description:**
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

**Note:**An Anagram is defined as a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

### Examples
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = ["hello"]
Output: [["hello"]]

Example 3:
Input: strs = [""]
Output: [[""]]

**Algorithmic Steps**
This problem is solved with the combination of **frequency counting** approach using an array and store anagrams in a map. The algorithmic approach can be summarized as follows:

1. Initialize an empty object(`groupAnagramMap`) to store list of anagrams.

2. Iterate over the list of given input strings array to find anagrams.

3. Create a character frequency array(`charsCount`) with respect to 26 letters of alphabetics. Each value is assigned with zero by default.

4. Iterate over the each character/letter of a string and update the character frequency.

5. Calculate a unique hash key with the combination of the character frequency and prefix symbol.

6. If the key already exists in the anagram object, append the new anagram to the list. Otherwise create a new anagram array for the given key.

7. Repeat steps 3-6 until there are no strings available.

8. Return group of anagrams in an array format.

**Time and Space complexity:**
This algorithm takes a time complexity of `O(m * n)`, where `m` represents the number of strings and `n` represents length of each string. This is because we are traversing each string in the given list of strings. 

Also, it requires space complexity of `O(m * n)` due to object/map data structure which store list of an arrays.