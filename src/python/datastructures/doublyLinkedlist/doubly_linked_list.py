"""
Doubly Linked List implementation in Python.
"""


class Node:
    """Node class for doubly linked list."""
    
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None


class DoublyLinkedList:
    """Doubly Linked List implementation."""
    
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0

    def push(self, value):
        """Adds a new node with the given value at the end of the list."""
        new_node = Node(value)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            new_node.prev = self.tail
            self.tail = new_node
        self.length += 1
        return self

    def pop(self):
        """Removes the last node from the list and returns it."""
        if self.length == 0:
            return None
        temp = self.tail
        if self.length == 1:
            self.head = None
            self.tail = None
        else:
            self.tail = self.tail.prev
            self.tail.next = None
            temp.prev = None
        self.length -= 1
        return temp

    def unshift(self, value):
        """Adds a new node with the given value at the start of the list."""
        new_node = Node(value)
        if self.length == 0:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node
        self.length += 1
        return self

    def shift(self):
        """Removes the first node from the list and returns it."""
        if self.length == 0:
            return None
        temp = self.head
        if self.length == 1:
            self.head = None
            self.tail = None
        else:
            self.head = temp.next
            temp.next = None
            self.head.prev = None
        self.length -= 1
        return temp

    def get(self, index):
        """Returns the node at the given index (optimized for both ends)."""
        if index < 0 or index >= self.length:
            return None
        if index < self.length // 2:
            temp = self.head
            for _ in range(index):
                temp = temp.next
        else:
            temp = self.tail
            for _ in range(self.length - 1, index, -1):
                temp = temp.prev
        return temp

    def set(self, index, value):
        """Updates the value of the node at the given index."""
        temp = self.get(index)
        if temp:
            temp.value = value
            return True
        return False

    def insert(self, index, value):
        """Inserts a new node with the given value at the specified index."""
        if index < 0 or index > self.length:
            return False
        if index == 0:
            return bool(self.unshift(value))
        if index == self.length:
            return bool(self.push(value))
        
        new_node = Node(value)
        before = self.get(index - 1)
        after = before.next
        
        before.next = new_node
        new_node.next = after
        new_node.prev = before
        after.prev = new_node
        
        self.length += 1
        return True

    def remove(self, index):
        """Removes the node at the specified index and returns it."""
        if index < 0 or index >= self.length:
            return None
        if index == 0:
            return self.shift()
        if index == self.length - 1:
            return self.pop()
        
        temp = self.get(index)
        temp.prev.next = temp.next
        temp.next.prev = temp.prev
        
        temp.next = None
        temp.prev = None
        self.length -= 1
        
        return temp

    def reverse(self):
        """Reverses the linked list in place."""
        if self.length <= 1:
            return self
        
        current = self.head
        prev = None
        
        while current is not None:
            prev = current.prev
            current.prev = current.next
            current.next = prev
            current = current.prev
        
        self.head, self.tail = self.tail, self.head
        
        return self

    def print_list(self):
        """Prints all values in the list."""
        values = []
        current = self.head
        while current:
            values.append(str(current.value))
            current = current.next
        print(" <-> ".join(values))


# Usage example
if __name__ == "__main__":
    dll = DoublyLinkedList()
    dll.push(1)
    dll.push(2)
    dll.push(3)
    dll.push(4)

    print("Original list:")
    dll.print_list()

    print("\nAfter reversing:")
    dll.reverse()
    dll.print_list()

    print(f"\nLength: {dll.length}")
    print(f"Head value: {dll.head.value}")
    print(f"Tail value: {dll.tail.value}")
