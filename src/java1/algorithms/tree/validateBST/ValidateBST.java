package java1.algorithms.tree.validateBST;

import java1.algorithms.tree.TreeNode;

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
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        ValidateBST bst = new ValidateBST();
        System.out.println(bst.isValidBST(root1));
        System.out.println(bst.isValidBST(root2));

    }
}
