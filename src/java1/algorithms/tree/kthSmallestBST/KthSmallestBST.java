package java1.algorithms.tree.kthSmallestBST;

import java.util.*;

import java1.algorithms.tree.TreeNode;

public class KthSmallestBST {
    int count = 0;
    int result = -1;

    //Iterative Inorder BST: TC: O(h+k) SC: O(n), h= length of tree and k= number of poped elements from stack
    private int kthSmallest1(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(currNode != null || !stack.empty()) {
            while(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            k--;
            if(k == 0) return currNode.value;
            currNode = currNode.right;
        }
        return -1;
    }

    //Recursive Inorder BST: TC: O(n) SC: O(h)
    private int kthSmallest2(TreeNode root, int k){
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode root, int k) {
        if(root == null) return;

        //Process left subtree
        inorderTraversal(root.left, k);

        //Process current node
        count++;
        if(count == k) {
            result = root.value;
            return;
        }

        //Process right subtree
        inorderTraversal(root.right, k);
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
