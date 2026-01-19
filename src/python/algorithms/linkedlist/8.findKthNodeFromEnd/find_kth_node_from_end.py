"""
Find Kth Node From End

Given the head of a linked list and an integer k,
return the kth node from the end of the list.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def find_kth_node_from_end(head, k):
    """
    Two pointer approach with k distance gap.
    TC: O(n), SC: O(1)
    """
    if not head or k <= 0:
        return None
    
    slow = head
    fast = head
    
    # Move fast pointer k steps ahead
    for _ in range(k):
        if not fast:
            return None  # k is larger than list length
        fast = fast.next
    
    # Move both pointers until fast reaches end
    while fast:
        slow = slow.next
        fast = fast.next
    
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
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    
    print(f"List: {print_list(head)}")
    
    k = 2
    result = find_kth_node_from_end(head, k)
    print(f"{k}th node from end: {result.value}")  # 4
    
    k = 1
    result = find_kth_node_from_end(head, k)
    print(f"{k}st node from end: {result.value}")  # 5
    
    k = 5
    result = find_kth_node_from_end(head, k)
    print(f"{k}th node from end: {result.value}")  # 1
    
    k = 6
    result = find_kth_node_from_end(head, k)
    print(f"{k}th node from end: {result}")  # None
