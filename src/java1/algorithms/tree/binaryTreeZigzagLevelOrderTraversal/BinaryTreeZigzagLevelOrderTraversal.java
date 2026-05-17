package java1.algorithms.tree.binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java1.algorithms.tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    //BFS TC:O(n) SC: O(n)
    private static List<List<Integer>> binaryTreeZigzagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Integer[] level = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int index = result.size() % 2 == 0 ? i : size - i - 1;
                level[index] = node.value;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(Arrays.asList(level));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test 1: Full 3-level tree
        //   1
        // /  \
        // 2    3
        // / \ / \
        // 4 5 6 7
        // Expected: [[1],[3,2],[4,5,6,7]]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1: " + binaryTreeZigzagLevelOrderTraversal(root1));

        // Test 2: Single node
        // Expected: [[3]]
        TreeNode root2 = new TreeNode(3);
        System.out.println("Test 2: " + binaryTreeZigzagLevelOrderTraversal(root2));

        // Test 3: null root
        // Expected: []
        System.out.println("Test 3: " + binaryTreeZigzagLevelOrderTraversal(null));

        // Test 4: Left-skewed tree [1,2,null,3]
        // 1
        // /
        // 2
        // \
        // 3
        // Expected: [[1],[2],[3]]
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.right = new TreeNode(3);
        System.out.println("Test 4: " + binaryTreeZigzagLevelOrderTraversal(root4));

        // Test 5: 4-level tree — zigzag pattern clearly visible
        //  1
        // / \
        // 2 3
        // / \
        // 4 5
        // / \
        // 6 7
        // Expected: [[1],[3,2],[4,5],[7,6]]
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.right.right = new TreeNode(5);
        root5.left.left.left = new TreeNode(6);
        root5.left.left.right = new TreeNode(7);
        System.out.println("Test 5: " + binaryTreeZigzagLevelOrderTraversal(root5));
    }
}
