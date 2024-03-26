package java1.algorithms.tree;

public class ValidateBST {

    // DFS: TC:O(n) SC: O(n)
    private boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int min, int max) {
        if(node == null) return true;

        if(!(min < node.value && node.value < max)) return false;

        return dfs(node.left, min, node.value) && dfs(node.right, node.value, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        ValidateBST bst = new ValidateBST();
        System.out.println(bst.isValidBST(root));

    }
}
