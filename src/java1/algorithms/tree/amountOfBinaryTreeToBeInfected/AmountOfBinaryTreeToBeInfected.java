package java1.algorithms.tree.amountOfBinaryTreeToBeInfected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import java1.algorithms.tree.TreeNode;

public class AmountOfBinaryTreeToBeInfected {
    //Use DFS to convert tree to graph with parent map and finding the start node. BFS is used to do level order traversal TC: O(n) SC: O(n)
    private int amountOfTime(TreeNode root, int start) {

        //Step1: Build parent map and return start node
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode startNode = buildParentMap(root, null, start,parentMap);

        //Step2: Use BFS from start node to find the minimum time for binary tree to be infected.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);

        int minutes = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                if(node.left != null && visited.add(node.left)) {
                    queue.add(node.left);
                }

                if(node.right != null && visited.add(node.right)) {
                    queue.add(node.right);
                }

                TreeNode parent = parentMap.getOrDefault(node, null);
                if(parent != null && visited.add(parent)) {
                    queue.add(parent);
                }
            }

        }

        return minutes;
    }

    private TreeNode buildParentMap(TreeNode node, TreeNode parent, int start, Map<TreeNode, TreeNode> parentMap) {
        if(node == null) return null;

        parentMap.put(node, parent);

        if(node.value == start) {
            return node;
        }

        TreeNode left = buildParentMap(node.left, node, start, parentMap);
        if(left != null) return left;

        return buildParentMap(node.right, node, start, parentMap);
    }
}
