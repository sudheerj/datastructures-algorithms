**Problem statement:**
Given the `root` of a binary tree and an integer `targetSum`, return **all root-to-leaf paths** where the sum of the node values in the path equals `targetSum`. Each path should be returned as a list of the node values, not the nodes themselves.

A **leaf** is a node with no children.

## Examples:
Example1:

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]

```
        5
       / \
      4   8
     /   / \
    11  13   4
   / \      / \
  7   2    5   1
```

Explanation: There are two root-to-leaf paths with sum 22:
- 5 → 4 → 11 → 2 (sum = 22)
- 5 → 8 → 4 → 5 (sum = 22)

Example2:

Input: root = [1,2,3], targetSum = 5
Output: []

```
    1
   / \
  2   3
```

Explanation: There are two root-to-leaf paths: 1→2 (sum=3) and 1→3 (sum=4). Neither equals 5.

Example3:

Input: root = [1,2], targetSum = 0
Output: []

Explanation: No root-to-leaf path sums to 0.

**Algorithmic Steps**
This problem is solved using Depth First Search(DFS) with backtracking to explore all root-to-leaf paths and collect the ones matching the target sum. The algorithmic approach can be summarized as follows:

1. Initialize an empty result list `pathSumList` to store all valid paths.

2. Create a helper `dfs` recursive function that accepts the current node, a running cumulative sum (`currentSum`), the `targetSum`, a current path list (`currPath`), and the result list (`pathSumList`).

3. Add a base case: if the current node is `null`, return immediately. A null node cannot contribute to any path.

4. Add the current node's value to `currPath` and update `currentSum`.

5. If the current node is a **leaf** (both `left` and `right` children are `null`) and `currentSum` equals `targetSum`, add a **copy** of `currPath` to `pathSumList`.

6. Recursively call `dfs` on the left child and the right child to explore further.

7. **Backtrack** by removing the last element from `currPath` before returning. This ensures the path is correctly maintained when exploring other branches.

8. In the main function, invoke `dfs` with the root node, an initial `currentSum` of `0`, the given `targetSum`, an empty path list, and the result list.

9. Return `pathSumList`.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n²)`, where `n` is the number of nodes in the binary tree. Each node is visited once (`O(n)`), and copying a valid path to the result list takes `O(n)` in the worst case.

It requires a space complexity of `O(n)` due to the recursion call stack and the current path storage. In a completely skewed tree, the recursion depth and path length both equal `n`. For a balanced tree, the space complexity is `O(log n)` for the recursion stack.
