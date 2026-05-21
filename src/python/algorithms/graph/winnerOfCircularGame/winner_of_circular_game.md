**Problem statement:**
There are `n` friends standing in a circle numbered `1` to `n`. Starting from friend `1`, every `k`-th friend is eliminated from the circle. The process continues until only one friend remains. Return the number of that last remaining friend (the winner).

## Examples:
Example 1:

Input: n = 5, k = 2
Output: 3
Explanation: Elimination order: 2 → 4 → 1 → 5. The last remaining friend is 3.

Example 2:

Input: n = 6, k = 5
Output: 1
Explanation: Elimination order: 5 → 4 → 6 → 2 → 3. The last remaining friend is 1.

Example 3:

Input: n = 1, k = 1
Output: 1
Explanation: Only one friend — trivially the winner.

Example 4:

Input: n = 4, k = 1
Output: 4
Explanation: Every 1st friend is eliminated: 1 → 2 → 3. The last remaining friend is 4.

Example 5:

Input: n = 3, k = 3
Output: 2
Explanation: Elimination order: 3 → 1. The last remaining friend is 2.

## Approaches

### 1. Queue Simulation (winner_of_circular_game1) — TC: O(n * k), SC: O(n)

1. Add friends `1` to `n` into a `deque` in order.

2. While the deque has more than one element:
   - Move the first `k-1` elements from the front to the back (skip them).
   - Remove (eliminate) the next element at the front — the `k`-th friend.

3. When only one element remains, return it as the winner.

### 2. Iterative Josephus (winner_of_circular_game2) — TC: O(n), SC: O(1)

1. Use 0-based indexing throughout. The base case for `n=1` is position `0`.

2. For each circle size from `2` to `n`, compute the winner's 0-based index using the recurrence:
   `winner = (winner + k) % i`

3. After the loop, convert to 1-based by returning `winner + 1`.

### 3. Recursive Josephus (winner_of_circular_game3) — TC: O(n), SC: O(n)

1. Define a helper `_josephus(n, k)` that returns the 0-based index of the winner for `n` people.

2. Base case: `_josephus(1, k) = 0` (only one person, index 0).

3. Recursive case: `_josephus(n, k) = (_josephus(n-1, k) + k) % n`
   — after removing the `k`-th person from a circle of `n`, the problem reduces to a circle of `n-1` with a shifted starting position.

4. Add `1` to the final result to convert to 1-based indexing.

**Time and Space complexity:**
- Queue simulation: Time `O(n * k)`, Space `O(n)`
- Iterative Josephus: Time `O(n)`, Space `O(1)`
- Recursive Josephus: Time `O(n)`, Space `O(n)` (call stack)
