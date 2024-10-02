package java1.algorithms.tree.lowestCommonAncestor;

import java1.algorithms.tree.TreeNode;

public class LowestCommonAncestor {

    // TC: O(h) SC: O(1)
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currNode = root;

        while(currNode != null) {
            if(currNode.value > p.value && currNode.value > q.value) {
                currNode = currNode.left;
            } else if(currNode.value < p.value && currNode.value < q.value) {
                currNode = currNode.right;
            } else {
                return currNode;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println(lca.lowestCommonAncestor(root1, new TreeNode(0), new TreeNode(2)).value);
        System.out.println(lca.lowestCommonAncestor(root1, new TreeNode(8), new TreeNode(9)).value);
    }
}
