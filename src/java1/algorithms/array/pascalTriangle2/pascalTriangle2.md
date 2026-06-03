**Problem statement:** Given an integer `rowIndex`, return the `rowIndex`th (0-indexed) row of Pascal's triangle using only O(k) extra space.

### Examples

```
Input: rowIndex = 3
Output: [1, 3, 3, 1]

Input: rowIndex = 0
Output: [1]

Input: rowIndex = 4
Output: [1, 4, 6, 4, 1]
```

**Algorithmic Steps — Approach 1: Copy from Previous Row**

1. Start with `row = [1]`.
2. For each index `i` from 1 to `rowIndex`:
   - Build a new list `next` starting with `1`.
   - For each middle position `j` from 1 to `i-1`, append `row[j-1] + row[j]`.
   - Append `1` at the end.
   - Replace `row` with `next`.
3. Return `row`.

**Algorithmic Steps — Approach 2: In-Place Right-to-Left**

1. Initialize `row` with `rowIndex + 1` ones.
2. For each row index `i` from 2 to `rowIndex`:
   - Iterate `j` from `i-1` down to `1` (right to left to avoid overwriting needed values).
   - Set `row[j] = row[j-1] + row[j]`.
3. Return `row`.

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Copy from previous row | O(k²) | O(k) |
| In-place right-to-left | O(k²) | O(k) |
