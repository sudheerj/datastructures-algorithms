package java1.algorithms.tree.maxDepthBinaryTree;

import java.util.*;

import java1.algorithms.tree.TreeNode;

public class MaxDepthBinaryTree {

    // Recursive DFS(InOrder traversal):- TC: O(n) SC: O(n)
    private static int maxDepth1(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    // Iterative DFS using two stacks(PreOrder traversal):- TC: O(n) SC: O(n)
    private static int maxDepth2(TreeNode root) {
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        int maxDepth = 0;

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = depth.pop();
            maxDepth = Math.max(maxDepth, temp);

            if(node.left != null) {
                stack.push(node.left);
                depth.push(temp + 1);
            } 
            if(node.right != null) {
                stack.push(node.right);
                depth.push(temp + 1);
            }
        }

        return maxDepth;
    }

    //BFS:- TC: O(n) SC: O(n)
    private static int maxDepth3(TreeNode root) {
        if(root == null) return 0;
        int maxDepth = 0;

        //Queue is used to keep all the nodes to be traversed
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            //Traverse the tree by layer
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            maxDepth++;
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(maxDepth1(root));
        System.out.println(maxDepth2(root));
        System.out.println(maxDepth3(root));
    }
}
