"""
Palindrome Linked List

Given the head of a singly linked list, return True if it is a palindrome.

Approach: Find middle (slow/fast), reverse second half, compare.
TC: O(n)  SC: O(1)
"""


class Node:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def build(vals: list[int]) -> Node:
    dummy = Node()
    cur = dummy
    for v in vals:
        cur.next = Node(v)
        cur = cur.next
    return dummy.next


def is_palindrome(head: Node) -> bool:
    slow, fast = head, head

    # Find middle
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    # Reverse second half
    prev = None
    while slow:
        temp = slow.next
        slow.next = prev
        prev = slow
        slow = temp

    # Compare
    left, right = head, prev
    while right:
        if left.val != right.val:
            return False
        left = left.next
        right = right.next

    return True


if __name__ == "__main__":
    test_cases = [
        ([1, 2, 2, 1],    True,  "even-length palindrome"),
        ([1, 2, 3, 2, 1], True,  "odd-length palindrome"),
        ([7],             True,  "single node"),
        ([5, 5],          True,  "two equal nodes"),
        ([1, 2],          False, "two different nodes"),
        ([1, 2, 3, 4, 5], False, "longer non-palindrome"),
    ]

    for vals, expected, label in test_cases:
        result = is_palindrome(build(vals))
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {label}: {vals} → {result} (expected {expected})")
