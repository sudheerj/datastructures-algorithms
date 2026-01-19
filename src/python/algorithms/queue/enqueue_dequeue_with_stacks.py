"""
Implement Queue using Stacks

Implement a FIFO queue using only two stacks.
The implemented queue should support push, pop, peek, and empty operations.

Time Complexity: Amortized O(1) for all operations
Space Complexity: O(n)
"""


class MyStack:
    """Simple stack implementation."""
    
    def __init__(self):
        self.items = []
    
    def push(self, value):
        self.items.append(value)
    
    def pop(self):
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot pop from an empty stack.")
        return self.items.pop()
    
    def peek(self):
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot peek from an empty stack.")
        return self.items[-1]
    
    def is_empty(self):
        return len(self.items) == 0
    
    def size(self):
        return len(self.items)


class MyQueue:
    """Queue implemented using two stacks."""
    
    def __init__(self):
        self.stack1 = MyStack()
        self.stack2 = MyStack()
    
    def enqueue(self, value):
        """Add element to the back of the queue. TC: O(n)"""
        # Move all elements from stack1 to stack2
        while not self.stack1.is_empty():
            self.stack2.push(self.stack1.pop())
        
        # Push the new element
        self.stack2.push(value)
        
        # Move everything back to stack1
        while not self.stack2.is_empty():
            self.stack1.push(self.stack2.pop())
    
    def dequeue(self):
        """Remove and return element from the front of the queue. TC: O(1)"""
        if self.stack1.is_empty():
            return None
        return self.stack1.pop()
    
    def peek(self):
        """Return the front element without removing it. TC: O(1)"""
        if self.stack1.is_empty():
            return None
        return self.stack1.peek()
    
    def is_empty(self):
        """Check if the queue is empty. TC: O(1)"""
        return self.stack1.is_empty()


# Alternative implementation with amortized O(1) operations
class MyQueueOptimized:
    """Queue with amortized O(1) operations."""
    
    def __init__(self):
        self.push_stack = MyStack()  # For enqueue
        self.pop_stack = MyStack()   # For dequeue
    
    def enqueue(self, value):
        """Add element to the back. TC: O(1)"""
        self.push_stack.push(value)
    
    def dequeue(self):
        """Remove and return from the front. TC: Amortized O(1)"""
        self._transfer()
        if self.pop_stack.is_empty():
            return None
        return self.pop_stack.pop()
    
    def peek(self):
        """Return the front element. TC: Amortized O(1)"""
        self._transfer()
        if self.pop_stack.is_empty():
            return None
        return self.pop_stack.peek()
    
    def _transfer(self):
        """Transfer elements from push_stack to pop_stack if needed."""
        if self.pop_stack.is_empty():
            while not self.push_stack.is_empty():
                self.pop_stack.push(self.push_stack.pop())
    
    def is_empty(self):
        return self.push_stack.is_empty() and self.pop_stack.is_empty()


# Test cases
if __name__ == "__main__":
    print("Testing MyQueue:")
    queue = MyQueue()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    print(f"Front element: {queue.peek()}")  # 1
    print(f"Dequeue: {queue.dequeue()}")     # 1
    print(f"Front element: {queue.peek()}")  # 2
    
    print("\nTesting MyQueueOptimized:")
    queue_opt = MyQueueOptimized()
    queue_opt.enqueue(1)
    queue_opt.enqueue(2)
    queue_opt.enqueue(3)
    print(f"Front element: {queue_opt.peek()}")  # 1
    print(f"Dequeue: {queue_opt.dequeue()}")     # 1
    print(f"Front element: {queue_opt.peek()}")  # 2
