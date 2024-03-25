package java1.algorithms.tree;

public class SubTree {
    //DFS: TC:O(m * n) SC: O(m)
    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null) return false;
        if(root1.value == root2.value && isSametree(root1, root2)) return true;
        boolean isLeftSubtree = isSubtree(root1.left, root2);
        boolean isRightSubtree = isSubtree(root1.right, root2);
        return isLeftSubtree || isRightSubtree;
    }

    private boolean isSametree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.value != root2.value) return false;

        return isSametree(root1.left, root2.left) && isSametree(root1.right, root2.right);
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(4);

        SubTree subtree = new SubTree();
        System.out.println(subtree.isSubtree(root1, root2));
    }
}
