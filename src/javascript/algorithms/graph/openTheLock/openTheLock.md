**Problem statement:**
You have a lock with 4 circular wheels, each with digits `0–9`. The lock starts at `"0000"`. You are given a list of `deadends` — combinations that will lock the mechanism permanently — and a `target` combination. Each turn you can rotate any single wheel one step forward or backward. Return the **minimum number of turns** to reach `target`, or `-1` if it is impossible.

## Examples:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
(Path: 0000 → 0100 → 0200 → 0201 → 0202, avoiding deadends via detour = 6 turns)

Input: deadends = ["8888"], target = "0009"
Output: 1
(Rotate last wheel backward: 0000 → 0009, one turn)

Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
(All neighbours of 8888 are deadends — unreachable)

**Algorithmic Steps**
This problem is solved using **BFS level-by-level** to find the shortest path (minimum turns) from `"0000"` to `target`. The algorithmic approach can be summarized as follows:

1. Create the main function `openTheLock(deadends, target)`.

2. Build a `dead` Set from `deadends` for O(1) lookup.

3. If `dead.has("0000")`, return immediately (cannot start).

4. Initialize a BFS queue with `"0000"`, a `visited` Set containing `"0000"`, and `steps = 0`.

5. While the queue is not empty:
   1. Record `size = queue.length`.
   2. For each node in the level, shift `current`. If `current === target`, return `steps`.
   3. Split `current` into an array `arr`. For each of the 4 wheel positions `j`:
      - Save `original = arr[j]`.
      - Try both directions (`+1` and `-1`): compute `next_digit = (parseInt(original) + move + 10) % 10`.
      - If `arr.join("")` is not in `dead` and not in `visited`, push to queue and add to visited.
      - Restore `arr[j] = original`.
   4. `steps++` after processing the full level.

6. Return `-1` if the queue empties without finding `target`.

**Time and Space complexity:**
The total number of lock states is `10^4 = 10000`. For each state we try `4 wheels × 2 directions = 8` neighbors.

Time complexity: `O(10^4 × 4 × 2)` = effectively `O(1)` for this fixed-size problem, or `O(D + N)` where `D = |deadends|` and `N = 10000`.

Space complexity: `O(10^4)` for the visited Set and BFS queue.
