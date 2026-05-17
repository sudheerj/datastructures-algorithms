# Sorted Array to Binary Search Tree (BST)

Given an integer array where the elements are sorted in ascending order, convert it to a height-balanced binary search tree (BST).

A height-balanced BST is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than 1.

## Approach
- Use divide and conquer (DFS):
  - Pick the middle element as the root.
  - Recursively build left and right subtrees from the left and right halves of the array.
- Time Complexity: O(n)
- Space Complexity: O(log n) for recursion stack, O(n) for output tree.

## Example

Input: [ -10, -3, 0, 5, 9 ]

Possible Output (one valid BST):

```
     0
    / \
 -10   5
   \     \
   -3     9
```

## Test Cases

| Input                | Output (BST preorder traversal) |
|----------------------|---------------------------------|
| [0]                  | 0                               |
| [1,2]                | 1 2 or 2 1                      |
| [-10,-3,0,5,9]       | 0 -10 -3 5 9 (or any valid BST) |
| []                   | (empty tree)                    |

## Java, Python, JavaScript Implementations
- See respective folders for code and test examples.
