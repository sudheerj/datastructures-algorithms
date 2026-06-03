package java1.algorithms.tree.bstToGreaterSumTree;

import java1.algorithms.tree.TreeNode;

public class BSTToGreaterSumTree {
    int sum = 0;

    // Recursive DFS(reverse in-orde traversal) TC: O(n) SC: O(h); h: Recursion stack 
    private TreeNode convertBSTToGreaterSumTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        // base case
        if (node == null)
            return;

        // go to larger values
        dfs(node.right);

        // update node value
        sum += node.value;
        node.value = sum;

        // go to smaller values
        dfs(node.left);

    }

    private static String inorder(TreeNode node) {
        if (node == null)
            return "";
        return inorder(node.left) + node.value + " " + inorder(node.right);
    }

    public static void main(String[] args) {
        BSTToGreaterSumTree sol = new BSTToGreaterSumTree();

        // Test 1: [4,1,6,0,2,5,7] → each node replaced by sum of >= nodes
        // Inorder: 0,1,2,4,5,6,7 → GST inorder: 25,25,24,22,18,13,7
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        sol.convertBSTToGreaterSumTree(root1);
        System.out.println("Test 1: " + inorder(root1).trim()); // 25 25 24 22 18 13 7

        // Test 2: [2,1,3] → [5,6,3]
        BSTToGreaterSumTree sol2 = new BSTToGreaterSumTree();
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        sol2.convertBSTToGreaterSumTree(root2);
        System.out.println("Test 2: " + inorder(root2).trim()); // 6 5 3

        // Test 3: single node [5] → [5]
        BSTToGreaterSumTree sol3 = new BSTToGreaterSumTree();
        TreeNode root3 = new TreeNode(5);
        sol3.convertBSTToGreaterSumTree(root3);
        System.out.println("Test 3: " + inorder(root3).trim()); // 5

        // Test 4: [3,2,4,1] → [7,9,4,10]
        BSTToGreaterSumTree sol4 = new BSTToGreaterSumTree();
        TreeNode root4 = new TreeNode(3);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(4);
        root4.left.left = new TreeNode(1);
        sol4.convertBSTToGreaterSumTree(root4);
        System.out.println("Test 4: " + inorder(root4).trim()); // 10 9 7 4

        // Test 5: right-skewed [1,null,2,null,3] → [6,null,5,null,3]
        BSTToGreaterSumTree sol5 = new BSTToGreaterSumTree();
        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);
        sol5.convertBSTToGreaterSumTree(root5);
        System.out.println("Test 5: " + inorder(root5).trim()); // 6 5 3
    }
}
