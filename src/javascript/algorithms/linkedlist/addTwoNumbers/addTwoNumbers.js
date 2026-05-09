/**
 * Add Two Numbers
 *
 * Two non-empty linked lists represent two non-negative integers stored in
 * reverse order. Add the two numbers and return the sum as a linked list.
 *
 * TC: O(max(m, n))
 * SC: O(max(m, n))
 */

class ListNode {
  constructor(val = 0, next = null) {
    this.val = val;
    this.next = next;
  }
}

function addTwoNumbers(l1, l2) {
  const dummy = new ListNode();
  let curr = dummy;
  let carry = 0;

  while (l1 || l2 || carry) {
    const v1 = l1 ? l1.val : 0;
    const v2 = l2 ? l2.val : 0;

    const v = v1 + v2 + carry;
    carry = Math.floor(v / 10);
    curr.next = new ListNode(v % 10);

    curr = curr.next;
    l1 = l1 ? l1.next : null;
    l2 = l2 ? l2.next : null;
  }

  return dummy.next;
}

// --- helpers ---

function buildList(vals) {
  const dummy = new ListNode();
  let curr = dummy;
  for (const v of vals) {
    curr.next = new ListNode(v);
    curr = curr.next;
  }
  return dummy.next;
}

function listToStr(head) {
  const result = [];
  while (head) {
    result.push(head.val);
    head = head.next;
  }
  return `[${result.join(", ")}]`;
}

const testCases = [
  { l1: [2, 4, 3], l2: [5, 6, 4], expected: "[7, 0, 8]" }, // 342+465=807
  { l1: [0], l2: [0], expected: "[0]" }, // 0+0=0
  {
    l1: [9, 9, 9, 9, 9, 9, 9],
    l2: [9, 9, 9, 9],
    expected: "[8, 9, 9, 9, 0, 0, 0, 1]",
  }, // 9999999+9999
  { l1: [5], l2: [5], expected: "[0, 1]" }, // 5+5=10
  { l1: [9, 9], l2: [1], expected: "[0, 0, 1]" }, // 99+1=100
];

testCases.forEach(({ l1, l2, expected }) => {
  const result = listToStr(addTwoNumbers(buildList(l1), buildList(l2)));
  const status = result === expected ? "PASS" : "FAIL";
  console.log(
    `  [${status}] ${JSON.stringify(l1)} + ${JSON.stringify(l2)} → ${result} (expected ${expected})`,
  );
});
