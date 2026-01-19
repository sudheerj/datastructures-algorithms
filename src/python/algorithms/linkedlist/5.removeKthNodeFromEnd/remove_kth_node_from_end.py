"""
Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end and return its head.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def remove_nth_from_end(head, n):
    """
    Two pointer approach.
    TC: O(n), SC: O(1)
    """
    dummy = ListNode(0, head)
    slow = fast = dummy
    
    # Move fast pointer n+1 steps ahead
    for _ in range(n + 1):
        fast = fast.next
    
    # Move both pointers until fast reaches the end
    while fast:
        slow = slow.next
        fast = fast.next
    
    # Remove the nth node
    slow.next = slow.next.next
    
    return dummy.next


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
    result = remove_nth_from_end(head, 2)
    print(f"After removing 2nd from end: {print_list(result)}")  # 1 -> 2 -> 3 -> 5
