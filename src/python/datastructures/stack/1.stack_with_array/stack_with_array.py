"""
Stack implementation using array (list) in Python.
"""


class MyStack:
    """Stack implementation using a list."""
    
    def __init__(self):
        self.items = []

    # Core stack operations
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

    # Helper functions
    def is_empty(self):
        """Returns True if the stack is empty."""
        return len(self.items) == 0

    def size(self):
        """Returns the number of elements in the stack."""
        return len(self.items)

    def print_stack(self):
        """Returns a string representation of the stack."""
        return ' '.join(str(item) for item in self.items)


# Usage example
if __name__ == "__main__":
    stack = MyStack()

    print(f"Is empty? {stack.is_empty()}")  # True

    try:
        stack.pop()  # Should throw
    except Exception as e:
        print(e)

    stack.push(1)
    stack.push(2)
    stack.push(3)

    print(f"Stack contents: {stack.print_stack()}")  # 1 2 3
    print(f"Top element: {stack.peek()}")  # 3
    print(f"Popped element: {stack.pop()}")  # 3
    print(f"Stack after pop: {stack.print_stack()}")  # 1 2
