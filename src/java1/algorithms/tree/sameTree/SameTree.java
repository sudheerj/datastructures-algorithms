package java1.algorithms.tree.sameTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java1.algorithms.tree.TreeNode;

public class SameTree {
    // Recursive DFS: TC: O(n) SC: O(h)
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.value != q.value)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Iterative DFS: TC:O(n) SC: O(h)
    private static boolean isSameTree1(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] { p, q });

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode node1 = nodes[0], node2 = nodes[1];

            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.value != node2.value)
                return false;

            stack.push(new TreeNode[] { node1.left, node2.left });
            stack.push(new TreeNode[] { node1.right, node2.right });
        }

        return true;
    }

    // BFS: TC: O(n) SC: O(w) w- width of binary tree
    private static boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.value != node2.value)
                return false;

            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);

        // Test 3: Different structure — [1,2] vs [1,null,2]
        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        TreeNode root6 = new TreeNode(1);
        root6.right = new TreeNode(2);

        // Test 4: Single node — same value
        TreeNode root7 = new TreeNode(5);
        TreeNode root8 = new TreeNode(5);

        // Test 5: Single node — different values
        TreeNode root9 = new TreeNode(1);
        TreeNode root10 = new TreeNode(2);

        System.out.println("=== isSameTree (Recursive DFS) ===");
        System.out.println(isSameTree(root1, root2)); // true
        System.out.println(isSameTree(root3, root4)); // false
        System.out.println(isSameTree(root5, root6)); // false
        System.out.println(isSameTree(null, null)); // true
        System.out.println(isSameTree(root1, null)); // false
        System.out.println(isSameTree(root7, root8)); // true
        System.out.println(isSameTree(root9, root10)); // false

        System.out.println("\n=== isSameTree1 (Iterative DFS) ===");
        System.out.println(isSameTree1(root1, root2)); // true
        System.out.println(isSameTree1(root3, root4)); // false
        System.out.println(isSameTree1(root5, root6)); // false
        System.out.println(isSameTree1(null, null)); // true
        System.out.println(isSameTree1(root1, null)); // false
        System.out.println(isSameTree1(root7, root8)); // true
        System.out.println(isSameTree1(root9, root10)); // false

        System.out.println("\n=== isSameTree2 (BFS) ===");
        System.out.println(isSameTree2(root1, root2)); // true
        System.out.println(isSameTree2(root3, root4)); // false
        System.out.println(isSameTree2(root5, root6)); // false
        System.out.println(isSameTree2(null, null)); // true
        System.out.println(isSameTree2(root1, null)); // false
        System.out.println(isSameTree2(root7, root8)); // true
        System.out.println(isSameTree2(root9, root10)); // false
    }
}
