# **Validate Binary Search Tree**

## **Problem Statement**
Determine if a binary tree is a valid BST.

---

## **Examples**

### Example 1:
- **Input**: `root = [2,1,3]`
- **Output**: `true`

### Example 2:
- **Input**: `root = [5,1,4,null,null,3,6]`
- **Output**: `false` (3 is in right subtree of 5 but less than 5)

---

## **Algorithmic Approach**

### Recursive with Range:
1. Track valid range (min, max) for each node.
2. Root can be any value.
3. Left child: max becomes parent value.
4. Right child: min becomes parent value.
5. If value outside range: invalid.

### Inorder Traversal:
1. BST inorder produces sorted sequence.
2. Check if each value is greater than previous.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(h)`  
  Recursion depth.
