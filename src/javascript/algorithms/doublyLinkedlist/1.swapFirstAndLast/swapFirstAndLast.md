**Problem statement:**
Given a doubly linked list. Implement `swapFirstLast()` that swaps the values of the first and last nodes of doubly linked list.

## Examples:

Input: [1,2,3,4,5]
Output: [5,2,3,4,1]

**Algorithmic Steps**
This problem is solved by swapping the values of head and tail nodes. The algorithmic approach can be summarized as follows: 

1. Add an edge case returing immediately if the length of the list is less than or equal to 1.

2. Store the head's value in a temporary variable `temp`.

3. Update the head's value with tail's value.

4. Modify the tail's value with a value stored in `temp` variable.

5. Now the list is modified with swapped values of first and last nodes.

**Time and Space complexity:**
This algorithm has a time complexity of `O(1)`. This is because we are just swapping the first and last node values in a list. 

Here, we don't use any additional datastructure other than few variables. Hence, the space complexity will be `O(1)`.
