**Problem statement:**
Given the `head` of a singly linked list and two integers `left` and `right` where left <= right. Reverse the nodes of the list that fall between the positions `left` and `right` (inclusive), and return the reversed list.

**Note:** The positions are 1-indexed(not 0-indexed). i.e, 1 <= left <= right <= n. Where `n` is the length of list.


## Examples:
Example 1:

Input: head = [1,2,3,4,5,6], left=2, right=5
Output: [1,5,4,3,2,6]

Example 2:

Input: head = [1,2,3,4,5,6], left=1, right=3
Output: [3,2,1,4,5,6]

Example 3: 

Input: head = [4], left=1, right=1
Output: [4]

**Algorithmic Steps**
This problem is solved by understanding the concept of full reversal of linkedlist and keeping the pointers for the nodes at the boundaries where we actually reverse the sublist. Later, these boundary pointers are helpful to connect the reversed list with the remaining parts of the non-reversed linkedlist. The algorithmic approach can be summarized as follows: 

1. Handle the base case scenarios such as empty list ,or list with one node, or left and right pointers are equal. In these cases, there is no need of reversal of linkedlist.(i.e, Just return the original list)

2. Create a dummy node(`dummy`) to simplify the edge case handling, such as when reversing the list from the first node itself.

3. Connect the dummy node to the head node.

4. Declare the boundary pointers `leftPrev` and `current` pointing to the dummy node and head nodes respectively. These pointers are helpful to point the node before the reversal and beginning of the reversal list respectively.

5. Iterate the loop `left-1` times to reach the boundary section.

6. Implement the reversal of sublist starting from `current` node and keep tracking the previous node `prev` initialized with `null`. This reversal logic needs to be looped `right-left+1` times.

7. Upon reversing the references of sublist, connect the non-reversed sublists with reversed section.

8. At last, return the head node(`this.dummy.next`) which contains the reversed nodes of linkedlist.


**Time and Space complexity:**
This algorithm has a time complexity of `O(n)`, where `n` is the number of nodes in a linkedlist. This is because we are traversing the list at most once. 

Here, we don't use any additional datastructure other than few pointers for the node. Hence, the space complexity will be `O(1)`.
