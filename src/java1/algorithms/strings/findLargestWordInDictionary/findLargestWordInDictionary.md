**Problem statement:** Given a string `s` and a string array `dictionary`, return the longest string in `dictionary` that can be formed by deleting some characters of `s` without reordering the remaining characters. If there are more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

### Examples
```
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Explanation: "apple" is a subsequence of s and is the longest match.
```
```
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "b"
Explanation: All three are subsequences of length 1; "b" is lexicographically smallest.
```
```
Input: s = "z", dictionary = ["a","b"]
Output: ""
Explanation: Neither word is a subsequence of s.
```

**Algorithmic Steps**
1. Initialize `largestWord = ""`.
2. For each `word` in `dictionary`, check if `word` is a subsequence of `s` using a two-pointer scan:
   - Use pointer `left` over `s` and `right` over `word`.
   - Advance `right` whenever `s[left] == word[right]`; always advance `left`.
   - `word` is a subsequence if `right == word.length()` at the end.
3. If `word` is a subsequence, update `largestWord` when:
   - `word` is longer than `largestWord`, **or**
   - Same length but lexicographically smaller.
4. Return `largestWord`.

| Complexity | Value        |
|------------|--------------|
| Time       | O(n × m)     |
| Space      | O(1)         |

> n = number of words in dictionary, m = length of s. Each subsequence check is O(m).
