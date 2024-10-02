package java1.algorithms.tree.levelOrderTraversal;
import java.util.*;

import java1.algorithms.tree.TreeNode;

public class LevelOrderTraversal {
    //BFS: TC: O(n) SC: O(n)
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                if(node != null) {
                    currLevel.add(node.value);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                size--;
            }
            if(currLevel.size() > 0) {
                traversal.add(currLevel);
            }
        }

        return traversal;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(3);

        System.out.println(levelOrder(root1));
        System.out.println(levelOrder(root2));
        System.out.println(levelOrder(null));
    }
}
