**Description:**
Given the starting position X, target position Y, and fixed jump distance D, compute the minimal number of jumps required for a frog to reach or pass position Y from X.

### Examples
Example 1:

Input: X = 10, Y = 85, D = 30
Output: 3

**Algorithmic Steps**
This problem is solved using simple arithmetic:

1. Calculate the distance to be covered as Y - X.
2. Divide the distance by D and round up to the nearest integer (using Math.ceil).
3. Return the result as the minimal number of jumps.

**Time and Space complexity:**
- Time complexity: `O(1)`.
- Space complexity: `O(1)`. 