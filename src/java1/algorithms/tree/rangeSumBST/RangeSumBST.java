package java1.algorithms.tree.rangeSumBST;

import java1.algorithms.dynamicProgramming.TreeNode;

public class RangeSumBST {
    //Recursive DFS TC: O(n) SC: O(n)
    private static int rangeSum(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        //current value larger -> go to left subtree
        if(root.value > high) {
            return rangeSum(root.left, low, high);
        }
        //current value smaller -> go to right subtree
        if(root.value < low) {
            return rangeSum(root.right, low, high);
        }

        //Add current value and search both subtrees
        return root.value + rangeSum(root.left, low, high) + rangeSum(root.right, low, high);
    }
    public static void main(String[] args) {
        // Test 1: [10,5,15,3,7,null,18], low=7, high=15 → 32
        //         10
        //        /  \
        //       5   15
        //      / \    \
        //     3   7   18
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);
        System.out.println("Test 1: " + rangeSum(root1, 7, 15)); // 32 (7+10+15)

        // Test 2: [10,5,15,3,7,13,18,1,null,6], low=6, high=10 → 23
        //         10
        //        /  \
        //       5   15
        //      / \  / \
        //     3   7 13 18
        //    /   /
        //   1   6
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(18);
        root2.left.left.left = new TreeNode(1);
        root2.left.right.left = new TreeNode(6);
        System.out.println("Test 2: " + rangeSum(root2, 6, 10)); // 23 (6+7+10)

        // Test 3: Single node within range
        TreeNode root3 = new TreeNode(5);
        System.out.println("Test 3: " + rangeSum(root3, 1, 10)); // 5

        // Test 4: Single node outside range
        TreeNode root4 = new TreeNode(5);
        System.out.println("Test 4: " + rangeSum(root4, 6, 10)); // 0

        // Test 5: All nodes within range
        TreeNode root5 = new TreeNode(10);
        root5.left = new TreeNode(5);
        root5.right = new TreeNode(15);
        System.out.println("Test 5: " + rangeSum(root5, 1, 20)); // 30 (5+10+15)
    }
}
