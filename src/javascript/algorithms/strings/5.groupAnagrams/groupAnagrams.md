**Description:**
Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

**Note:** An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.

## Examples

**Example 1:**  
Input: `strs = ["eat","tea","tan","ate","nat","bat"]`  
Output: `[["bat"],["nat","tan"],["ate","eat","tea"]]`

**Example 2:**  
Input: `strs = ["hello"]`  
Output: `[["hello"]]`

**Example 3:**  
Input: `strs = [""]`  
Output: `[[""]]`

## Approaches

### 1. Character Frequency Array
In this approach, the problem is solved with the combination of **frequency counting** approach using an array and store anagrams in an object/map. The algorithmic approach can be summarized as follows:

1. Initialize an empty map or object to store groups of anagrams.
2. For each string, create a character frequency array (size 26 for lowercase a-z).
3. Use the frequency array (joined as a string) as a unique key.
4. Add the string to the group corresponding to this key.
5. Return all grouped anagrams as an array of arrays.

### 2. Sorted String as Key
In this approach, the problem is solved with the combination of **sorting string as key** and store anagrams in an object/map. The algorithmic approach can be summarized as follows:

1. Initialize an empty map or object to store groups of anagrams.
2. For each string, sort its characters alphabetically.
3. Use the sorted string as a unique key.
4. Add the string to the group corresponding to this key.
5. Return all grouped anagrams as an array of arrays.


## Complexity

The algorithm in first approach takes a time complexity of `O(m * n)`, where `m` represents the number of strings and `n` represents length of each string. This is because we are traversing each string in the given list of strings.
Also, it requires space complexity of `O(m * n)` due to object/map data structure which store list of an arrays.

| Approach         | Time Complexity | Space Complexity |
| ---------------- | --------------- | ---------------- |
| Char Count Array | O(m * n)        | O(m * n)         |
| Sort & Compare   | O(m * n log n)  | O(m * n)         |

- `m` = number of strings in the input array
- `n` = average length of each string