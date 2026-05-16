package java1.algorithms.tree.lowestCommonAncestorBT;

import java1.algorithms.tree.TreeNode;

public class LowestCommonAncestorBT {
    //Recursive DFS binary tree(not BST) TC: O(n) SC: O(h)
    private TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        //Base case
        if(root == null || root == p || root == q) return root;

        //search left and right subtrees
        TreeNode left = lowestCommonAncestorBT(root.left, p, q);
        TreeNode right = lowestCommonAncestorBT(root.right, p, q);

        //if both trees are non-null, then root is LCA
        if(left != null && right != null) return root;

        //otherwise return non-null side
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(6);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(10);
        root1.left.right = new TreeNode(1);
        root1.right.left = new TreeNode(2);
        root1.right.right = new TreeNode(4);

        LowestCommonAncestorBT lca = new LowestCommonAncestorBT();

        // --- Binary Tree method (uses node references) ---
        // Test 1: p and q in same subtree
        System.out
                .println("BT Test 1: " + lca.lowestCommonAncestorBT(root1, root1.left.left, root1.left.right).value); // 1 (LCA of 0,2)
        // Test 2: p and q on opposite sides of root
        System.out.println("BT Test 2: " + lca.lowestCommonAncestorBT(root1, root1.left, root1.right).value); // 5 (LCA of 1, 8)
        // Test 3: One node is ancestor of the other
        System.out.println("BT Test 3: " + lca.lowestCommonAncestorBT(root1, root1.right, root1.right.right).value); // 8 (LCA of 8, 9)
        // Test 4: Deepest nodes in right subtree
        System.out.println(
                "BT Test 4: " + lca.lowestCommonAncestorBT(root1, root1.right.left, root1.right.right).value); // 8 (LCA of 7, 9)
        // Test 5: Node with itself
        System.out.println("BT Test 5: " + lca.lowestCommonAncestorBT(root1, root1.left, root1.left).value); // 1 (LCA of 1, 1)
    }
}
