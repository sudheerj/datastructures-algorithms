package java1.algorithms.tree;

public class InvertTree {

    //TC: O(n) SC: O(n)
    private static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode temp = root.left;
        root.left =  root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private static void printTree(TreeNode root) {
        if(root == null) return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printTree(root);
        System.out.println("\n Inverted tree:");
        printTree(invertTree(root));
    }
}
