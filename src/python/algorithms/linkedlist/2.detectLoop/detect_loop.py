"""
Detect Cycle in Linked List

Given head, determine if the linked list has a cycle in it.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def has_cycle(head):
    """
    Floyd's Tortoise and Hare algorithm.
    TC: O(n), SC: O(1)
    """
    if not head or not head.next:
        return False
    
    slow = head
    fast = head
    
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        
        if slow == fast:
            return True
    
    return False


def detect_cycle_start(head):
    """
    Find the node where cycle begins.
    TC: O(n), SC: O(1)
    """
    if not head or not head.next:
        return None
    
    slow = fast = head
    
    # Detect cycle
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        
        if slow == fast:
            break
    else:
        return None  # No cycle
    
    # Find cycle start
    slow = head
    while slow != fast:
        slow = slow.next
        fast = fast.next
    
    return slow


# Test case
if __name__ == "__main__":
    # Create list with cycle: 1 -> 2 -> 3 -> 4 -> 2 (cycle back)
    node1 = ListNode(1)
    node2 = ListNode(2)
    node3 = ListNode(3)
    node4 = ListNode(4)
    
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2  # Create cycle
    
    print(f"Has cycle: {has_cycle(node1)}")  # True
    
    cycle_start = detect_cycle_start(node1)
    print(f"Cycle starts at node with value: {cycle_start.val if cycle_start else None}")  # 2
