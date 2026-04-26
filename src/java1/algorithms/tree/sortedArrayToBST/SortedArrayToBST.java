package java1.algorithms.tree.sortedArrayToBST;

import java1.algorithms.tree.TreeNode;

public class SortedArrayToBST {
    // DFS divide and conquer TC: O(n) SC: O(log n) for recursion stack & O(n) for output tree
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;
    }

    // Helper: Preorder traversal
    private static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {},
            {0},
            {1, 2},
            {-10, -3, 0, 5, 9},
            {1, 2, 3, 4, 5, 6, 7}
        };
        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i + 1) + ": Input: ");
            printArray(testCases[i]);
            TreeNode bst = sortedArrayToBST(testCases[i]);
            System.out.print("Preorder Output: ");
            preorder(bst);
            System.out.println();
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.print("] ");
    }
}
