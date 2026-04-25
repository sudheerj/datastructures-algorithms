package java1.algorithms.linkedlist.swapNodePairs;

public class SwapNodePairs {

    private static ListNode swapNodePairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;

        while(curr != null && curr.next !=null) {
            //Save the pointers
            ListNode nextPair = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = nextPair;
            prev.next = second;

            prev = curr;
            curr = nextPair;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Helper to create list from array
        java.util.function.Function<int[], ListNode> createList = arr -> {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            for (int v : arr) {
                curr.next = new ListNode(v);
                curr = curr.next;
            }
            return dummy.next;
        };

        // Helper to print list
        java.util.function.Consumer<ListNode> printList = head -> {
            StringBuilder sb = new StringBuilder();
            while (head != null) {
                sb.append(head.val);
                if (head.next != null) sb.append(" -> ");
                head = head.next;
            }
            System.out.println(sb.toString());
        };

        // Example 1: Even number of nodes
        ListNode head1 = createList.apply(new int[]{1,2,3,4});
        // Expected: 2 -> 1 -> 4 -> 3
        printList.accept(swapNodePairs(head1));

        // Example 2: Odd number of nodes
        ListNode head2 = createList.apply(new int[]{1,2,3,4,5});
        // Expected: 2 -> 1 -> 4 -> 3 -> 5
        printList.accept(swapNodePairs(head2));

        // Example 3: Single node
        ListNode head3 = createList.apply(new int[]{1});
        // Expected: 1
        printList.accept(swapNodePairs(head3));

        // Example 4: Empty list
        ListNode head4 = createList.apply(new int[]{});
        // Expected: (empty)
        printList.accept(swapNodePairs(head4));
    }

}

    class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }