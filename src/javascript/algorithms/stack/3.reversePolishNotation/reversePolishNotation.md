**Description:**
Given an array of strings `tokens` that represents an arithmetic expression in a **Reverse Polish Notation**(RPN). This RPN notation places the operator after the operands. Calculate the value of expression in the form of integer. 

**Note:**
1. The expression only contains the operators +, -, *, and / along with integer operands.
2. The expression needs to be valid and doesn't contain division by zero.

## Examples:
Example 1
Input:  tokens1 = ["1","3","+","4","*"]
Output: 16


Example 2
Input: tokens2 = ["5","4","3","2","+","-10","*","/","*","10","+","4","+"];
Output: 14


**Algorithmic Steps:**

This problem is solved with the help of **stack push and pop** operations to determine the value of arithmetic expression. The algorithmic approach can be summarized as follows:
   
1. Create a stack implementation(i.e, `myStack`) based on array. It includes push, pop and peek operations.
   
2. Iterate over the input string `tokens` and verify each token with the conditions of switch block.

3. If the token is an operator(`+, -, *, /`), pop the last two numbers from the stack and apply this operator considering these two numbers as operands. The result of the operation is then pushed back in the stack.
   
4. If the token is a number, just convert it to an integer type and push it onto `myStack`. 

5. Repeat steps 3-4 until there are no more tokens in the string.

6. Finally, `myStack` will contain only one element, which represents the result of an arithmetic expression. i.e, Just pop the stack element as an output.


**Time and Space complexity:**

This algorithm has a time complexity of `O(n)`, where `n` is the number of tokens in a string. This is because of traversal over all the tokens in a string at most once. 

Here, we used stack data structure store the intermediate result of each sub expression. Hence, the space complexity will be O(n).