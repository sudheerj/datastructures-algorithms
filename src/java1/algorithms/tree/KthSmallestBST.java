package java1.algorithms.tree;

import java.util.*;

public class KthSmallestBST {
    //Iterative Inorder BST: TC: O(n) SC: O(n)
    private int kthSmallest1(TreeNode root, int k){
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0) return root.value;
            root = root.right;
        }
    }

    //Recursive Inorder BST: TC: O(n) SC: O(n)
    private int kthSmallest2(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list.get(k-1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.value);
        inorderTraversal(root.right, list);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        KthSmallestBST bst = new KthSmallestBST();
        System.out.println(bst.kthSmallest1(root, 3));
        System.out.println(bst.kthSmallest2(root, 3));
    }
}
