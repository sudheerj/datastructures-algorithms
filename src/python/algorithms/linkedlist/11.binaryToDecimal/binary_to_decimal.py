"""
Binary to Decimal

Given the head of a singly linked list representing a binary number,
return its decimal equivalent.

Time Complexity: O(n)
Space Complexity: O(1)
"""


class ListNode:
    def __init__(self, value=0):
        self.value = value
        self.next = None


def binary_to_decimal(head):
    """
    Iterative approach using bit shifting.
    TC: O(n), SC: O(1)
    """
    if not head:
        return 0
    
    result = 0
    curr = head
    
    while curr:
        result = (result << 1) | curr.value  # Same as result * 2 + curr.value
        curr = curr.next
    
    return result


def binary_to_decimal_math(head):
    """
    Alternative approach using multiplication.
    TC: O(n), SC: O(1)
    """
    if not head:
        return 0
    
    result = 0
    curr = head
    
    while curr:
        result = result * 2 + curr.value
        curr = curr.next
    
    return result


def print_list(head):
    """Helper to print linked list."""
    result = []
    while head:
        result.append(str(head.value))
        head = head.next
    return " -> ".join(result)


# Test cases
if __name__ == "__main__":
    # Create list: 1 -> 0 -> 1 (binary 101 = decimal 5)
    head1 = ListNode(1)
    head1.next = ListNode(0)
    head1.next.next = ListNode(1)
    
    print(f"Binary list: {print_list(head1)}")
    print(f"Decimal value (bit shift): {binary_to_decimal(head1)}")  # 5
    print(f"Decimal value (math): {binary_to_decimal_math(head1)}")  # 5
    
    # Create list: 1 -> 1 -> 0 -> 1 (binary 1101 = decimal 13)
    head2 = ListNode(1)
    head2.next = ListNode(1)
    head2.next.next = ListNode(0)
    head2.next.next.next = ListNode(1)
    
    print(f"Binary list: {print_list(head2)}")
    print(f"Decimal value: {binary_to_decimal(head2)}")  # 13
    
    # Create list: 1 -> 0 -> 0 -> 0 (binary 1000 = decimal 8)
    head3 = ListNode(1)
    head3.next = ListNode(0)
    head3.next.next = ListNode(0)
    head3.next.next.next = ListNode(0)
    
    print(f"Binary list: {print_list(head3)}")
    print(f"Decimal value: {binary_to_decimal(head3)}")  # 8
