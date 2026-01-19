# **Find Kth Node From End**

## **Problem Statement**
Find the kth node from the end of a linked list.

---

## **Examples**

### Example 1:
- **Input**: `list = [1,2,3,4,5], k = 2`
- **Output**: Node 4

---

## **Algorithmic Approach (Two Pointers)**

1. Move first pointer k steps ahead.
2. Move both pointers until first reaches end.
3. Second pointer is now at kth from end.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through the list.

- **Space Complexity**: `O(1)`  
  Only two pointers used.
