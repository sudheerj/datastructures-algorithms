package java1.algorithms.tree.recoverBST;

import java.util.ArrayList;
import java.util.List;

import java1.algorithms.tree.TreeNode;

public class RecoverBST {
    static TreeNode prev = null;
    static TreeNode first = null;
    static TreeNode second = null;

    // Inorder traversal TC: O(n) SC: O(h)
    public static void recoverTree(TreeNode root) {
        inorder(root);

        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }

    private static void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev != null && prev.value > node.value) {
            if (first == null)
                first = prev;
            second = node;
        }
        prev = node;

        inorder(node.right);
    }

    private static List<Integer> inorderList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        collectInorder(root, list);
        return list;
    }

    private static void collectInorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        collectInorder(node.left, list);
        list.add(node.value);
        collectInorder(node.right, list);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Each test: build swapped BST, recover, verify inorder is sorted
        Object[][] tests = {
                // [1,3,null,null,2]: 1 and 3 are swapped
                { new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null),
                        List.of(1, 2, 3) },
                // [3,1,4,null,null,2]: 3 and 2 are swapped
                { new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null)),
                        List.of(1, 2, 3, 4) },
                // [2,3,1]: 3 and 1 are swapped
                { new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                        List.of(1, 2, 3) },
                // [4,2,6,1,5,3,7]: 5 and 3 are swapped
                { new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(5)),
                        new TreeNode(6, new TreeNode(3), new TreeNode(7))),
                        List.of(1, 2, 3, 4, 5, 6, 7) },
        };

        for (Object[] test : tests) {
            TreeNode root = (TreeNode) test[0];
            List<Integer> expected = (List<Integer>) test[1];
            recoverTree(root);
            List<Integer> result = inorderList(root);
            String status = result.equals(expected) ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
