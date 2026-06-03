**Problem statement:**
Given an array of strings `source` representing lines of source code, remove all comments and return the remaining non-empty lines.

Two types of comments exist:
- **Line comment** `//` — everything from `//` to the end of that line is a comment.
- **Block comment** `/* ... */` — everything between `/*` and `*/` is a comment; it can span multiple lines.

A string `//` or `/*` inside a block comment is **not** treated as a new comment. Block comments do not nest.

## Examples

**Example 1:**
```
Input:  ["int x = 1; // this is a comment", "int y = 2;"]
Output: ["int x = 1; ", "int y = 2;"]
```

**Example 2:**
```
Input:  ["/* Test program */", "int main()", "{",
         "  // variable declaration", "int a, b, c;",
         "/* This is a test", "   multiline  ", "   comment for",
         "   testing */", "int d = b + c;", "}"]
Output: ["int main()", "{", "int a, b, c;", "int d = b + c;", "}"]
```
Explanation: Block comment spans three lines; multiline block and line comment both removed.

**Example 3:**
```
Input:  ["a/*comment*/b", "c"]
Output: ["ab", "c"]
```
Explanation: Inline block comment removed; adjacent code fragments joined.

**Example 4:**
```
Input:  ["// full line comment", "code line"]
Output: ["code line"]
```
Explanation: Full-line comment produces an empty line, which is excluded.

**Example 5:**
```
Input:  ["int a = 1;", "int b = 2;"]
Output: ["int a = 1;", "int b = 2;"]
```
Explanation: No comments — source unchanged.

**Example 6:**
```
Input:  ["before/*skip*/after"]
Output: ["beforeafter"]
```
Explanation: Block comment opens and closes on the same line; surrounding code is kept.

## Approach: Line-by-line scan with block flag

**Algorithmic Steps**
1. Keep a `boolean isBlock` flag and a `StringBuilder sb` for the current output line.
2. For each source line:
   - If **not** starting in a block, reset `sb`.
   - Scan character by character:
     - If `!isBlock`:
       - `//` → break (discard rest of line).
       - `/*` → set `isBlock = true`, skip 2 chars.
       - Otherwise → append the character to `sb`, advance `i`.
     - If `isBlock`:
       - `*/` → set `isBlock = false`, skip 2 chars.
       - Otherwise → skip the character (`i++`).
   - After the line: if `!isBlock` and `sb` is non-empty, add `sb` to result.
3. Return result.

**Time and Space complexity:**

| Complexity | Value    |
|------------|----------|
| Time       | O(n · L) |
| Space      | O(n · L) |

> n = number of lines, L = average line length.
