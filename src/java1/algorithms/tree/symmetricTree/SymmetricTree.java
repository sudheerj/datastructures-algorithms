package java1.algorithms.tree.symmetricTree;

import java.util.LinkedList;
import java.util.Queue;

import java1.algorithms.tree.TreeNode;

public class SymmetricTree {
    //DFS Recursion TC: O(n) SC: O(h)
    private boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;

        if(left == null || right == null) return false;

        if(left.value != right.value) return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    //Iterative BFS TC:O(n) SC: O(n)
    private boolean isMirror2(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //Both null => so far symmetric
            if(left == null && right == null) {
                continue;
            }

            //if any node is null or not equal, tree is not symmetric
            if(left == null || right == null || left.value != right.value) {
                return false;
            }

            //Add mirror children
            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }
    }
}
