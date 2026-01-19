# Queue with Two Stacks

A queue implemented using two stacks. This is a common interview question demonstrating how to implement one data structure using another.

## How it Works

- **stack_newest**: Elements are pushed here during enqueue
- **stack_oldest**: Elements are popped from here during dequeue
- When dequeuing, if stack_oldest is empty, all elements from stack_newest are transferred

## Operations

| Operation | Amortized Time | Worst Case | Description |
|-----------|----------------|------------|-------------|
| enqueue   | O(1)          | O(1)       | Add element to back |
| dequeue   | O(1)          | O(n)       | Remove element from front |
| peek      | O(1)          | O(n)       | View front element |
| is_empty  | O(1)          | O(1)       | Check if queue is empty |
| size      | O(1)          | O(1)       | Get number of elements |

## Usage

```python
from queue_with_stacks import MyQueue

queue = MyQueue()
queue.enqueue(1)
queue.enqueue(2)
print(queue.peek())     # 1
print(queue.dequeue())  # 1
```
