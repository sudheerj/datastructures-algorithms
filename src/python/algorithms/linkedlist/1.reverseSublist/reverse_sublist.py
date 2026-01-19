"""
Reverse Linked List

Given the head of a singly linked list, reverse the list and return the reversed list.

Time Complexity: O(n)
Space Complexity: O(1) iterative, O(n) recursive
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverse_list_iterative(head):
    """
    Iterative approach.
    TC: O(n), SC: O(1)
    """
    prev = None
    current = head
    
    while current:
        next_temp = current.next
        current.next = prev
        prev = current
        current = next_temp
    
    return prev


def reverse_list_recursive(head):
    """
    Recursive approach.
    TC: O(n), SC: O(n)
    """
    if not head or not head.next:
        return head
    
    new_head = reverse_list_recursive(head.next)
    head.next.next = head
    head.next = None
    
    return new_head


def print_list(head):
    """Helper to print linked list."""
    values = []
    while head:
        values.append(str(head.val))
        head = head.next
    return " -> ".join(values)


# Test case
if __name__ == "__main__":
    # Create list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    
    print(f"Original: {print_list(head)}")
    reversed_head = reverse_list_iterative(head)
    print(f"Reversed: {print_list(reversed_head)}")
