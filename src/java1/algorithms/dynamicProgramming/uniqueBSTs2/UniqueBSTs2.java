package java1.algorithms.dynamicProgramming.uniqueBSTs2;

import java.util.ArrayList;
import java.util.List;

import java1.algorithms.dynamicProgramming.TreeNode;

public class UniqueBSTs2 {
    private static List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        List<TreeNode>[][] dp = new ArrayList[n + 1][n + 1];
        return generate(1, n, dp);
    }

    private static List<TreeNode> generate(int left, int right, List<TreeNode>[][] dp) {
        if(left > right) {
            List<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }

        if(dp[left][right] != null) {
            return dp[left][right];
        }

        List<TreeNode> result = new ArrayList<>();

        for(int root = left; root<=right; root++) {
            for(TreeNode leftTree: generate(left, root-1, dp)) {
                for(TreeNode rightTree: generate(root+1, right, dp)) {
                    TreeNode rootNode = new TreeNode(root, leftTree, rightTree);
                    result.add(rootNode);
                }
            }
        }
        dp[left][right] = result;
        return result;
    }

    private static void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null ");
            return;
        }
        sb.append(root.value).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public static void main(String[] args) {
        int[] testCases = {0, 1, 2, 3};
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.println("Test case " + (i + 1) + ": n = " + n);
            List<TreeNode> trees = generateTrees(n);
            System.out.println("Total unique BSTs: " + trees.size());
            int idx = 1;
            for (TreeNode root : trees) {
                StringBuilder sb = new StringBuilder();
                preorder(root, sb);
                System.out.println("Tree " + (idx++) + ": " + sb.toString().trim());
            }
        }
    }
}
