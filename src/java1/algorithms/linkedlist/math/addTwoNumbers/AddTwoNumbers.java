package java1.algorithms.linkedlist.math.addTwoNumbers;

import java1.algorithms.linkedlist.Node;

public class AddTwoNumbers {
    // TC: O(max(m, n)) SC: O(max(m, n))
    private static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = l1 != null ? l1.value : 0;
            int v2 = l2 != null ? l2.value : 0;

            // next digit
            int v = v1 + v2 + carry;
            carry = v / 10;
            v = v % 10;
            curr.next = new Node(v);

            // Update pointers
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return dummy.next;
    }

    private static Node buildList(int[] vals) {
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int v : vals) {
            curr.next = new Node(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    private static String listToString(Node head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.value);
            if (head.next != null)
                sb.append(", ");
            head = head.next;
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        // Test 1: 342 + 465 = 807 → [2,4,3] + [5,6,4] = [7,0,8]
        Node result1 = addTwoNumbers(buildList(new int[] { 2, 4, 3 }), buildList(new int[] { 5, 6, 4 }));
        System.out.println(listToString(result1)); // [7, 0, 8]

        // Test 2: 0 + 0 = 0 → [0] + [0] = [0]
        Node result2 = addTwoNumbers(buildList(new int[] { 0 }), buildList(new int[] { 0 }));
        System.out.println(listToString(result2)); // [0]

        // Test 3: 9999999 + 9999 = 10009998 → [9,9,9,9,9,9,9] + [9,9,9,9] =
        // [8,9,9,9,0,0,0,1]
        Node result3 = addTwoNumbers(buildList(new int[] { 9, 9, 9, 9, 9, 9, 9 }), buildList(new int[] { 9, 9, 9, 9 }));
        System.out.println(listToString(result3)); // [8, 9, 9, 9, 0, 0, 0, 1]

        // Test 4: 5 + 5 = 10 → carry into new node
        Node result4 = addTwoNumbers(buildList(new int[] { 5 }), buildList(new int[] { 5 }));
        System.out.println(listToString(result4)); // [0, 1]

        // Test 5: unequal lengths — 99 + 1 = 100
        Node result5 = addTwoNumbers(buildList(new int[] { 9, 9 }), buildList(new int[] { 1 }));
        System.out.println(listToString(result5)); // [0, 0, 1]
    }
}
