**Problem statement:**
Given the `root` of a binary tree, return the **zigzag level order traversal** of its nodes' values as a nested list. Each level alternates direction: left-to-right for odd levels (1st, 3rd, ...) and right-to-left for even levels (2nd, 4th, ...).

## Examples:
Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [[1],[3,2],[4,5,6,7]]
Explanation: Level 1 left→right: [1]. Level 2 right→left: [3,2]. Level 3 left→right: [4,5,6,7].

Example 2:

Input: root = [3]
Output: [[3]]

Example 3:

Input: root = []
Output: []

Example 4:

Input: root = [1,2,null,null,3]
Output: [[1],[2],[3]]
Explanation: Single child each level; direction still alternates but only one node per level.

Example 5:

Input: root = [1,2,3,4,null,null,5,6,7]
Output: [[1],[3,2],[4,5],[7,6]]

**Algorithmic Steps**
This problem is solved using **BFS** with a fixed-size array to place nodes at the correct index per level. The algorithmic approach can be summarized as follows:

1. Return an empty list if `root` is `null`.

2. Initialize a queue with the root node and an empty `result` list.

3. While the queue is not empty:
   a. Record the current level size `n = queue.size()`.
   b. Allocate an `Integer[]` array of size `n`.
   c. For each of the `n` nodes dequeued:
      - Compute the insert index: if `result.size()` is even (left→right), use `i`; if odd (right→left), use `n - i - 1`.
      - Place the node's value at that index.
      - Enqueue non-null left and right children.
   d. Add the filled array (as a list) to `result`.

4. Return `result`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes — each node is enqueued and dequeued exactly once.

It requires a space complexity of `O(n)` for the queue (which holds at most one full level, up to `n/2` nodes at the widest level).
