**Problem statement:**
You are given a string `s` and an integer `k`. A **k duplicate removal** consists of choosing `k` adjacent and equal letters from `s` and removing them, causing the left and the right parts of the string to concatenate. Repeat this process until no more k-adjacent duplicates exist. Return the final string after all such removals. It is guaranteed that the answer is unique.

## Examples:

```
Input: s = "abcd", k = 2
Output: "abcd"

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
```

## Approach 1: Stack with (char, count) Pairs

**Algorithmic Steps**
1. Use a stack of `(char, count)` pairs to track consecutive character runs.
2. For each character `ch` in the string:
   - If the stack is non-empty and the top's character matches `ch`, increment the top's count.
     - If the count reaches `k`, pop the pair (the group is eliminated).
   - Otherwise, push a new pair `(ch, 1)`.
3. After processing all characters, reconstruct the result string by expanding each `(ch, count)` pair in the stack.
4. Return the reconstructed string.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(n)  |
