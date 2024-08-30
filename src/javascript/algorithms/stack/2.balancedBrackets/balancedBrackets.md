**Description:**
Given a string `str` which contains the characters '(', ')', '{', '}', '[' and ']'. Determine whether an input string is valid or not by following the below conditions,

1. Open brackets must be closed by the same type of brackets in the correct order.
2. Each close bracket has a respective open bracket of the same type.

## Examples:
Example 1
Input:  str = [()[]{}<>] 
Output: true


Example 2
Input: str = '[({<>})]'
Output: true

Example 3
Input: str = '([)]'
Output: false


**Algorithmic Steps:**

This problem is solved with the help of **stack push and pop** operations to determine the string has valid brackets or not. The algorithmic approach can be summarized as follows:

1. Add preliminary conditions for empty strings, string with one character and odd length. Return `true` if the string is empty and return `false` if the string has one character or length of the string is odd.
   
2. Create a stack implementation(i.e, `myStack`) based on array. It includes push, pop and peek operations.
   
3. Iterate over the input string `characters` and verify each character with the conditions of switch block.
   
4. If the character is an opening bracket(`([{<`), push it to the stack. 

5. If the character is a closing bracket(`>}])`), verify the top element of stack equals to respective opening bracket or not. If so, remove/pop the element to indicate the match. Otherwise, return `false` indicating that the given string is not a balanced.

6. Repeat steps 4-5 until the end of the string.

7. Return `false` if the stack is not empty. That means, there are still few characters which are not balanced.

**Time and Space complexity:**

This algorithm has a time complexity of `O(n)`, where `n` is the number of characters in a string. This is because traversal over the characters in a string at most once. 

Here, we used stack data structure store the opening brackets. In the worst case, the input string may contain only opening brackets. Hence, the space complexity will be O(n).