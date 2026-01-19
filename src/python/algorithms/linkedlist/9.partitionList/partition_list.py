"""
Partition List

Given the head of a linked list and a value x, partition it such that
all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each partition.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def partition_list(head, x):
    """
    Two pointer approach with separate partitions.
    TC: O(n), SC: O(1)
    """
    if not head:
        return None
    
    # Create two separate lists
    before_head = ListNode(0)
    after_head = ListNode(0)
    
    before = before_head
    after = after_head
    
    while head:
        if head.value < x:
            before.next = head
            before = before.next
        else:
            after.next = head
            after = after.next
        head = head.next
    
    # Connect the two partitions
    after.next = None
    before.next = after_head.next
    
    return before_head.next


def print_list(head):
    """Helper to print linked list."""
    result = []
    while head:
        result.append(str(head.value))
        head = head.next
    return " -> ".join(result)


# Test cases
if __name__ == "__main__":
    # Create list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
    head = ListNode(1)
    head.next = ListNode(4)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(2)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(2)
    
    print(f"Original list: {print_list(head)}")
    
    x = 3
    result = partition_list(head, x)
    print(f"Partitioned at x={x}: {print_list(result)}")
    # Expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5
