**Problem statement:**
Given the `root` of a binary tree, return the length of the **diameter** of the tree.

The diameter is defined as the length of the longest path between any two nodes in the tree. The path is measured in number of **edges**, and it may or may not pass through the root.

## Examples:
Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: Longest path is 4→2→1→3 or 5→2→1→3 (3 edges).

Example 2:

Input: root = [1,2]
Output: 1
Explanation: Only one edge exists.

Example 3:

Input: root = [1]
Output: 0
Explanation: Single node, no edges.

Example 4:

Input: root = [1,null,2,null,3,null,4] (right-skewed)
Output: 3
Explanation: Only one path exists: 1→2→3→4 (3 edges).

Example 5:

Input: root = [1,2,null,3,4,5,null,null,null,6]
Output: 4
Explanation: Longest path is 5→3→2→4→6 (4 edges). Diameter does NOT pass through root.

**Algorithmic Steps**
This problem is solved using **post-order DFS** (left → right → node). The algorithmic approach can be summarized as follows:

1. Maintain a `diameter` variable initialized to `0`, captured via closure in the inner `dfs` function.

2. Define a recursive `dfs(node)` function that returns the **height** of the subtree rooted at `node`.

3. Base case: return `0` if `node` is `null`.

4. Recursively compute `leftHeight = dfs(node.left)` and `rightHeight = dfs(node.right)`.

5. Update `diameter = max(diameter, leftHeight + rightHeight)` — the widest path through this node spans both subtrees.

6. Return `1 + max(leftHeight, rightHeight)` as this node's height to its parent.

7. After `dfs(root)` completes, return `diameter`.

## Test Examples

| # | Input (level-order) | Expected | Notes |
|---|---------------------|----------|-------|
| 1 | `[1,2,3,4,5]` | `3` | Diameter through root |
| 2 | `[1,2]` | `1` | Single edge |
| 3 | `[1]` | `0` | Single node |
| 4 | `[1,null,2,null,3,null,4]` | `3` | Right-skewed |
| 5 | `[1,2,null,3,4,5,null,null,null,6]` | `4` | Diameter NOT through root |

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes — each node is visited exactly once via DFS.

It requires a space complexity of `O(h)`, where `h` is the height of the tree (recursive call stack). For a balanced tree `h = O(log n)`; for a skewed tree `h = O(n)`.
