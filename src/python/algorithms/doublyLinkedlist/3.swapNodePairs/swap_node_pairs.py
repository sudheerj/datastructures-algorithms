"""
Swap Node Pairs in Doubly Linked List

Swap every two adjacent nodes in a doubly linked list.

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
    
    def swap_pairs(self):
        """Swap every two adjacent nodes. TC: O(n), SC: O(1)"""
        if self.length < 2:
            return
        
        current = self.head
        new_head = self.head.next
        
        while current and current.next:
            first_next = current.next
            second_next = current.next.next
            prev = current.prev
            
            if prev:
                prev.next = first_next
            first_next.next = current
            current.next = second_next
            
            if second_next:
                second_next.prev = current
            current.prev = first_next
            first_next.prev = prev
            
            # Update tail if needed
            if not current.next:
                self.tail = current
            
            current = current.next
        
        self.head = new_head
    
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
    
    print(f"Before swap pairs: {dll.print_list()}")
    dll.swap_pairs()
    print(f"After swap pairs: {dll.print_list()}")
    # 1 <-> 2 <-> 3 <-> 4 becomes 2 <-> 1 <-> 4 <-> 3
    
    dll2 = DoublyLinkedList()
    dll2.push(1)
    dll2.push(2)
    dll2.push(3)
    dll2.push(4)
    dll2.push(5)
    
    print(f"Before swap pairs: {dll2.print_list()}")
    dll2.swap_pairs()
    print(f"After swap pairs: {dll2.print_list()}")
    # 1 <-> 2 <-> 3 <-> 4 <-> 5 becomes 2 <-> 1 <-> 4 <-> 3 <-> 5
