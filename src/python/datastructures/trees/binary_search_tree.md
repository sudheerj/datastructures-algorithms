# Binary Search Tree

A Binary Search Tree (BST) is a binary tree where each node has at most two children, and for each node:
- All values in the left subtree are less than the node's value
- All values in the right subtree are greater than the node's value

## Operations

| Operation      | Average Case | Worst Case | Description |
|----------------|--------------|------------|-------------|
| insert         | O(log n)    | O(n)       | Insert a new value |
| lookup/search  | O(log n)    | O(n)       | Search for a value |
| min_value_node | O(log n)    | O(n)       | Find minimum value |
| max_value_node | O(log n)    | O(n)       | Find maximum value |
| BFS            | O(n)        | O(n)       | Breadth-First Search |
| DFS            | O(n)        | O(n)       | Depth-First Search |

## Traversal Methods

### Breadth-First Search (BFS)
Visits all nodes level by level.

### Depth-First Search (DFS)
- **Pre-Order**: Root → Left → Right
- **In-Order**: Left → Root → Right (gives sorted order)
- **Post-Order**: Left → Right → Root

## Usage

```python
from binary_search_tree import BinarySearchTree

bst = BinarySearchTree()
bst.insert(10)
bst.insert(5)
bst.insert(15)
print(bst.bfs())         # [10, 5, 15]
print(bst.dfs_in_order()) # [5, 10, 15]
```
