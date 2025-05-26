# Reverse Polish Notation

Reverse Polish Notation (RPN), also known as postfix notation, is a mathematical notation in which every operator follows all of its operands. This notation eliminates the need for parentheses and simplifies the evaluation of expressions using a stack.

## Problem Statement

Given an array of strings `tokens` that represents an arithmetic expression in Reverse Polish Notation, calculate the value of the expression and return it as an integer.

**Note:**
1. The expression only contains the operators `+`, `-`, `*`, and `/` along with integer operands.
2. The expression is guaranteed to be valid and will not contain division by zero.
3. For division operations, the result should be truncated toward zero (integer division).

## Examples

**Example 1**  
Input: `tokens = ["1","3","+","4","*"]`  
Output: `16`  
Explanation: `((1 + 3) * 4) = 16`

**Example 2**  
Input: `tokens = ["5","4","3","2","+","-10","*","/","*","10","+","4","+"]`  
Output: `14`  
Explanation: Complex expression evaluation using the RPN rules

## Algorithm

This problem is solved using stack operations(**push and pop**) to evaluate the expression. The approach is as follows:

1. Initialize an empty stack.
2. Iterate through each token in the input array:
   - If the token is a number, convert it to an integer and push it onto the stack.
   - If the token is an operator (`+`, `-`, `*`, `/`):
     - Pop the top two elements from the stack (the second operand first, then the first operand).
     - Apply the operator to these operands.
     - Push the result back onto the stack.
3. After processing all tokens, the stack will contain exactly one element, which is the final result.



## Complexity

- **Time Complexity:** O(n), where n is the number of tokens in the input array. Each token is processed exactly once.
- **Space Complexity:** O(n) in the worst case, where the stack might need to store up to n/2 numbers (when all operators are at the end).
