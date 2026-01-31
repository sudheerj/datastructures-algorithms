# **Balanced Brackets**

## **Problem Statement**
Given a string containing brackets ({}, [], ()), determine if the brackets are balanced.

---

## **Examples**

### Example 1:
- **Input**: `"{[()]}"`
- **Output**: `true`

### Example 2:
- **Input**: `"{[(])}"`
- **Output**: `false`

---

## **Algorithmic Approach**

1. Use a stack.
2. For each character:
   - If opening bracket: Push to stack.
   - If closing bracket: Pop from stack, check if it matches.
3. Return true if stack is empty at end.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through string.

- **Space Complexity**: `O(n)`  
  Stack can hold n/2 opening brackets.
