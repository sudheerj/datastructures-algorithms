class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def swap_node_pairs(head):
    dummy = ListNode(0, head)
    prev, curr = dummy, head
    while curr and curr.next:
        next_pair = curr.next.next
        second = curr.next
        second.next = curr
        curr.next = next_pair
        prev.next = second
        prev = curr
        curr = next_pair
    return dummy.next

def print_list(head):
    vals = []
    while head:
        vals.append(str(head.val))
        head = head.next
    print(' -> '.join(vals))

def create_list(arr):
    dummy = ListNode()
    curr = dummy
    for v in arr:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next

if __name__ == "__main__":
    # Example 1: Even number of nodes
    head1 = create_list([1,2,3,4])
    # Expected: 2 -> 1 -> 4 -> 3
    print_list(swap_node_pairs(head1))
    # Example 2: Odd number of nodes
    head2 = create_list([1,2,3,4,5])
    # Expected: 2 -> 1 -> 4 -> 3 -> 5
    print_list(swap_node_pairs(head2))
    # Example 3: Single node
    head3 = create_list([1])
    # Expected: 1
    print_list(swap_node_pairs(head3))
    # Example 4: Empty list
    head4 = create_list([])
    # Expected: (empty)
    print_list(swap_node_pairs(head4))
