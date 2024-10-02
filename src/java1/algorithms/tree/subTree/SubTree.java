package java1.algorithms.tree.subTree;

import java1.algorithms.tree.TreeNode;

public class SubTree {

    //DFS: TC:O(m * n) SC: O(m)
    private boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        return isSametree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSametree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        if(root1 != null && root2 != null && root1.value == root2.value) {
            return isSametree(root1.left, root2.left) && isSametree(root1.right, root2.right);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.right.right.left = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(6);

        SubTree subtree = new SubTree();
        System.out.println(subtree.isSubtree(root1, root2));
        System.out.println(subtree.isSubtree(root1, root3));
    }
}
