package java1.algorithms.tree.pathSum2;

import java.util.ArrayList;
import java.util.List;

import java1.algorithms.tree.TreeNode;

//DFS: Preorder traversal TC:O(n * h) SC: O(k * h). K is number of valid paths
public class PathSum2 {
    public static void main(String[] args) {
        // Test 1: Normal tree with multiple valid paths
        // 5
        // / \
        // 4 8
        // / / \
        // 11 13 4
        // / \ / \
        // 7 2 5 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        System.out.println("Test 1 (targetSum=22): " + pathSum(root1, 22)); // [[5,4,11,2],[5,8,4,5]]

        // Test 2: Simple tree with no valid path
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println("Test 2 (targetSum=5): " + pathSum(root2, 5)); // []

        // Test 3: Single node matching target
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test 3 (targetSum=1): " + pathSum(root3, 1)); // [[1]]

        // Test 4: Single node not matching target
        System.out.println("Test 4 (targetSum=2): " + pathSum(root3, 2)); // []

        // Test 5: Null tree
        System.out.println("Test 5 (null tree, targetSum=0): " + pathSum(null, 0)); // []

        // Test 6: Tree with negative values
        TreeNode root6 = new TreeNode(-2);
        root6.right = new TreeNode(-3);
        System.out.println("Test 6 (targetSum=-5): " + pathSum(root6, -5)); // [[-2,-3]]

        // Test 7: Multiple leaves, only one path valid (1->2 = 3)
        System.out.println("Test 7 (targetSum=3): " + pathSum(root2, 3)); // [[1,2]]

        // Test 8: All root-to-leaf paths valid
        TreeNode root8 = new TreeNode(1);
        root8.left = new TreeNode(2);
        root8.right = new TreeNode(2);
        System.out.println("Test 8 (targetSum=3): " + pathSum(root8, 3)); // [[1,2],[1,2]]
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathSumList = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>(), pathSumList);
        return pathSumList;
    }

    private static void dfs(TreeNode node, int currentSum, int targetSum, List<Integer> currPath,
            List<List<Integer>> pathSumList) {
        if (node == null)
            return;

        // Add to current path
        currPath.add(node.value);
        currentSum += node.value;

        // Check if its a leaf node and equals to target sum
        if (node.left == null && node.right == null && targetSum == currentSum) {
            pathSumList.add(new ArrayList<>(currPath));
        }

        // Traverse over children
        dfs(node.left, currentSum, targetSum, currPath, pathSumList);
        dfs(node.right, currentSum, targetSum, currPath, pathSumList);

        // Backtrack for different branches
        currPath.remove(currPath.size() - 1);
    }
}
