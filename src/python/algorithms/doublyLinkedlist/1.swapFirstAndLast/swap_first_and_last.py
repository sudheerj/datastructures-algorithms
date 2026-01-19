"""
Swap First and Last Nodes in Doubly Linked List

Swap the values of the first and last nodes in a doubly linked list.

Time Complexity: O(1)
Space Complexity: O(1)
"""


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0
    
    def push(self, value):
        """Add a node to the end of the list."""
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
    
    def swap_first_last(self):
        """Swap values of first and last nodes. TC: O(1), SC: O(1)"""
        if self.length <= 1:
            return
        self.head.value, self.tail.value = self.tail.value, self.head.value
    
    def print_list(self):
        """Print the list values."""
        values = []
        curr = self.head
        while curr:
            values.append(str(curr.value))
            curr = curr.next
        return " <-> ".join(values)


# Test cases
if __name__ == "__main__":
    dll = DoublyLinkedList()
    dll.push(1)
    dll.push(2)
    dll.push(3)
    dll.push(4)
    dll.push(5)
    
    print(f"Before swap: {dll.print_list()}")
    dll.swap_first_last()
    print(f"After swap: {dll.print_list()}")
