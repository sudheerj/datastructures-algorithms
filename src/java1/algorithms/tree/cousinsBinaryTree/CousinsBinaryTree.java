package java1.algorithms.tree.cousinsBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import java1.algorithms.tree.TreeNode;

public class CousinsBinaryTree {
    // BFS level order traversal with siblings and equal checks  TC: O(n) SC: O(n)
    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.value == x)
                    foundX = true;
                if (node.value == y)
                    foundY = true;

                // siblings share the same parent
                if (node.left != null && node.right != null) {
                    int left = node.left.value, right = node.right.value;
                    if ((left == x && right == y) || (left == y && right == x))
                        return false;
                }

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (foundX && foundY)
                return true;
            if (foundX || foundY)
                return false;
        }
        return false;
    }

    // Recursive DFS with depths and parents TC: O(n) SC: O(h)
    public static boolean isCousins2(TreeNode root, int x, int y) {
        int[] depths = { -1, -1 };
        TreeNode[] parents = { null, null };
        dfs(root, null, 0, x, y, depths, parents);
        return depths[0] == depths[1] && parents[0] != parents[1];
    }

    private static void dfs(TreeNode node, TreeNode parent, int depth, int x, int y,
            int[] depths, TreeNode[] parents) {
        if (node == null)
            return;
        if (node.value == x) {
            depths[0] = depth;
            parents[0] = parent;
        }
        if (node.value == y) {
            depths[1] = depth;
            parents[1] = parent;
        }
        dfs(node.left, node, depth + 1, x, y, depths, parents);
        dfs(node.right, node, depth + 1, x, y, depths, parents);
    }

    public static void main(String[] args) {
        // Tree1: [1,2,3,4] (4 is left child of 2)
        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        // Tree2: [1,2,3,null,4,null,5]
        TreeNode t2 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(5)));
        // Tree3: [1,2,3]
        TreeNode t3 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        // Tree4: [1,2,3,4,5,6,7]
        TreeNode t4 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        Object[][] tests = {
                // {root, x, y, expected}
                { t1, 4, 3, false }, // different depths
                { t2, 4, 5, true }, // same depth, different parents
                { t3, 2, 3, false }, // siblings (same parent)
                { t4, 4, 7, true }, // same depth, different parents
                { t4, 4, 5, false }, // siblings (same parent)
                { t4, 4, 6, true }, // same depth, different parents
        };

        for (String label : new String[] { "BFS", "DFS" }) {
            System.out.println("--- " + label + " ---");
            for (Object[] test : tests) {
                TreeNode root = (TreeNode) test[0];
                int x = (int) test[1], y = (int) test[2];
                boolean expected = (boolean) test[3];
                boolean result = label.equals("BFS") ? isCousins(root, x, y) : isCousins2(root, x, y);
                System.out.println("[" + (result == expected ? "PASS" : "FAIL") +
                        "] x=" + x + " y=" + y + " result=" + result + " expected=" + expected);
            }
        }
    }
}
