package java1.algorithms.tree.kthSmallestBST;

import java.util.*;

import java1.algorithms.tree.TreeNode;

public class KthSmallestBST {

    //Iterative Inorder BST: TC: O(n) SC: O(n)
    private int kthSmallest1(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(currNode != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0) return root.value;
            root = root.right;
        }
        return 0;
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
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        KthSmallestBST bst = new KthSmallestBST();
        System.out.println(bst.kthSmallest1(root1, 3));
        System.out.println(bst.kthSmallest2(root1, 3));

        System.out.println(bst.kthSmallest1(root2, 2));
        System.out.println(bst.kthSmallest2(root2, 2));
    }
}
