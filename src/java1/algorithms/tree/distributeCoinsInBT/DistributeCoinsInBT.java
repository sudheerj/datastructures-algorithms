package java1.algorithms.tree.distributeCoinsInBT;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import java1.algorithms.tree.TreeNode;

public class DistributeCoinsInBT {
    private int moves = 0;
    //DFS recursion-> Need child info before processing parent using Postorder traversal TC: O(n) SC: O(h)
    private int distributeCoins(TreeNode root) {
        if(root == null) return 0;

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftBalance = dfs(node.left);
        int rightBalance = dfs(node.right);

        moves += Math.abs(leftBalance) + Math.abs(rightBalance);

        return node.value + leftBalance + rightBalance -1;// (coins in subtree - nodes in subtree)
    }

    //Iterative DFS with rever preorder traversal for building sequence and postorder traversal for fetching the moves. TC: O(n) SC: O(n)
    private int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        int moves = 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> postorder = new Stack<>();

        stack.push(root);

        //Build postorder sequence
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postorder.push(node);

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        Map<TreeNode, Integer> balance = new HashMap<>();
        while (!postorder.isEmpty()) {
            TreeNode node = postorder.pop();

            int leftBalance = balance.getOrDefault(node.left, 0);
            int rightBalance = balance.getOrDefault(node.right, 0);

            moves += Math.abs(leftBalance) + Math.abs(rightBalance);

            int currBalance = node.value + leftBalance + rightBalance -1;
            balance.put(node, currBalance);
        }

        return moves;
    }
}
