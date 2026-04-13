package java1.algorithms.tree.buildTree;

import java.util.HashMap;
import java.util.Map;

import java1.algorithms.tree.TreeNode;

public class BuildTree {
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    
    //TC: O(n) SC: O(n)
    private TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        //Build value-> index map
        for(int i=0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;

        //Get root from preorder
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        //Get split position in O(1)
        int inIndex = inorderMap.get(rootVal);

        //Build left and right subtrees
        root.left = dfs(preorder, inStart, inIndex-1);
        root.right = dfs(preorder, inIndex+1, inEnd);

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
