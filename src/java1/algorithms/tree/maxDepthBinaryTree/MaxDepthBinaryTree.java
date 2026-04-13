package java1.algorithms.tree.maxDepthBinaryTree;

import java.util.*;

import java1.algorithms.tree.TreeNode;

class Pair {
    TreeNode node;
    int depth;

    Pair(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class MaxDepthBinaryTree {

    // Recursive DFS(InOrder traversal):- TC: O(n) SC: O(n)
    private static int maxDepth1(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    // Iterative DFS using two stacks(PreOrder traversal):- TC: O(n) SC: O(n)
    private static int maxDepth2(TreeNode root) {
        if(root == null) return 0;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        int maxDepth = 0;

        while(!stack.isEmpty()) {
            Pair current = stack.pop();
            TreeNode node = current.node;
            int depth = current.depth;
            maxDepth = Math.max(maxDepth, depth);

            if(node.left != null) {
                stack.push(new Pair(node.left, depth+1));
            } 
            if(node.right != null) {
                stack.push(new Pair(node.right, depth+1));
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
            maxDepth++;

            //Traverse the tree by layer
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
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
