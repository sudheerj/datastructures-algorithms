package java1.algorithms.tree.pathSum;

import java1.algorithms.tree.TreeNode;

public class PathSum {
    public static void main(String[] args) {
        // Test 1: Normal tree with valid path sum
        //       5
        //      / \
        //     4   8
        //    /   / \
        //   11  13  4
        //  / \       \
        // 7   2       1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.right = new TreeNode(1);
        System.out.println("Test 1 (targetSum=22): " + hasPathSum(root1, 22)); // true (5->4->11->2)

        // Test 2: Simple tree with no valid path
        //   1
        //  / \
        // 2   3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("Test 2 (targetSum=5): " + hasPathSum(root2, 5)); // false

        // Test 3: Single node matching target
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3 (targetSum=1): " + hasPathSum(root3, 1)); // true

        // Test 4: Single node not matching target
        System.out.println("Test 4 (targetSum=2): " + hasPathSum(root3, 2)); // false

        // Test 5: Null tree
        System.out.println("Test 5 (null tree, targetSum=0): " + hasPathSum(null, 0)); // false

        // Test 6: Tree with negative values
        //    -2
        //      \
        //      -3
        TreeNode root6 = new TreeNode(-2);
        root6.right = new TreeNode(-3);
        System.out.println("Test 6 (targetSum=-5): " + hasPathSum(root6, -5)); // true

        // Test 7: Path sum equals 0
        //    1
        //   /
        //  -1
        TreeNode root7 = new TreeNode(1);
        root7.left = new TreeNode(-1);
        System.out.println("Test 7 (targetSum=0): " + hasPathSum(root7, 0)); // true

        // Test 8: Left-only path valid, right path invalid
        //   1
        //  / \
        // 2   3
        System.out.println("Test 8 (targetSum=3): " + hasPathSum(root2, 3)); // true (1->2)
        System.out.println("Test 9 (targetSum=4): " + hasPathSum(root2, 4)); // true (1->3)
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private static boolean dfs(TreeNode node, int currSum, int targetSum) {
        if(node == null) {
            return false;
        }

        currSum += node.value;
        if(node.left == null && node.right == null) {
            return targetSum == currSum;
        }

        return dfs(node.left, currSum, targetSum) || dfs(node.right, currSum, targetSum);
    }
}
 