# **Partition List**

## **Problem Statement**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

---

## **Examples**

### Example 1:
- **Input**: `head = [1,4,3,2,5,2], x = 3`
- **Output**: `[1,2,2,4,3,5]`

---

## **Algorithmic Approach**

1. Create two dummy nodes: one for nodes < x, one for nodes >= x.
2. Traverse original list, appending each node to appropriate list.
3. Connect the two lists.
4. Return head of first list.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  Only rearranging existing nodes.
