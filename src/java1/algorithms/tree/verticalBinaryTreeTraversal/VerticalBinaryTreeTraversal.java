package java1.algorithms.tree.verticalBinaryTreeTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import java1.algorithms.tree.TreeNode;

public class VerticalBinaryTreeTraversal {
    static class Pair {
        TreeNode node;
        int row, col;

        public Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    // BFS + Map => TC: O(n log n) SC: O(n)
    private static List<List<Integer>> verticalBinaryTreeTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Add column -> list of row and node values
        Map<Integer, List<int[]>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int row = pair.row, col = pair.col;

            // store row & value
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[] { row, node.value });

            // left child
            if (node.left != null) {
                queue.offer(new Pair(node.left, row + 1, col - 1));
            }

            // right child
            if (node.right != null) {
                queue.offer(new Pair(node.right, row + 1, col + 1));
            }
        }

        // process each column
        for (List<int[]> list : map.values()) {
            // sort by row, then value
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }

                return a[0] - b[0];
            });

            List<Integer> colsList = new ArrayList<>();
            for (int[] arr : list) {
                colsList.add(arr[1]);
            }
            result.add(colsList);
        }

        return result;
    }

    private static TreeNode build(Integer... vals) {
        if (vals.length == 0 || vals[0] == null)
            return null;
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < vals.length) {
            TreeNode node = q.poll();
            if (i < vals.length && vals[i] != null) {
                node.left = new TreeNode(vals[i]);
                q.offer(node.left);
            }
            i++;
            if (i < vals.length && vals[i] != null) {
                node.right = new TreeNode(vals[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // [3,9,20,null,null,15,7] -> [[9],[3,15],[20],[7]]
        System.out.println(verticalBinaryTreeTraversal(build(3, 9, 20, null, null, 15, 7))
                + " (expected [[9], [3, 15], [20], [7]])");

        // [1,2,3,4,5,6,7] -> [[4],[2],[1,5,6],[3],[7]]
        System.out.println(verticalBinaryTreeTraversal(build(1, 2, 3, 4, 5, 6, 7))
                + " (expected [[4], [2], [1, 5, 6], [3], [7]])");

        // [1,2,3,4,6,5,7] -> same-row ties sorted by value -> [[4],[2],[1,5,6],[3],[7]]
        System.out.println(verticalBinaryTreeTraversal(build(1, 2, 3, 4, 6, 5, 7))
                + " (expected [[4], [2], [1, 5, 6], [3], [7]])");

        // single node -> [[1]]
        System.out.println(verticalBinaryTreeTraversal(build(1))
                + " (expected [[1]])");

        // null -> []
        System.out.println(verticalBinaryTreeTraversal(null)
                + " (expected [])");
    }
}
