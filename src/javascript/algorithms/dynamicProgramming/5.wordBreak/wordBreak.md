**Description:**
Given a string `str` and a dictionary of strings `wordDict`, determine if `str` can be segmented into a space-separated sequence of one or more dictionary words. Each word in the dictionary can be reused any number of times.

**Note:** A word from the dictionary can be used multiple times if required.

**Edge Cases:**
- Empty string: should return `true` (an empty string can be segmented trivially).
- Empty dictionary: should return `false` unless the string is also empty.
- String cannot be segmented: e.g., `str = "catsandog"`, `wordDict = ["cats","dog","sand","and","cat"]`.
- String can be segmented in multiple ways: e.g., `str = "applepenapple"`, `wordDict = ["apple", "pen"]`.

#### Examples

**Example 1:**
```
Input: str = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: "applepenapple" can be segmented as "apple pen apple".
```

**Example 2:**
```
Input: str = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
Explanation: The string cannot be segmented.
```

**Example 3 (Edge):**
```
Input: str = "", wordDict = ["a"]
Output: true
```

**Example 4 (Edge):**
```
Input: str = "a", wordDict = []
Output: false
```

#### Algorithm steps
This problem is efficiently solved using bottom-up dynamic programming approach by avoiding the recomputations of same subproblems.

1. Create a boolean array `dp` of size `str.length + 1`, where `dp[i]` means `str[i:]` can be segmented. Initialize all to `false` except `dp[str.length] = true` (empty string is always segmentable).
2. Iterate `i` from `str.length - 1` down to `0`:
    - For each word in `wordDict`, check if `str` starts with that word at position `i`.
    - If it does, and `dp[i + word.length]` is `true`, set `dp[i] = true` and break.
3. Return `dp[0]`.

**Time Complexity:** `O(n * m * k)` where `n` is the string length, `m` is the number of words, and `k` is the average word length.
**Space Complexity:** `O(n)`. We will use an array data structure to store true/false value for each index position. Hence, the space complexity will be `O(n)`.
