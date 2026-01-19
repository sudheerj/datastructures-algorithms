"""
Find Middle Node of Linked List

Given the head of a singly linked list, return the middle node.
If there are two middle nodes, return the second one.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def find_middle_node(head):
    """
    Two pointer approach (slow and fast).
    TC: O(n), SC: O(1)
    """
    if not head:
        return None
    
    slow = head
    fast = head
    
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    return slow


def print_list(head):
    """Helper to print linked list."""
    result = []
    while head:
        result.append(str(head.value))
        head = head.next
    return " -> ".join(result)


# Test cases
if __name__ == "__main__":
    # Create list: 1 -> 2 -> 3 -> 4 -> 5
    head1 = ListNode(1)
    head1.next = ListNode(2)
    head1.next.next = ListNode(3)
    head1.next.next.next = ListNode(4)
    head1.next.next.next.next = ListNode(5)
    
    middle = find_middle_node(head1)
    print(f"List: {print_list(head1)}")
    print(f"Middle node value: {middle.value}")  # 3
    
    # Create list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    head2 = ListNode(1)
    head2.next = ListNode(2)
    head2.next.next = ListNode(3)
    head2.next.next.next = ListNode(4)
    head2.next.next.next.next = ListNode(5)
    head2.next.next.next.next.next = ListNode(6)
    
    middle2 = find_middle_node(head2)
    print(f"List: {print_list(head2)}")
    print(f"Middle node value: {middle2.value}")  # 4
