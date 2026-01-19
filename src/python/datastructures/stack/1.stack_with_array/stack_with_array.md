# Stack with Array

A stack is a linear data structure that follows the Last In First Out (LIFO) principle.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| push      | O(1)           | Add element to top |
| pop       | O(1)           | Remove element from top |
| peek      | O(1)           | View top element |
| is_empty  | O(1)           | Check if stack is empty |
| size      | O(1)           | Get number of elements |

## Usage

```python
from stack_with_array import MyStack

stack = MyStack()
stack.push(1)
stack.push(2)
print(stack.peek())  # 2
print(stack.pop())   # 2
```
