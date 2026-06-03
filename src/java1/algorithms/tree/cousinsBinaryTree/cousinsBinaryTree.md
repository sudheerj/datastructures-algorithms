**Problem statement:** Given the root of a binary tree and two node values `x` and `y`, return `true` if the nodes with values `x` and `y` are **cousins**. Two nodes are cousins if they are at the same depth but have **different parents**.

LeetCode #993

### Examples

```
Input:  root = [1,2,3,4], x = 4, y = 3
Output: false
Explanation: Node 4 (depth 2) and node 3 (depth 1) are at different depths.
```

```
Input:  root = [1,2,3,null,4,null,5], x = 4, y = 5
Output: true
Explanation: Both at depth 2 but parents are 2 and 3 respectively → cousins.
```

```
Input:  root = [1,2,3], x = 2, y = 3
Output: false
Explanation: Both are children of node 1 → siblings, not cousins.
```

**Algorithmic Steps — Approach 1: BFS**

1. Level-order traverse the tree.
2. At each level, track whether `x` and `y` are found (`foundX`, `foundY`).
3. For each node, if it has two children whose values are `x` and `y`, return `false` (siblings).
4. After processing the level, if both are found → return `true`; if only one → return `false`.

**Algorithmic Steps — Approach 2: DFS**

1. Recursively search for `x` and `y`, recording each node's depth and parent.
2. Return `true` if `depth(x) == depth(y)` and `parent(x) != parent(y)`.

| Complexity  | BFS    | DFS    |
|-------------|--------|--------|
| Time        | O(n)   | O(n)   |
| Space       | O(n)   | O(h)   |
