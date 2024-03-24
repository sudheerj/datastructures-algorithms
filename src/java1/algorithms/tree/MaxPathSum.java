package java1.algorithms.tree;

public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;

    private static int maxPathSumm(TreeNode root) {
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
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSumm(root));
    }
}
