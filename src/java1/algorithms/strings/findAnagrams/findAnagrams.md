**Problem statement:** Given two strings `s` and `p`, return an array of all the start indices of `p`'s anagrams in `s`. You may return the answer in any order.

### Examples
```
Input: s = "cbaebabacd", p = "abc"
Output: [0, 6]
Explanation: "cba" at index 0 and "bac" at index 6 are anagrams of "abc"
```
```
Input: s = "abab", p = "ab"
Output: [0, 1, 2]
Explanation: "ab" at index 0, "ba" at index 1, "ab" at index 2 are all anagrams of "ab"
```
```
Input: s = "af", p = "be"
Output: []
```

**Algorithmic Steps (Sliding Window — Frequency Counting)**
1. Return empty list immediately if `s` is shorter than `p`.
2. Create two frequency arrays of size 26: `pCount` for `p`, and `sCount` for the first window of `s` (first `p.length()` characters).
3. Populate both arrays by iterating over `p` and the first window of `s` simultaneously.
4. If the two frequency arrays are equal, add index `0` to the result.
5. Slide the window from index `p.length()` to `s.length() - 1`:
   - Increment the count for the new character entering the window (`s[i]`).
   - Decrement the count for the character leaving the window (`s[i - p.length()]`).
   - If the two frequency arrays are equal, add `i - p.length() + 1` to the result.
6. Return the result list.

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |

> n = length of `s`. Initial window build is O(m) where m = length of `p`; sliding is O(n − m). Both frequency arrays are fixed size 26 → O(1) space.
