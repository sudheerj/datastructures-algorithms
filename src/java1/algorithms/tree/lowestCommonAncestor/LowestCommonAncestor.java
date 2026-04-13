package java1.algorithms.tree.lowestCommonAncestor;

import java1.algorithms.tree.TreeNode;

public class LowestCommonAncestor {

    //Binary Tree(Not BST) TC: O(n) SC: O(h)

    private TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }

    //BST TC: O(n) SC: O(h)
    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(p.value < root.value && q.value < root.value) {
            return lowestCommonAncestor2(root.left, p, q);
        }
        if(p.value > root.value  && q.value > root.value) {
            return lowestCommonAncestor2(root.right, p, q);
        }
        return root;
    }
    public static void main(String[] args) {
        //       5
        //      / \
        //     1   8
        //    / \ / \
        //   0  2 7  9
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        LowestCommonAncestor lca = new LowestCommonAncestor();

        // --- Binary Tree method (uses node references) ---
        // Test 1: p and q in same subtree
        System.out.println("BT Test 1: " + lca.lowestCommonAncestor1(root1, root1.left.left, root1.left.right).value); // 1 (LCA of 0,2)

        // Test 2: p and q on opposite sides of root
        System.out.println("BT Test 2: " + lca.lowestCommonAncestor1(root1, root1.left, root1.right).value); // 5 (LCA of 1,8)

        // Test 3: One node is ancestor of the other
        System.out.println("BT Test 3: " + lca.lowestCommonAncestor1(root1, root1.right, root1.right.right).value); // 8 (LCA of 8,9)

        // Test 4: Deepest nodes in right subtree
        System.out.println("BT Test 4: " + lca.lowestCommonAncestor1(root1, root1.right.left, root1.right.right).value); // 8 (LCA of 7,9)

        // Test 5: Node with itself
        System.out.println("BT Test 5: " + lca.lowestCommonAncestor1(root1, root1.left, root1.left).value); // 1 (LCA of 1,1)

        // --- BST method (uses value comparison) ---
        // Test 6: Nodes in left subtree
        System.out.println("BST Test 6: " + lca.lowestCommonAncestor2(root1, new TreeNode(0), new TreeNode(2)).value); // 1

        // Test 7: Nodes on opposite sides
        System.out.println("BST Test 7: " + lca.lowestCommonAncestor2(root1, new TreeNode(1), new TreeNode(8)).value); // 5

        // Test 8: One node is ancestor
        System.out.println("BST Test 8: " + lca.lowestCommonAncestor2(root1, new TreeNode(8), new TreeNode(9)).value); // 8

        // Test 9: Nodes in right subtree
        System.out.println("BST Test 9: " + lca.lowestCommonAncestor2(root1, new TreeNode(7), new TreeNode(9)).value); // 8

        // Test 10: Root is the LCA
        System.out.println("BST Test 10: " + lca.lowestCommonAncestor2(root1, new TreeNode(0), new TreeNode(9)).value); // 5
    }
}
