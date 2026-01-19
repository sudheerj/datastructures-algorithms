# **Rotate Image**

## **Problem Statement**
Rotate an n x n 2D matrix by 90 degrees clockwise in-place.

---

## **Examples**

### Example 1:
- **Input**: `[[1,2,3],[4,5,6],[7,8,9]]`
- **Output**: `[[7,4,1],[8,5,2],[9,6,3]]`

---

## **Algorithmic Approach**

### Transpose + Reverse:
1. Transpose the matrix (swap matrix[i][j] with matrix[j][i]).
2. Reverse each row.

### Layer by Layer:
1. Rotate matrix layer by layer from outside to inside.
2. For each layer, rotate 4 elements at a time.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n²)`  
  Visit each element once.

- **Space Complexity**: `O(1)`  
  In-place rotation.
