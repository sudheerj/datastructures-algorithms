**Description:**
Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

**Note:** An anagram is a word or phrase formed by rearranging the letters of another, using all the original letters exactly once.

## Examples

**Example 1:**  
Input: `s = "anagram", t = "nagaram"`  
Output: `True`

**Example 2:**  
Input: `s = "rat", t = "car"`  
Output: `False`

## Approaches

### 1. Character Count Array
In this approach, a fixed-size array of 26 integers is used to track character frequencies. Increment the count for each character in `s` and decrement for each character in `t`. If all counts are zero at the end, the strings are anagrams. The algorithmic approach can be summarized as follows:

1. If lengths of `s` and `t` differ, return `False`.
2. Initialize a count array of size 26 (for lowercase a-z).
3. Iterate through both strings simultaneously — increment for `s[i]`, decrement for `t[i]`.
4. If all values in the count array are zero, return `True`.

### 2. Counter (Hash Map)
In this approach, Python's `Counter` is used to build frequency maps for both strings and compare them directly. The algorithmic approach can be summarized as follows:

1. Build a `Counter` for `s` and a `Counter` for `t`.
2. Compare the two counters — if equal, the strings are anagrams.

### 3. Sorting
In this approach, both strings are sorted and compared. If the sorted versions are identical, the strings are anagrams. The algorithmic approach can be summarized as follows:

1. Sort both strings alphabetically.
2. Compare the sorted strings — if equal, the strings are anagrams.

## Complexity

The algorithm in the first approach takes a time complexity of `O(n)`, where `n` represents the length of the strings. This is because we traverse each string once using a single pass.
Also, it requires space complexity of `O(1)` since the count array has a fixed size of 26.

| Approach         | Time Complexity | Space Complexity |
| ---------------- | --------------- | ---------------- |
| Char Count Array | O(n)            | O(1)             |
| Counter          | O(n)            | O(1)             |
| Sorting          | O(n log n)      | O(n)             |

- `n` = length of the input strings
