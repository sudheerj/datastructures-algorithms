**Problem statement:**
Given the `head` of a singly linked list and determine if there is a cycle in the linked list or not. 

There is a cycle in a linked list if at least one node in the list that can be visited again by following the `next` pointer. Internally, `index` is used to denote the index of the node where tail's next pointer is connected to. If `index` is equal -1, the tail points to `null` and no cycle exists.

**Note:** The `index` is not passed as a parameter to determine the cycle exists or not.


## Examples:
Example 1:

Input: head = [1,2,3,4,5,6], index = -1
Output: false

Example 2:

Input: head = [1,2,3,4,5,6], index = 0
Output: true

Example 3: 

Input: head = [1,2,3,4,5,6], index = 4
Output: true

**Algorithmic Steps**
This problem is solved with help of Floyd's cycle-finding algorithm or Tortoise and Hare algorithm. It uses two pointers(one fast pointer with two steps at a time and one slow pointer with one step at a time). If there is no cycle, the fast pointer will reach the end of the list. Otherwise, the fast pointer will meet the slow pointer due to cyclic traversal. The algorithmic approach can be summarized as follows: 

1. Declare both slow(i.e `slow`) and fast(i.e, `fast`) pointers pointing to head node.

2. Iterate over the linked list until fast pointer and it's next node are not equal to null.

3. Update the slow pointer one step and fast pointer two steps.

4. Return `true` if both slow and fast pointers are equal at any position. i.e, It indicates cycle exists.

5. Return `false` after the iteration, indicating that there is no detection of cycle in the linkedlist.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes in a linkedlist. This is because we are traversing the list at most once. 

Here, we don't use any additional datastructure other than two pointers. Hence, the space complexity will be `O(1)`.
