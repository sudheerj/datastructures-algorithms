"""
Queue implementation using two stacks in Python.
"""


class MyStack:
    """Stack implementation using a list."""
    
    def __init__(self):
        self.items = []

    def push(self, value):
        """Pushes a value onto the stack."""
        self.items.append(value)

    def pop(self):
        """Pops and returns the top value from the stack."""
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot pop from an empty stack.")
        return self.items.pop()

    def peek(self):
        """Returns the top value without removing it."""
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot peek from an empty stack.")
        return self.items[-1]

    def is_empty(self):
        """Returns True if the stack is empty."""
        return len(self.items) == 0

    def size(self):
        """Returns the number of elements in the stack."""
        return len(self.items)


class MyQueue:
    """Queue implementation using two stacks."""
    
    def __init__(self):
        self.stack_newest = MyStack()  # for enqueue
        self.stack_oldest = MyStack()  # for dequeue

    def _shift_stacks(self):
        """Moves elements from newest stack to oldest stack if oldest is empty."""
        if self.stack_oldest.is_empty():
            while not self.stack_newest.is_empty():
                self.stack_oldest.push(self.stack_newest.pop())

    # Core queue operations
    def enqueue(self, value):
        """Adds an item to the back of the queue."""
        self.stack_newest.push(value)

    def dequeue(self):
        """Removes and returns the front item from the queue."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot dequeue from an empty queue.")
        
        self._shift_stacks()
        return self.stack_oldest.pop()

    def peek(self):
        """Returns the front item without removing it."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot peek from an empty queue.")
        
        self._shift_stacks()
        return self.stack_oldest.peek()

    # Helper functions
    def is_empty(self):
        """Returns True if the queue is empty."""
        return self.stack_newest.is_empty() and self.stack_oldest.is_empty()

    def size(self):
        """Returns the number of elements in the queue."""
        return self.stack_newest.size() + self.stack_oldest.size()

    def print_queue(self):
        """Returns a string representation of the queue."""
        # Combine both stacks in the correct order
        oldest_items = list(reversed(self.stack_oldest.items))
        newest_items = self.stack_newest.items
        all_items = oldest_items + newest_items
        return ' '.join(str(item) for item in all_items)


# Usage example
if __name__ == "__main__":
    queue = MyQueue()

    print(f"Is empty? {queue.is_empty()}")  # True

    try:
        queue.dequeue()  # Should throw
    except Exception as e:
        print(e)

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    print(f"Queue contents: {queue.print_queue()}")  # 1 2 3
    print(f"Front element: {queue.peek()}")  # 1
    print(f"Dequeued element: {queue.dequeue()}")  # 1
    print(f"Queue after dequeue: {queue.print_queue()}")  # 2 3
