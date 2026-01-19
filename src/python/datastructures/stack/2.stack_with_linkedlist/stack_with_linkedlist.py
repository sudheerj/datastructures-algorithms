"""
Stack implementation using linked list in Python.
"""


class Node:
    """Node class for the stack."""
    
    def __init__(self, value):
        self.value = value
        self.next = None


class MyStack:
    """Stack implementation using a linked list."""
    
    def __init__(self):
        self.top = None
        self.length = 0

    # Core stack operations
    def push(self, value):
        """Pushes a value onto the stack."""
        new_node = Node(value)
        if self.length == 0:
            self.top = new_node
        else:
            new_node.next = self.top
            self.top = new_node
        self.length += 1

    def pop(self):
        """Pops and returns the top value from the stack."""
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot pop from an empty stack.")
        temp = self.top
        self.top = self.top.next
        temp.next = None
        self.length -= 1
        return temp.value

    def peek(self):
        """Returns the top value without removing it."""
        if self.is_empty():
            raise Exception("Stack Underflow: Cannot peek from an empty stack.")
        return self.top.value

    # Helper functions
    def is_empty(self):
        """Returns True if the stack is empty."""
        return self.length == 0

    def size(self):
        """Returns the number of elements in the stack."""
        return self.length

    def print_stack(self):
        """Returns a string representation of the stack."""
        current = self.top
        values = []
        while current:
            values.insert(0, str(current.value))
            current = current.next
        return ' '.join(values)


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
