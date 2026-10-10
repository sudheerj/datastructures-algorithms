**Description:**
Given an array of words, return the length of the longest possible word chain. A word can follow another word in the chain if it is formed by inserting exactly one letter anywhere into the predecessor word. The words in a chain do not need to appear in any particular order in the input.

### Examples

Example 1:

Input: `words = ["a", "b", "ba", "bca", "bda", "bdca"]`
Output: `4`
Explanation: One longest chain is `"a" -> "ba" -> "bca" -> "bdca"`.

Example 2:

Input: `words = ["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]`
Output: `5`
Explanation: One longest chain is `"xb" -> "xbc" -> "cxbc" -> "pcxbc" -> "pcxbcf"`.

Example 3:

Input: `words = ["abcd", "dbqca"]`
Output: `1`
Explanation: Neither word is a predecessor of the other, so the longest chain contains one word.

**Algorithmic Steps**
The solution uses dynamic programming with a hash map, processing words in ascending order of length.

1. Sort the words by length so each possible predecessor is processed before the word that follows it.
2. For each word, remove each character in turn to generate all possible predecessor strings.
3. Look up each predecessor in the DP map. The best chain ending at the current word is one plus the longest chain ending at any predecessor; if none exists, it is `1`.
4. Store the computed chain length for the word and update the maximum chain length.
5. Return the maximum chain length. For an empty input array, return `0`.

**Time and Space complexity:**
Let `n` be the number of words and `L` be the maximum word length. Sorting takes `O(n log n)`. Generating and checking all predecessor strings takes `O(n * L^2)` time in the worst case, due to string construction and hashing.

The space complexity is `O(n * L)` for the DP map and its stored word keys.

**Java Implementation:** [LongestStringChain.java](./LongestStringChain.java)
