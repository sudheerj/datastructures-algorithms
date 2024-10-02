package java1.algorithms.tree.buildTree;

import java.util.Arrays;

import java1.algorithms.tree.TreeNode;

public class BuildTree {
    //TC: O(n) SC: O(n)
    private TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length), Arrays.copyOfRange(inorder, mid+1, inorder.length));
        
        return root;
    }

    private static void printTree(TreeNode root) {
        if(root == null) return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,7}, inorder = {4,2,5,1,6,3,7};
        BuildTree tree = new BuildTree();
        printTree(tree.buildTree(preorder, inorder));
    }
}
