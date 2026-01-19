"""
Queue implementation using linked list in Python.
"""


class Node:
    """Node class for the queue."""
    
    def __init__(self, value):
        self.value = value
        self.next = None


class MyQueue:
    """Queue implementation using a linked list."""
    
    def __init__(self):
        self.first = None
        self.last = None
        self.length = 0

    # Core queue operations
    def enqueue(self, value):
        """Adds an item to the back of the queue."""
        new_node = Node(value)
        if self.is_empty():
            self.first = new_node
            self.last = new_node
        else:
            self.last.next = new_node
            self.last = new_node
        self.length += 1

    def dequeue(self):
        """Removes and returns the front item from the queue."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot dequeue from an empty queue.")
        
        temp = self.first
        if self.length == 1:
            self.first = None
            self.last = None
        else:
            self.first = self.first.next
            temp.next = None
        
        self.length -= 1
        return temp.value

    def peek(self):
        """Returns the front item without removing it."""
        if self.is_empty():
            raise Exception("Queue Underflow: Cannot peek from an empty queue.")
        return self.first.value

    # Helper functions
    def is_empty(self):
        """Returns True if the queue is empty."""
        return self.length == 0

    def size(self):
        """Returns the number of elements in the queue."""
        return self.length

    def print_queue(self):
        """Returns a string representation of the queue."""
        current = self.first
        values = []
        while current:
            values.append(str(current.value))
            current = current.next
        return ' '.join(values)


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
