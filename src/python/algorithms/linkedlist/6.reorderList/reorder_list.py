"""
Reorder List

Given the head of a singly linked list: L0 → L1 → … → Ln-1 → Ln
Reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorder_list(head):
    """
    Three steps: find middle, reverse second half, merge.
    TC: O(n), SC: O(1)
    """
    if not head or not head.next:
        return
    
    # Step 1: Find the middle
    slow = fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    
    # Step 2: Reverse the second half
    second = slow.next
    slow.next = None  # Cut the list
    prev = None
    
    while second:
        next_temp = second.next
        second.next = prev
        prev = second
        second = next_temp
    
    second = prev
    
    # Step 3: Merge two halves
    first = head
    while second:
        tmp1, tmp2 = first.next, second.next
        first.next = second
        second.next = tmp1
        first, second = tmp1, tmp2


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
    reorder_list(head)
    print(f"Reordered: {print_list(head)}")  # 1 -> 5 -> 2 -> 4 -> 3
