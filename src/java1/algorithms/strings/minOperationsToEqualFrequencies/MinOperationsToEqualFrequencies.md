**Problem statement:** Given a string `s` consisting of lowercase English letters, return the minimum number of operations to make all character frequencies equal. In one operation, you can delete one character from `s`. After all deletions, every character that still appears in `s` must have the same frequency.

## Examples:
```
Input: s = "abc"
Output: 0
Explanation: a, b, c each appear once — already equal.

Input: s = "aab"
Output: 1
Explanation: Delete one 'a' → "ab", both appear once.

Input: s = "aabbc"
Output: 1
Explanation: Delete 'c' → "aabb", a and b each appear twice.

Input: s = "aaabbc"
Output: 2
Explanation: Target freq=2: delete 1 'a' (3→2) + delete all 'c' (1→0) = 2 ops → "aaabb" wait, "aabb" with b=2, a=2.

Input: s = "aaabbbccc"
Output: 0
Explanation: a, b, c each appear 3 times — already equal.
```

## Approach 1: Frequency Counting + Try All Target Frequencies

**Algorithmic Steps**
1. Count the frequency of each of the 26 characters in the string.
2. Find the maximum frequency `max` across all characters.
3. Try every candidate target frequency `t` from `1` to `max`.
4. For each target `t`, compute total operations:
   - If `freq > t`: delete `freq - t` characters (reduce to target).
   - If `0 < freq < t`: cannot increase frequency, so delete all `freq` characters.
   - If `freq == t`: 0 operations needed.
5. Track the minimum total operations across all targets and return it.

**Time and Space complexity:**

| | Complexity |
|---|---|
| Time | O(n) |
| Space | O(1) |
