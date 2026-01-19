"""
Queue implementation using array (list) in Python.
"""


class MyQueue:
    """Queue implementation using a list."""
    
    def __init__(self):
        self.items = []

    # Core queue operations
    def enqueue(self, value):
        """Adds an item to the back of the queue."""
        self.items.append(value)

    def dequeue(self):
        """Removes and returns the front item from the queue."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot dequeue from an empty queue.")
        return self.items.pop(0)

    def peek(self):
        """Returns the front item without removing it."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot peek from an empty queue.")
        return self.items[0]

    # Helper functions
    def is_empty(self):
        """Returns True if the queue is empty."""
        return len(self.items) == 0

    def size(self):
        """Returns the number of elements in the queue."""
        return len(self.items)

    def print_queue(self):
        """Returns a string representation of the queue."""
        return ' '.join(str(item) for item in self.items)


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
