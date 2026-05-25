**Problem statement:**
Given a string `s`, return the last substring of `s` in lexicographical order. A substring is any contiguous sequence of characters within `s`. Because appending more characters can only increase or maintain lexicographic order, the answer is always one of the suffixes of `s`.

## Examples:

```
Input: s = "abab"
Output: "bab"

Input: s = "leetcode"
Output: "tcode"

Input: s = "cacacb"
Output: "cb"

Input: s = "zz"
Output: "zz"

Input: s = "abcde"
Output: "e"
```

## Approach 1: Two-Pointer String Comparison

**Algorithmic Steps**
1. Initialize `i = 0` (current best suffix start), `j = 1` (challenger suffix start), `k = 0` (offset into current comparison).
2. While `j + k < n`, compare characters at `i + k` and `j + k`:
   - **Equal**: increment `k` and continue comparing further characters.
   - **Challenger wins** (`s[i+k] < s[j+k]`): advance `i` to `max(i + k + 1, j)`, reset `j = i + 1` and `k = 0`.
   - **Current wins** (`s[i+k] > s[j+k]`): advance `j` to `j + k + 1` and reset `k = 0`.
3. Return `s.substring(i)` — the best suffix found.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |
