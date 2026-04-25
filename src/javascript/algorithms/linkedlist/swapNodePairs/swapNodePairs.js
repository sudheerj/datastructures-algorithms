class ListNode {
    constructor(val = 0, next = null) {
        this.val = val;
        this.next = next;
    }
}

function swapNodePairs(head) {
    let dummy = new ListNode(0, head);
    let prev = dummy, curr = head;
    while (curr && curr.next) {
        let nextPair = curr.next.next;
        let second = curr.next;
        second.next = curr;
        curr.next = nextPair;
        prev.next = second;
        prev = curr;
        curr = nextPair;
    }
    return dummy.next;
}

function printList(head) {
    let vals = [];
    while (head) {
        vals.push(head.val);
        head = head.next;
    }
    console.log(vals.join(' -> '));
}

function createList(arr) {
    let dummy = new ListNode();
    let curr = dummy;
    for (let v of arr) {
        curr.next = new ListNode(v);
        curr = curr.next;
    }
    return dummy.next;
}

// Example 1: Even number of nodes
let head1 = createList([1,2,3,4]);
// Expected: 2 -> 1 -> 4 -> 3
printList(swapNodePairs(head1));
// Example 2: Odd number of nodes
let head2 = createList([1,2,3,4,5]);
// Expected: 2 -> 1 -> 4 -> 3 -> 5
printList(swapNodePairs(head2));
// Example 3: Single node
let head3 = createList([1]);
// Expected: 1
printList(swapNodePairs(head3));
// Example 4: Empty list
let head4 = createList([]);
// Expected: (empty)
printList(swapNodePairs(head4));
