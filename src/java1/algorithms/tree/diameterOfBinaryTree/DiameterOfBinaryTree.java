package java1.algorithms.tree.diameterOfBinaryTree;

import java1.algorithms.tree.TreeNode;

public class DiameterOfBinaryTree {
    static int diameter = 0;

    // Recursive DFS TC: O(n) SC: O(h)
    private static int diameterBT(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private static int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Test 1: [1,2,3,4,5] — diameter passes through root
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        // Longest path: 4→2→1→3 or 5→2→1→3 = 3 edges
        diameter = 0;
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test 1: " + diameterBT(root1)); // 3

        // Test 2: [1,2] — single edge
        diameter = 0;
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        System.out.println("Test 2: " + diameterBT(root2)); // 1

        // Test 3: Single node — no edges
        diameter = 0;
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3: " + diameterBT(root3)); // 0

        // Test 4: Right-skewed [1,null,2,null,3,null,4] — diameter is entire path
        diameter = 0;
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);
        System.out.println("Test 4: " + diameterBT(root4)); // 3

        // Test 5: Diameter does NOT pass through root
        //   1
        //  /
        //  2
        // / \
        // 3 4
        // / \
        // 5 6
        // Longest path: 5→3→2→4→6 = 4 edges
        diameter = 0;
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.left.left = new TreeNode(3);
        root5.left.right = new TreeNode(4);
        root5.left.left.left = new TreeNode(5);
        root5.left.right.right = new TreeNode(6);
        System.out.println("Test 5: " + diameterBT(root5)); // 4
    }
}
