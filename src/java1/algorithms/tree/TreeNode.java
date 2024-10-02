package java1.algorithms.tree;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
