**Description:**
Given a list of CPU `tasks` (each represented by a capital letter) and a non-negative integer `n` representing the cooldown interval, return the minimum number of CPU intervals required to finish all tasks. The CPU can process at most one task per interval, and the same task must wait at least `n` intervals before being executed again. The CPU may remain idle during a cooldown.

### Examples

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B = 8 intervals.

Example 2:
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: No cooldown needed; tasks can run back-to-back: A A A B B B = 6.

Example 3:
Input: tasks = ["A","A","A","B","B","B","C","C"], n = 2
Output: 8
Explanation: A -> B -> C -> A -> B -> C -> A -> B = 8 (no idle needed, enough variety).

Example 4:
Input: tasks = ["A","A","A","A","A"], n = 2
Output: 13
Explanation: A -> idle -> idle -> A -> idle -> idle -> A -> idle -> idle -> A -> idle -> idle -> A = 13.

Example 5:
Input: tasks = ["A","B","C","D","E","F"], n = 2
Output: 6
Explanation: All tasks are unique; no cooldown conflicts, so 6 intervals total.

Example 6:
Input: tasks = ["A","A","B","B"], n = 1
Output: 4
Explanation: A -> B -> A -> B = 4 (no idle needed).

Example 7:
Input: tasks = ["A","A","A","B"], n = 2
Output: 7
Explanation: A -> B -> idle -> A -> idle -> idle -> A = 7.

Example 8:
Input: tasks = ["A","A"], n = 3
Output: 5
Explanation: A -> idle -> idle -> idle -> A = 5.

Example 9:
Input: tasks = ["A"], n = 0
Output: 1
Explanation: Single task, 1 interval.

Example 10:
Input: tasks = ["A","A","A","B","B","C"], n = 2
Output: 7
Explanation: A -> B -> C -> A -> B -> idle -> A = 7.

**Algorithmic Steps**
This problem is solved using a **greedy + max-heap (Priority Queue)** approach. The algorithmic approach can be summarized as follows:

1. Count the frequency of each task using a frequency array of size 26.

2. Push all non-zero frequencies into a max-heap (priority queue with reverse order), so the most frequent task is always at the top.

3. Initialize `time` to 0.

4. While the heap is not empty, simulate one CPU cycle of length `n + 1`:
   a. Initialize an empty `temp` list to hold decremented frequencies.
   b. Process up to `n + 1` tasks from the heap (one per slot). For each task polled, decrement its frequency and add it back to `temp` if still > 0. Increment `time` for each task executed.
   c. Push all remaining tasks in `temp` back into the heap.
   d. If the heap is still not empty after the cycle, add the remaining idle slots (`cycle` counter) to `time`.

5. Return `time`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n * T)`, where `T` is the total number of tasks, since each task is pushed and popped from the heap. In practice it runs close to `O(T log 26)` ≈ `O(T)` since the heap size is bounded by 26 unique characters.

Also, it requires a space complexity of `O(1)` (or `O(26)`) for the frequency array and heap, which are bounded by the number of unique task types (at most 26).
