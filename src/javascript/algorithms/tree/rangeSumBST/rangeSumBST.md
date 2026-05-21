**Problem statement:**
Given the `root` of a Binary Search Tree and two integers `low` and `high`, return the sum of values of all nodes with a value in the **inclusive** range `[low, high]`.

## Examples:
Example 1:

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes with values in [7,15] are 7, 10, 15. Sum = 7 + 10 + 15 = 32.

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes with values in [6,10] are 6, 7, 10. Sum = 6 + 7 + 10 = 23.

Example 3:

Input: root = [5], low = 1, high = 10
Output: 5
Explanation: Single node 5 is within range.

Example 4:

Input: root = [5], low = 6, high = 10
Output: 0
Explanation: Single node 5 is outside range.

Example 5:

Input: root = [10,5,15], low = 1, high = 20
Output: 30
Explanation: All nodes (5, 10, 15) are within range.

**Algorithmic Steps**
This problem is solved using **recursive DFS**, leveraging BST properties to prune unnecessary branches. The algorithmic approach can be summarized as follows:

1. Base case: return `0` if `root` is `null`.

2. If `root.value > high`, the current value and its entire right subtree are too large — recurse only into the **left subtree**.

3. If `root.value < low`, the current value and its entire left subtree are too small — recurse only into the **right subtree**.

4. Otherwise, `root.value` is within `[low, high]` — add `root.value` to the sum and recurse into **both** subtrees.

5. Return the accumulated sum.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)` in the worst case (all nodes in range), where `n` is the number of nodes. BST pruning reduces average-case visits significantly.

It requires a space complexity of `O(n)` for the recursive call stack in the worst case (skewed tree). For a balanced tree it is `O(log n)`.
