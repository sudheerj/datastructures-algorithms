# **Reverse Polish Notation**

## **Problem Statement**
Evaluate the value of an arithmetic expression in Reverse Polish Notation (postfix notation).

---

## **Examples**

### Example 1:
- **Input**: `["2","1","+","3","*"]`
- **Output**: `9` ((2 + 1) * 3)

### Example 2:
- **Input**: `["4","13","5","/","+"]`
- **Output**: `6` (4 + (13 / 5))

---

## **Algorithmic Approach**

1. Use a stack.
2. For each token:
   - If number: Push to stack.
   - If operator: Pop two operands, apply operator, push result.
3. Return final value in stack.

---

## **Time and Space Complexity**

- **Time Complexity**: `O(n)`  
  Single pass through tokens.

- **Space Complexity**: `O(n)`  
  Stack for operands.
