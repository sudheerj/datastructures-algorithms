"""
Implement Stack using Queues

Implement a LIFO stack using a single queue.
After each push, rotate all previous elements to the back so the
newest element stays at the front.

push:    TC: O(n), SC: O(1)
pop:     TC: O(1), SC: O(1)
top:     TC: O(1), SC: O(1)
isEmpty: TC: O(1), SC: O(1)
"""

from collections import deque


class MyStack:
    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)
        for _ in range(len(self.queue) - 1):
            self.queue.append(self.queue.popleft())

    def pop(self) -> int:
        return self.queue.popleft()

    def top(self) -> int:
        return self.queue[0]

    def is_empty(self) -> bool:
        return len(self.queue) == 0


if __name__ == "__main__":
    stack = MyStack()

    # Test push and top
    stack.push(1)
    stack.push(2)
    stack.push(3)
    print(stack.top())       # 3
    print(stack.is_empty())  # False

    # Test pop
    print(stack.pop())       # 3
    print(stack.top())       # 2

    print(stack.pop())       # 2
    print(stack.pop())       # 1
    print(stack.is_empty())  # True

    # Test push after pop
    stack.push(10)
    stack.push(20)
    print(stack.top())       # 20
    print(stack.pop())       # 20
    print(stack.top())       # 10
