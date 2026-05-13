**Problem statement:**
Given an array of `k` sorted linked lists `lists`. Merge all the lists into one sorted linked list and return the head of the newly created sorted linked list.

**Note:** The merged linked list should be constructed by connecting the nodes from all the lists directly.


## Examples:
Example 1:

Input: l1 = [1,2,3], l2 = [4,5,6], l3 = [7,8,9], l4 = [10,11,12]
Output: [1,2,3,4,5,6,7,8,9,10,11,12]

Example 2: 

Input: l1 = [], l2 = []
Output: []

**Algorithmic Steps**
This problem is solved by divide and conquer principle, where each pair of lists merged until there are only one merged list exists. The algorithmic approach can be summarized as follows: 

1. Accept the `k`number of `lists` as input.
   
2. Create a `length` to store the length of list and `interval`  variable (initialized to 1)to merge the lists in each level.

3. Loop over the lists until the interval is less than list's size.

4. Create a nested loop to merge each pair of lists based on interval. 
   
5. Invoke the merge two lists algorithms to merge each pair of lists and update the input `lists` at the respective position.

6. Upon each inner loop completed, updated the interval by multiplying with 2.
   
7. Return the first index position of `lists` as merged list.


**Time and Space complexity:**
This algorithm takes a time complexity of `O(n logk)`, where  `n` is the total number of nodes in all the lists and `k` represents the number of lists. This is because we need to traverse each node in all the lists and it needs to be repeated by dividing the list by 2(i.e, log k). As a result, it requires `O(n log k)` times.

Here, we don't use any additional datastructure other than few constant variables. Hence, the space complexity will be `O(1)`.
