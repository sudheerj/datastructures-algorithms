**Problem statement:**
Given a doubly linked list, swap every two adjacent nodes and return the modified list. 

**Note:** The problem needs to be solved without modifying the values in the list's nodes (i.e., only the pointers needs to be updated).

## Examples:
Example1:

Input: [1,2,3,4,5,6]
Output: [2,1,4,3,6,5]

Example2:

Input: [1,2,3,4,5]
Output: [2,1,4,3,5]]

**Algorithmic Steps**
This problem is solved with the help of traversing the list and updating the pointers between nodes. The algorithmic approach can be summarized as follows: 

1. Add an edge case returing immediately if the length of the list is less than 2.

2. Store the head and it's next nodes in `current` and `newHead` respectively.

3. Iterate over the list until the current and its next nodes are not equal to null.

4. Find the first next node `firstNext`(i.e,next to current node), second next node `secondNext`(current node's next next node) and previous node `prev`(previous node of current node) based on each iteration.
   
5. If the previous node is not equal to null, update the next pointer of previous node to firstNext. After that, the next pointer of firstNext to current node, and the next pointer of current to secondNext.

6. In the same way, if the secondNext is not equal to null, update the previous pointer of secondNext to current. After that, the previous pointer of current node to firstNext, and the previous pointer of firstNext to prev node.

7. As a last step, update the current node to its next node inorder to continue with traversal.

8. Finally, update the head node to newHead for the modified list.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. This is because we are traversing through a list at most once . 

Here, we don't use any additional datastructure other than few variables. Hence, the space complexity will be `O(1)`.
