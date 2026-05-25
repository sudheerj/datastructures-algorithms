**Problem statement:**
Given an `m x n` binary matrix, you can choose any column and flip every cell in that column (0 becomes 1 and 1 becomes 0). Return the maximum number of rows that have all values equal after performing some number of flips.

## Examples:

**Example 1:**
Input: matrix = [[0,1],[1,1]]
Output: 1

**Example 2:**
Input: matrix = [[0,1],[1,0]]
Output: 2

**Example 3:**
Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
Output: 2

**Algorithmic Steps**

**Approach 1: Normalize rows with hashing — O(m·n) time, O(m·n) space**
1. For each row, compute a normalized key:
   - If the row starts with `1`, logically flip every bit (`1-bit`); otherwise keep as-is.
   - This ensures a row and its complement map to the same key.
2. Store the frequency of each normalized key in a HashMap.
3. Return the maximum frequency value from the map.

**Key Insight:** After any sequence of column flips, a row becomes all-equal only if it or its bitwise complement matches the chosen flip pattern. Two rows can simultaneously become all-equal if and only if they are identical or bitwise complements of each other. Normalizing to a canonical form (always start with 0) groups these pairs together.

**Time and Space complexity:**

| Approach | Time | Space |
|---|---|---|
| Normalize + HashMap | O(m·n) | O(m·n) |
