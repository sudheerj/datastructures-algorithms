**Problem statement:**
A school wants to take a photo of all students lined up in non-decreasing order by height. Given the current ordering `heights`, return the number of indices where `heights[i]` does not match the expected sorted position.

### Examples

Example 1:
```
Input:  heights = [1, 1, 4, 2, 1, 3]
Output: 3
```
Explanation: Expected order = [1,1,1,2,3,4]. Indices 2, 4, 5 do not match.

Example 2:
```
Input:  heights = [5, 1, 2, 3, 4]
Output: 5
```
Explanation: Expected order = [1,2,3,4,5]. All 5 positions differ.

Example 3:
```
Input:  heights = [1, 2, 3, 4, 5]
Output: 0
```
Explanation: Already sorted — no mismatches.

Example 4:
```
Input:  heights = [2, 1, 2, 1, 1, 2, 2, 1]
Output: 4
```
Explanation: Expected order = [1,1,1,1,2,2,2,2]. Indices 0, 2, 4, 7 differ.

Example 5:
```
Input:  heights = [1]
Output: 0
```
Explanation: Single student always matches.

Example 6:
```
Input:  heights = [3, 3, 3, 3]
Output: 0
```
Explanation: All heights equal — sorted order is identical.

**Algorithmic Steps**

This problem is solved using **frequency counting** (counting sort). The algorithmic approach can be summarised as follows:

1. Create a frequency array `count[101]` (heights are in range 1–100).
2. Iterate through `heights` and increment `count[height]` for each student.
3. Use a pointer `currentHeight = 1` to walk through valid heights in sorted order.
4. For each index `i` in `heights`:
   - Advance `currentHeight` while `count[currentHeight] == 0`.
   - If `heights[i] != currentHeight`, increment `mismatches`.
   - Decrement `count[currentHeight]`.
5. Return `mismatches`.

**Time and Space complexity:**

| Complexity | Value |
|------------|-------|
| Time       | O(n)  |
| Space      | O(1)  |

> Heights are bounded to [1, 100], so the frequency array is constant size — O(1) space.
