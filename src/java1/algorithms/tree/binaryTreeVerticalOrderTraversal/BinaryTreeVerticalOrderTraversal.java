package java1.algorithms.tree.binaryTreeVerticalOrderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import java1.algorithms.tree.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    //TC: BFS -> O(n) SC: Queue -> O(n) + Map -> O(n) ~= O(n)
    private static List<List<Integer>> binaryTreeVerticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }       

        //Add column -> List of node values
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //BFS queue
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minCol = 0, maxCol = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            TreeNode node = current.node;
            int col = current.col;

            //Add node value to its column
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.value);

            //track min/max columns
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            //left child -> col - 1
            if(node.left !=null) {
                queue.offer(new Pair(node.left, col-1));
            }

            //right child -> col + 1
            if(node.right != null) {
                queue.offer(new Pair(node.right, col+1));
            }

        }

        for(int i=minCol; i<=maxCol; i++) {
            result.add(map.get(i));
        }

        return result;
    }

    private static TreeNode build(Integer... vals) {
        if (vals.length == 0 || vals[0] == null) return null;
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
        System.out.println(binaryTreeVerticalOrderTraversal(build(3, 9, 20, null, null, 15, 7))
            + " (expected [[9], [3, 15], [20], [7]])");

        // [3,9,8,4,0,1,7] -> [[4],[9],[3,0,1],[8],[7]]
        System.out.println(binaryTreeVerticalOrderTraversal(build(3, 9, 8, 4, 0, 1, 7))
            + " (expected [[4], [9], [3, 0, 1], [8], [7]])");

        // single node -> [[1]]
        System.out.println(binaryTreeVerticalOrderTraversal(build(1))
            + " (expected [[1]])");

        // null -> []
        System.out.println(binaryTreeVerticalOrderTraversal(null)
            + " (expected [])");

        // [1,2,3] -> [[2],[1],[3]]
        System.out.println(binaryTreeVerticalOrderTraversal(build(1, 2, 3))
            + " (expected [[2], [1], [3]])");
    }
}
