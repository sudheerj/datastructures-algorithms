"""
Remove Duplicates from Sorted Linked List

Given the head of a sorted linked list, delete all duplicates
such that each element appears only once. Return the linked list sorted as well.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def remove_duplicates(head):
    """
    Iterative approach comparing adjacent nodes.
    TC: O(n), SC: O(1)
    """
    if not head:
        return None
    
    curr = head
    
    while curr and curr.next:
        if curr.value == curr.next.value:
            curr.next = curr.next.next
        else:
            curr = curr.next
    
    return head


def print_list(head):
    """Helper to print linked list."""
    result = []
    while head:
        result.append(str(head.value))
        head = head.next
    return " -> ".join(result)


# Test cases
if __name__ == "__main__":
    # Create list: 1 -> 1 -> 2
    head1 = ListNode(1)
    head1.next = ListNode(1)
    head1.next.next = ListNode(2)
    
    print(f"Original list: {print_list(head1)}")
    result1 = remove_duplicates(head1)
    print(f"After removing duplicates: {print_list(result1)}")  # 1 -> 2
    
    # Create list: 1 -> 1 -> 2 -> 3 -> 3
    head2 = ListNode(1)
    head2.next = ListNode(1)
    head2.next.next = ListNode(2)
    head2.next.next.next = ListNode(3)
    head2.next.next.next.next = ListNode(3)
    
    print(f"Original list: {print_list(head2)}")
    result2 = remove_duplicates(head2)
    print(f"After removing duplicates: {print_list(result2)}")  # 1 -> 2 -> 3
