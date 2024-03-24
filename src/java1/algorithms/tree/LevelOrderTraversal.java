package java1.algorithms.tree;
import java.util.*;

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
                currLevel.add(node.value);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                size--;
            }
            traversal.add(currLevel);
        }

        return traversal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrder(root));
    }
}
