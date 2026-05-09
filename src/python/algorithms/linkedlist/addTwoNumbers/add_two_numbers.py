"""
Add Two Numbers

Two non-empty linked lists represent two non-negative integers stored in
reverse order. Add the two numbers and return the sum as a linked list.

Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: ListNode, l2: ListNode) -> ListNode:
    """
    Iterative approach with carry.
    TC: O(max(m, n)), SC: O(max(m, n))
    """
    dummy = ListNode()
    curr = dummy
    carry = 0

    while l1 or l2 or carry:
        v1 = l1.val if l1 else 0
        v2 = l2.val if l2 else 0

        v = v1 + v2 + carry
        carry = v // 10
        curr.next = ListNode(v % 10)

        curr = curr.next
        l1 = l1.next if l1 else None
        l2 = l2.next if l2 else None

    return dummy.next


# --- helpers ---

def build_list(vals: list[int]) -> ListNode:
    dummy = ListNode()
    curr = dummy
    for v in vals:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next


def list_to_str(head: ListNode) -> str:
    result = []
    while head:
        result.append(str(head.val))
        head = head.next
    return "[" + ", ".join(result) + "]"


if __name__ == "__main__":
    test_cases = [
        ([2, 4, 3],         [5, 6, 4],      "[7, 0, 8]"),           # 342+465=807
        ([0],               [0],             "[0]"),                  # 0+0=0
        ([9,9,9,9,9,9,9],   [9,9,9,9],      "[8, 9, 9, 9, 0, 0, 0, 1]"),  # 9999999+9999
        ([5],               [5],             "[0, 1]"),               # 5+5=10
        ([9, 9],            [1],             "[0, 0, 1]"),            # 99+1=100
    ]

    for l1_vals, l2_vals, expected in test_cases:
        result = list_to_str(add_two_numbers(build_list(l1_vals), build_list(l2_vals)))
        status = "PASS" if result == expected else "FAIL"
        print(f"  [{status}] {l1_vals} + {l2_vals} → {result} (expected {expected})")
