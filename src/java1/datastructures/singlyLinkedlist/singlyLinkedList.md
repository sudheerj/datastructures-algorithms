A linked list is a linear data structure that consists of a series of elements connected by references. It contains head, tail and length properties. 

Each element of a linked list is a node, which has a value and a reference to next node. If the node is a tail, it's next value points to null.

The array data strcuture can be expensive for data insertion and deletion operations. Since linkedlist has dynamic size, it is easy to perform insertion and deletion. Unlike arrays, the elements in linked list doesn't have indexes in order, which doesn't allow random access.

There are different types of linked list exists, 

1. Singly linked list
2. Doubly linked list
3. Circular linked list.

The structure of single linked list looks like below,

   ![Screenshot](singlylinkedlist.png)

The linked list can have the following functionalities,

1. **Push:** You can push a new node into the end of list. First, you need to create a new node using a given value. If the list is empty, assign the head and tail to the new node. Otherwise, the tail's next node points to new node and current tail node assigned to new node as a new tail. Finally, increment the size of the list.

2. **Pop:** This action performs deleting the last element of list. If the list is empty, return undefined. Otherwise, loop through the list until you reach the tail. Set the next property of second last node to be null and update the tail pointer to the second last node. At last, decrement the length of the list.
   
3. **Unshift:** This action is used to insert the element at first position. If the list is empty, update the head and tail pointers to newly created node. Otherwise, set the next property of new node to head node and update the head node to newly added node. Similar to push, the size of the list needs to be incremented.
   
4. **Shift:** This action is used to delete the element at first position. If the list is empty, return undefined. Otherwise, update the head reference to current head's next node and decrement the length of the list. 
   
5. **Get:** Eventhough linked list doesn't support indexing, it is possible to fetch the node based on given index. First, return undefined if the length of the list is less than zero or greater than or equal to length of the list. Otherwise, loop through the list until you reach the index and return the respective node.
   
6. **Set:** This method is used to change a node in the linked list. First you need to get the node with `get()` and update the node's data based on given input.
   
7. **Insert:** This method is used to insert a node at any position with in the list. At first, you need to verify the boundary conditions. If the index is less than zero or greater than the length of the list. If so, just return false. Incase, if the index is equal to the length, insert the node using `push()` operation, if the index is zero, add the node using `unshift()` method. In all other cases, get the node at `index-1` position, and set the next property of that node to new node, and the next property of the new node to be the accessed node's next property. At the end, increment the size of the list.
   
8.  **Remove:** This method is used to remove a node at any position with in the list. At first, you need to verify the boundary conditions. If the index is less than zero or greater than the length of the list. If so, just return `undefined`. Incase, if the index is equal to `length-1`, delete the node using `pop()` operation, if the index is zero, delete the node using `shift()` method. In all other cases, get the node `index` position, and set the next property of that node to the next of the next property. As a last step, decrement the size of the list.
   
9.  **Reverse:** This action is used to reverse the elements of a list. First, swap the head and tail nodes. Thereafter, declare the next and prev nodes based on head node and reverse the references by looping through all the nodes. 

## Complexity

| Access            | Search             | Insertion | Deletion               | Space (Memory)    |
| :-------------: | :-----------------: | :-----------------: | :-------: | :-------: |
|  O(n)               | O(n)       | O(1)       | O(1)         | O(n)       | 