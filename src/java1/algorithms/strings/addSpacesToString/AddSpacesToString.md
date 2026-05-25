**Problem statement:**
You are given a 0-indexed string `s` and a 0-indexed integer array `spaces` that describes the indices in the original string where spaces will be added. Each space should be inserted **before** the character at the given index. Return the modified string after all spaces have been added.

## Examples:

```
Input: s = "LeetcodeHelpsMeLearn", spaces = [8, 13, 15]
Output: "Leetcode Helps Me Learn"

Input: s = "icodeinpython", spaces = [1, 6, 8]
Output: "i code in python"

Input: s = "spacing", spaces = []
Output: "spacing"

Input: s = "ab", spaces = [1]
Output: "a b"

Input: s = "hello", spaces = [1, 2, 3, 4]
Output: "h e l l o"
```

## Approach 1: Two Pointers

**Algorithmic Steps**
1. Use pointer `j` into the `spaces` array and iterate `i` over every character of `s`.
2. Before appending `s[i]`, check if `j < spaces.length` and `i == spaces[j]`; if so, append a space and advance `j`.
3. Append the current character.
4. Return the built string.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(n)  |

## Approach 2: Brute Force (String Rebuild)

**Algorithmic Steps**
1. Keep a `shift` counter to account for how much the string has grown after each insertion.
2. For each index in `spaces`, compute the adjusted insertion position as `space + shift`, insert a `" "` at that position using `substring` concatenation, and increment `shift`.
3. Return the resulting string.

**Time and Space complexity:**

| Complexity | Value  |
|------------|--------|
| Time       | O(n·k) |
| Space      | O(n)   |
