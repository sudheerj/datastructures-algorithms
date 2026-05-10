/**
 * Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Approach: Find middle (slow/fast), reverse second half, compare.
 * TC: O(n)  SC: O(1)
 */

class Node {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

function build(vals) {
    const dummy = new Node();
    let cur = dummy;
    for (const v of vals) { cur.next = new Node(v); cur = cur.next; }
    return dummy.next;
}

function isPalindrome(head) {
    let slow = head, fast = head;

    // Find middle
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse second half
    let prev = null;
    while (slow) {
        const temp = slow.next;
        slow.next = prev;
        prev = slow;
        slow = temp;
    }

    // Compare
    let left = head, right = prev;
    while (right) {
        if (left.val !== right.val) return false;
        left = left.next;
        right = right.next;
    }

    return true;
}

const testCases = [
    { vals: [1,2,2,1],    expected: true,  label: "even-length palindrome" },
    { vals: [1,2,3,2,1],  expected: true,  label: "odd-length palindrome" },
    { vals: [7],          expected: true,  label: "single node" },
    { vals: [5,5],        expected: true,  label: "two equal nodes" },
    { vals: [1,2],        expected: false, label: "two different nodes" },
    { vals: [1,2,3,4,5],  expected: false, label: "longer non-palindrome" },
];

testCases.forEach(({ vals, expected, label }) => {
    const result = isPalindrome(build(vals));
    const status = result === expected ? "PASS" : "FAIL";
    console.log(`  [${status}] ${label}: [${vals}] → ${result} (expected ${expected})`);
});
