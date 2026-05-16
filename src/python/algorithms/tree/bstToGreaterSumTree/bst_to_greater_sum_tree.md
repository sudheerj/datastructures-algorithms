**Problem statement:**
Given the `root` of a Binary Search Tree (BST), convert it into a **Greater Sum Tree** where every node's value is replaced by the sum of all node values **greater than or equal to** that node's original value in the BST.

## Examples:
Example 1:

Input: root = [4,1,6,0,2,5,7]
Output: [22,25,13,25,24,18,7]
Explanation: Inorder values [0,1,2,4,5,6,7]. Each node becomes sum of itself + all greater nodes:
- 7 → 7, 6 → 13, 5 → 18, 4 → 22, 2 → 24, 1 → 25, 0 → 25

Example 2:

Input: root = [2,1,3]
Output: [5,6,3]
Explanation: 3→3, 2→5 (2+3), 1→6 (1+2+3)

Example 3:

Input: root = [5]
Output: [5]
Explanation: Single node; no values greater than 5.

Example 4:

Input: root = [3,2,4,1]
Output: [7,9,4,10]
Explanation: 4→4, 3→7 (3+4), 2→9 (2+3+4), 1→10 (1+2+3+4)

Example 5:

Input: root = [1,null,2,null,3] (right-skewed)
Output: [6,null,5,null,3]
Explanation: 3→3, 2→5, 1→6

**Algorithmic Steps**
This problem is solved using **Reverse Inorder DFS** (right → root → left). The algorithmic approach can be summarized as follows:

1. Maintain a `total` variable initialized to `0`, captured via `nonlocal` in the inner `dfs` function.

2. Traverse the tree in **reverse inorder** (right subtree first, then current node, then left subtree). This visits nodes in descending order of their values.

3. At each node, add the node's value to `total`, then set the node's value to `total`.

4. Continue until all nodes are visited and return the modified root.

## Test Examples

| #   | Input BST (level-order) | Output GST (inorder)          | Notes           |
| --- | ----------------------- | ----------------------------- | --------------- |
| 1   | `[4,1,6,0,2,5,7]`       | `[25, 25, 24, 22, 18, 13, 7]` | Full 7-node BST |
| 2   | `[2,1,3]`               | `[6, 5, 3]`                   | Simple 3-node   |
| 3   | `[5]`                   | `[5]`                         | Single node     |
| 4   | `[3,2,4,1]`             | `[10, 9, 7, 4]`               | Left-heavy      |
| 5   | `[1,null,2,null,3]`     | `[6, 5, 3]`                   | Right-skewed    |

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes — every node is visited exactly once.

It requires a space complexity of `O(h)`, where `h` is the height of the tree (recursive call stack). For a balanced BST `h = O(log n)`; for a skewed tree `h = O(n)`.
