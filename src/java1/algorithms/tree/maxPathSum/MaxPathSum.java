package java1.algorithms.tree.maxPathSum;

import java1.algorithms.tree.TreeNode;

public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if(node == null) return 0;
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        //Max path sum with split
        maxSum = Math.max(maxSum, node.value + leftMax + rightMax);
        //Max path sum without split
        return node.value + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(-20);
        root2.left = new TreeNode(10);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(10);
        root2.right.left.left = new TreeNode(-10);

        System.out.println(maxPathSum(root1));
        System.out.println(maxPathSum(root2));
    }
}
