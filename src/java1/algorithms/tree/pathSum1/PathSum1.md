**Problem statement:**
Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a **root-to-leaf** path such that adding up all the values along the path equals `targetSum`.

A **leaf** is a node with no children.

## Examples:
Example1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true

```
        5
       / \
      4   8
     /   / \
    11  13   4
   / \        \
  7   2        1
```

Explanation: The root-to-leaf path with the target sum is 5 -> 4 -> 11 -> 2 (sum = 22).

Example2:

Input: root = [1,2,3], targetSum = 5
Output: false

```
    1
   / \
  2   3
```

Explanation: There are two root-to-leaf paths: 1->2 (sum=3) and 1->3 (sum=4). Neither equals 5.

Example3:

Input: root = [], targetSum = 0
Output: false

Explanation: Since the tree is empty, there are no root-to-leaf paths.

**Algorithmic Steps**
This problem is solved using Depth First Search(DFS) with recursion to traverse root-to-leaf paths and track the cumulative sum. The algorithmic approach can be summarized as follows:

1. Create a helper `dfs` recursive function that accepts the current node, the running cumulative sum (`currSum`), and the `targetSum`.

2. Add a base case: if the current node is `null`, return `false`. A null node cannot contribute to any path.

3. Add the current node's value to `currSum`.

4. If the current node is a **leaf** (both `left` and `right` children are `null`), check whether `currSum` equals `targetSum`. If so, return `true`.

5. Recursively call `dfs` on the left child and the right child. If **either** recursive call returns `true`, the overall result is `true`.

6. In the main function, invoke `dfs` with the root node, an initial `currSum` of `0`, and the given `targetSum`.

7. Return the result of the `dfs` call.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes in the binary tree. Each node is visited exactly once during the DFS traversal.

It requires a space complexity of `O(n)` in the worst case due to the recursion call stack. In a completely skewed tree (each node has only one child), the recursion depth equals `n`. For a balanced tree, the space complexity is `O(log n)`.
