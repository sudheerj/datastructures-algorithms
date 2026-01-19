# **Reorder List**

## **Problem Statement**
Reorder list from L0 → L1 → ... → Ln-1 → Ln to L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...

---

## **Examples**

### Example 1:
- **Input**: `[1,2,3,4]`
- **Output**: `[1,4,2,3]`

### Example 2:
- **Input**: `[1,2,3,4,5]`
- **Output**: `[1,5,2,4,3]`

---

## **Algorithmic Approach**

1. **Find middle**: Use slow/fast pointers.
2. **Reverse second half**: Standard reversal.
3. **Merge alternately**: Interleave nodes from both halves.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Three passes: find middle, reverse, merge.

- **Space Complexity**: `O(1)`  
  In-place modification.
