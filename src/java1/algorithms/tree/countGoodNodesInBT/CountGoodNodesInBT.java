package java1.algorithms.tree.countGoodNodesInBT;

import java1.algorithms.tree.TreeNode;

public class CountGoodNodesInBT {
    //Preorder traversal with maximum seen so far TC: O(n) SC: O(h)
    private int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if(node == null) return 0;

        int count = 0;
        if(node.value >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(maxSoFar, node.value);

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}
