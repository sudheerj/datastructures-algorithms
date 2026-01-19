"""
Merge K Sorted Lists

You are given an array of k linked-lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Time Complexity: O(n log k) where n is total nodes and k is number of lists
Space Complexity: O(k) for the heap
"""

import heapq


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def merge_k_lists_heap(lists):
    """
    Min-heap approach for merging k sorted lists.
    TC: O(n log k), SC: O(k)
    """
    if not lists:
        return None
    
    dummy = ListNode(0)
    curr = dummy
    heap = []
    
    # Add first node from each list to heap
    for i, head in enumerate(lists):
        if head:
            heapq.heappush(heap, (head.value, i, head))
    
    while heap:
        val, idx, node = heapq.heappop(heap)
        curr.next = node
        curr = curr.next
        
        if node.next:
            heapq.heappush(heap, (node.next.value, idx, node.next))
    
    return dummy.next


def merge_k_lists_divide_conquer(lists):
    """
    Divide and conquer approach.
    TC: O(n log k), SC: O(log k)
    """
    if not lists:
        return None
    
    def merge_two_lists(l1, l2):
        dummy = ListNode(0)
        curr = dummy
        
        while l1 and l2:
            if l1.value < l2.value:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        
        curr.next = l1 or l2
        return dummy.next
    
    while len(lists) > 1:
        merged = []
        for i in range(0, len(lists), 2):
            l1 = lists[i]
            l2 = lists[i + 1] if i + 1 < len(lists) else None
            merged.append(merge_two_lists(l1, l2))
        lists = merged
    
    return lists[0]


def print_list(head):
    """Helper to print linked list."""
    result = []
    while head:
        result.append(str(head.value))
        head = head.next
    return " -> ".join(result)


# Test cases
if __name__ == "__main__":
    # Create list 1: 1 -> 4 -> 5
    l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next.next = ListNode(5)
    
    # Create list 2: 1 -> 3 -> 4
    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)
    
    # Create list 3: 2 -> 6
    l3 = ListNode(2)
    l3.next = ListNode(6)
    
    result = merge_k_lists_heap([l1, l2, l3])
    print(f"Merged list (heap): {print_list(result)}")
    
    # Recreate lists for divide and conquer test
    l1 = ListNode(1)
    l1.next = ListNode(4)
    l1.next.next = ListNode(5)
    
    l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next.next = ListNode(4)
    
    l3 = ListNode(2)
    l3.next = ListNode(6)
    
    result = merge_k_lists_divide_conquer([l1, l2, l3])
    print(f"Merged list (D&C): {print_list(result)}")
