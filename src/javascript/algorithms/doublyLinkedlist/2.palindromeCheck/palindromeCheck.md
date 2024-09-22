**Problem statement:**
Given a doubly linked list. Implement `isPalindrome()` that verify the node values of a doubly linked list forms a palindrome or not.

## Examples:
Example1:

Input: [1,2,3,2,1]
Output: true

Example2:

Input: [1,2,3,4,5]
Output: false

**Algorithmic Steps**
This problem is solved with the help of two pointers traversing from both ends of the list. The algorithmic approach can be summarized as follows: 

1. Add an edge case returing true if the length of the list is less than 2.

2. Store the head and tail nodes in `forwardNode` and `backwardNode` respectively.

3. Iterate over the list until the index is less than middle element.

4. Compare both forward and backward nodes. Return false if they are not equal.

5. Update both forward and backward nodes to next and previous nodes respectively.
   
6. Return true after the loop indicating that palindrome exists with given nodes.

**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of elements. This is because we are traversing through a list at most once. 

Here, we don't use any additional datastructure other than few variables. Hence, the space complexity will be `O(1)`.
