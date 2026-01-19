# Stack with Linked List

A stack implemented using a singly linked list. New elements are added at the head (top) for O(1) push and pop operations.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| push      | O(1)           | Add element to top |
| pop       | O(1)           | Remove element from top |
| peek      | O(1)           | View top element |
| is_empty  | O(1)           | Check if stack is empty |
| size      | O(1)           | Get number of elements |

## Advantages over Array Implementation

- No need to resize (dynamic size)
- Memory efficient for sparse data

## Usage

```python
from stack_with_linkedlist import MyStack

stack = MyStack()
stack.push(1)
stack.push(2)
print(stack.peek())  # 2
print(stack.pop())   # 2
```
