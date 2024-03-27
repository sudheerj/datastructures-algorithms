package java1.algorithms.tree;

public class LowestCommonAncestor {

    // TC: O(h) SC: O(1)
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while(curr != null) {
            if(curr.value > q.value) {
                curr = curr.left;
            } else if(curr.value < p.value) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println(lca.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(2)).value);
    }
}
