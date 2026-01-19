"""
Merge Two Sorted Lists

Merge two sorted linked lists and return it as a sorted list.

Time Complexity: O(n + m)
Space Complexity: O(1) iterative, O(n + m) recursive
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def merge_two_lists_iterative(l1, l2):
    """
    Iterative approach.
    TC: O(n + m), SC: O(1)
    """
    dummy = ListNode()
    current = dummy
    
    while l1 and l2:
        if l1.val <= l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next
    
    current.next = l1 or l2
    
    return dummy.next


def merge_two_lists_recursive(l1, l2):
    """
    Recursive approach.
    TC: O(n + m), SC: O(n + m)
    """
    if not l1:
        return l2
    if not l2:
        return l1
    
    if l1.val <= l2.val:
        l1.next = merge_two_lists_recursive(l1.next, l2)
        return l1
    else:
        l2.next = merge_two_lists_recursive(l1, l2.next)
        return l2


def print_list(head):
    """Helper to print linked list."""
    values = []
    while head:
        values.append(str(head.val))
        head = head.next
    return " -> ".join(values)


# Test case
if __name__ == "__main__":
    # List 1: 1 -> 2 -> 4
    l1 = ListNode(1, ListNode(2, ListNode(4)))
    # List 2: 1 -> 3 -> 4
    l2 = ListNode(1, ListNode(3, ListNode(4)))
    
    print(f"List 1: {print_list(l1)}")
    print(f"List 2: {print_list(l2)}")
    
    merged = merge_two_lists_iterative(l1, l2)
    print(f"Merged: {print_list(merged)}")
