**Description:**
Given a stack of integers `nums`, sort it in ascending order using another temporary stack.

## Examples:
Example 1
Input: [8, 2, 4, 1, 5, 3] 
Output: [1, 2, 3, 4, 5, 8]

Example 2
Input: [6, 5, 4, 3, 2, 1] 
Output: [1, 2, 3, 4, 5, 6]

**Algorithmic Steps:**

This problem is solved with the help of **stack push & pop** to sort the elements in a particular order. The algorithmic approach can be summarized as follows:

1. Accept the input stack as an argument to sort its elements.
   
2. Add a preliminary check by verifying the size of the stack less than one or not. If it is, just return from the function.
   
3. Create a stack implementation(i.e, `myStack`) based on array. It includes push, pop and peek operations.

4. Create a temporary stack(`tempStack`) for storing the intermediate results inorder to calculate the sorted stack.
   
5. Iterate over the input stack `stack` until the elements exists in input stack.
   
6. For each iteration,
   1. Get the top value of input stack and store it in `temp` variable.
   2. Iterate over the temporary stack until it's size is greater than zero and the top value of temporary stack is greater than temp value.
   3. For each above nested iteration, get the top element from temporary stack and push it to the input stack. This step helps to move higher values from temporary stack to insert lower values at the beginning.
   4. If the condition of step2 is not satisfied, push the element to the temporary stack.

7. Update the input stack with the elements of temporary stack to sort the elements in an ascending order.

**Time and Space complexity:**

This algorithm has a time complexity of `O(n*2)`, where `n` is the number of elements in an array. This is because of traversal over the characters in a stack and temporary stack. 

Here, we used stack data structure store the sorted elements in a temporary stack. Hence, the space complexity will be `O(n)`.