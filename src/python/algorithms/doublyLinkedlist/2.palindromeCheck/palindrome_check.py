"""
Palindrome Check using Doubly Linked List

Check if a doubly linked list is a palindrome.

Time Complexity: O(n)
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
    
    def is_palindrome(self):
        """Check if the list is a palindrome. TC: O(n), SC: O(1)"""
        if self.length < 2:
            return True
        
        forward_node = self.head
        backward_node = self.tail
        
        for _ in range(self.length // 2):
            if forward_node.value != backward_node.value:
                return False
            forward_node = forward_node.next
            backward_node = backward_node.prev
        
        return True
    
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
    # Test palindrome list: 1 -> 2 -> 3 -> 2 -> 1
    dll1 = DoublyLinkedList()
    dll1.push(1)
    dll1.push(2)
    dll1.push(3)
    dll1.push(2)
    dll1.push(1)
    print(f"List: {dll1.print_list()}")
    print(f"Is palindrome: {dll1.is_palindrome()}")  # True
    
    # Test non-palindrome list: 1 -> 2 -> 3 -> 4 -> 5
    dll2 = DoublyLinkedList()
    dll2.push(1)
    dll2.push(2)
    dll2.push(3)
    dll2.push(4)
    dll2.push(5)
    print(f"List: {dll2.print_list()}")
    print(f"Is palindrome: {dll2.is_palindrome()}")  # False
