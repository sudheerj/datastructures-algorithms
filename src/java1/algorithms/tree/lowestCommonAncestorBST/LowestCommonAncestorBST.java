package java1.algorithms.tree.lowestCommonAncestorBST;

import java1.algorithms.tree.TreeNode;

public class LowestCommonAncestorBST {

    //BST iterative TC: O(h) SC: O(1)
    private TreeNode lowestCommonAncestorBST1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while(curr != null) {
            if(p.value < curr.value && q.value < curr.value) {
                curr = curr.left;
            }else if(p.value > curr.value && q.value > curr.value) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }
    
    // Recursive BST TC: O(h) SC: O(h)
    private TreeNode lowestCommonAncestorBST2(TreeNode root, TreeNode p, TreeNode q) {
        //both nodes are in the left subtree
        if (p.value < root.value && q.value < root.value) {
            return lowestCommonAncestorBST2(root.left, p, q);
        //both nodes are in the right subtree
        } else if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestorBST2(root.right, p, q);
        } else {
            // split point => current node is LCA
            return root;
        }
    }

    public static void main(String[] args) {
        // 5
        // / \
        // 1 8
        // / \ / \
        // 0 2 7 9
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        LowestCommonAncestorBST lca = new LowestCommonAncestorBST();

        // --- BST method (uses value comparison) ---
        // Test 6: Nodes in left subtree
        System.out.println("BST Test 6: " + lca.lowestCommonAncestorBST1(root1, new TreeNode(0), new TreeNode(2)).value); // 1
        System.out.println("BST Test 6: " + lca.lowestCommonAncestorBST2(root1, new TreeNode(0), new TreeNode(2)).value); // 1
        // Test 7: Nodes on opposite sides
        System.out.println("BST Test 7: " + lca.lowestCommonAncestorBST1(root1, new TreeNode(1), new TreeNode(8)).value); // 5
        System.out.println("BST Test 7: " + lca.lowestCommonAncestorBST2(root1, new TreeNode(1), new TreeNode(8)).value); // 5
        // Test 8: One node is ancestor
        System.out.println("BST Test 8: " + lca.lowestCommonAncestorBST1(root1, new TreeNode(8), new TreeNode(9)).value); // 8
        System.out.println("BST Test 8: " + lca.lowestCommonAncestorBST2(root1, new TreeNode(8), new TreeNode(9)).value); // 8
        // Test 9: Nodes in right subtree
        System.out.println("BST Test 9: " + lca.lowestCommonAncestorBST1(root1, new TreeNode(7), new TreeNode(9)).value); // 8
        System.out.println("BST Test 9: " + lca.lowestCommonAncestorBST2(root1, new TreeNode(7), new TreeNode(9)).value); // 8

        // Test 10: Root is the LCA
        System.out.println("BST Test 10: " + lca.lowestCommonAncestorBST1(root1, new TreeNode(0), new TreeNode(9)).value); // 5
        System.out.println("BST Test 10: " + lca.lowestCommonAncestorBST2(root1, new TreeNode(0), new TreeNode(9)).value); // 5
    }
}
