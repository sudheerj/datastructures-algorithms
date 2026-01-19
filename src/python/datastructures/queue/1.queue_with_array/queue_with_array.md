# Queue with Array

A queue is a linear data structure that follows the First In First Out (FIFO) principle.

## Operations

| Operation | Time Complexity | Description |
|-----------|-----------------|-------------|
| enqueue   | O(1)           | Add element to back |
| dequeue   | O(n)           | Remove element from front |
| peek      | O(1)           | View front element |
| is_empty  | O(1)           | Check if queue is empty |
| size      | O(1)           | Get number of elements |

Note: `dequeue` is O(n) because removing from the front of a list requires shifting all elements.

## Usage

```python
from queue_with_array import MyQueue

queue = MyQueue()
queue.enqueue(1)
queue.enqueue(2)
print(queue.peek())     # 1
print(queue.dequeue())  # 1
```
