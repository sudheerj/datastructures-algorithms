package java1.algorithms.tree.binaryTreeCameras;

import java1.algorithms.tree.TreeNode;

public class BinaryTreeCameras {
    private int cameras = 0;
    private final int HAS_CAMERA = 0;
    private final int COVERED = 1;
    private final int NOT_COVERED = 2;

    //Greedy 3 states(bottom -> Top approach) TC: O(n) SC: O(h) h = recursion stack space
    private int minCameraCover1(TreeNode root) {
        if(dfs(root) == NOT_COVERED) {
            cameras++;
        }
        return cameras;
    }

    private int dfs(TreeNode node) {
        if(node == null) {
            return COVERED;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        //case1: if any child is not covered, the node should have camera
        if(left == NOT_COVERED || right == NOT_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        //case2: If any child is having camera, the node is going to be covered
        if(left == HAS_CAMERA || right == HAS_CAMERA) {
            return COVERED;
        } 

        //otherwise -> Not covered
        return NOT_COVERED;
    }

    //Tree DP TC: O(n) SC: O(h)
    private int minCameraCover2(TreeNode root) {
        int[] minCameras = dfs1(root);
        return Math.min(minCameras[0], minCameras[1]); //root cannot be not covered
    }

    private int[] dfs1(TreeNode node) {
        if(node == null) {
            return new int[]{0, 0, 0};// or INF for first indice to indicate impossible to have camera for null node
        }

        int[] left = dfs1(node.left);
        int[] right = dfs1(node.right);

        //case1: if a node is placed with a camera, childs can have any state
        int hasCamera = 1 + Math.min(left[0], Math.min(left[1], left[2])) + Math.min(right[0], Math.min(right[1], right[2]));

        //case2: if a node is covered, atleast one child should have camera
        int covered = Math.min(left[0] + Math.min(right[0], right[1]), right[0] + Math.min(left[0], right[1]));

        //case 3: If a node is not covered, both childs should be covered without a camera
        int notCovered = left[1] + right[1];

        return new int[]{hasCamera, covered, notCovered};
    }


}
