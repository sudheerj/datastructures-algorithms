# **Serialize and Deserialize Binary Tree**

## **Problem Statement**
Design an algorithm to serialize a binary tree to a string and deserialize the string back to a tree.

---

## **Examples**

### Example 1:
- **Input**: `root = [1,2,3,null,null,4,5]`
- **Serialized**: "1,2,null,null,3,4,null,null,5,null,null"
- **Deserialized**: Original tree

---

## **Algorithmic Approach (Preorder)**

### Serialize:
1. Preorder traversal.
2. Use "null" for null nodes.
3. Join with delimiter.

### Deserialize:
1. Split string by delimiter.
2. Preorder reconstruction:
   - Create node from current value.
   - Recursively build left, then right.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Visit each node once.

- **Space Complexity**: `O(n)`  
  String/list storage.
