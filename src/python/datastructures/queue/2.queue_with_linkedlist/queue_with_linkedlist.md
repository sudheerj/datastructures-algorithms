# Queue with Linked List

A queue implemented using a singly linked list. Enqueue at the tail and dequeue from the head for O(1) operations.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| enqueue   | O(1)           | Add element to back |
| dequeue   | O(1)           | Remove element from front |
| peek      | O(1)           | View front element |
| is_empty  | O(1)           | Check if queue is empty |
| size      | O(1)           | Get number of elements |

## Advantages over Array Implementation

- O(1) dequeue operation (vs O(n) for array)
- No need to resize (dynamic size)

## Usage

```python
from queue_with_linkedlist import MyQueue

queue = MyQueue()
queue.enqueue(1)
queue.enqueue(2)
print(queue.peek())     # 1
print(queue.dequeue())  # 1
```
