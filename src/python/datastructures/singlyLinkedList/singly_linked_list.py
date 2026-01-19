"""
Singly Linked List implementation in Python.
"""


class Node:
    """Node class for singly linked list."""
    
    def __init__(self, value):
        self.value = value
        self.next = None


class LinkedList:
    """Singly Linked List implementation."""
    
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
            self.tail = new_node
        self.length += 1
        return self

    def pop(self):
        """Removes the last node from the list and returns it."""
        if not self.head:
            return None
        current = self.head
        new_tail = self.head
        while current.next:
            new_tail = current
            current = current.next
        self.tail = new_tail
        self.tail.next = None
        self.length -= 1
        if self.length == 0:
            self.head = None
            self.tail = None
        return current

    def unshift(self, value):
        """Adds a new node with the given value at the start of the list."""
        new_node = Node(value)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head = new_node
        self.length += 1
        return self

    def shift(self):
        """Removes the first node from the list and returns it."""
        if not self.head:
            return None
        current_head = self.head
        self.head = self.head.next
        current_head.next = None
        self.length -= 1
        if self.length == 0:
            self.tail = None
        return current_head

    def get(self, index):
        """Returns the node at the given index."""
        if index < 0 or index >= self.length:
            return None
        current = self.head
        for _ in range(index):
            current = current.next
        return current

    def set(self, index, value):
        """Updates the value of the node at the given index."""
        node = self.get(index)
        if node:
            node.value = value
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
        prev_node = self.get(index - 1)
        new_node.next = prev_node.next
        prev_node.next = new_node
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

        prev_node = self.get(index - 1)
        removed_node = prev_node.next
        prev_node.next = removed_node.next
        removed_node.next = None
        self.length -= 1
        return removed_node

    def reverse(self):
        """Reverses the linked list in place."""
        current = self.head
        self.head, self.tail = self.tail, self.head
        prev = None
        for _ in range(self.length):
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return self

    def print_list(self):
        """Prints all values in the list."""
        values = []
        current = self.head
        while current:
            values.append(str(current.value))
            current = current.next
        print(" -> ".join(values))


# Usage example
if __name__ == "__main__":
    ll = LinkedList()
    ll.push(1)
    ll.push(2)
    ll.push(3)
    ll.push(4)

    print("Original list:")
    ll.print_list()

    print("\nAfter reversing:")
    ll.reverse()
    ll.print_list()

    print(f"\nLength: {ll.length}")
    print(f"Head value: {ll.head.value}")
    print(f"Tail value: {ll.tail.value}")
