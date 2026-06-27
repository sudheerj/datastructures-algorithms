package java1.algorithms.tree.reverseOddLevels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import java1.algorithms.tree.TreeNode;

//Binary tree symmetry + reversal
public class ReverseOddLevels {
    //Mirror pairing DFS Recursive TC: O(n) SC: O(h)
    private static TreeNode reverseOddLevelsDFS(TreeNode root) {
        dfs(root.left, root.right, 1);
        return root;
    }

    private static void dfs(TreeNode left, TreeNode right, int level) {
        if(left == null || right == null) return;

        if(level % 2 == 1) {
            int temp = left.value;
            left.value = right.value;
            right.value = temp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }

    //BFS level by level and two pointers for reversing TC: O(n) SC: O(n)
    private static TreeNode reverseOddLevelsBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll();
                nodes.add(curr);

                if(curr.left != null) { queue.offer(curr.left);}
                if(curr.right != null) { queue.offer(curr.right);}
            }

            if(level % 2 == 1) {
                int left = 0, right = nodes.size()-1;

                while(left < right) {
                    int temp = nodes.get(left).value;
                    nodes.get(left).value = nodes.get(right).value;
                    nodes.get(right).value = temp;

                    left++;
                    right--;
                }
            }
            level++;
        }

        return root;
    }

    public static void main(String[] args) {
            TreeNode root1 = new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(5)),
                    new TreeNode(3,
                            new TreeNode(6),
                            new TreeNode(7))
            );

            TreeNode root2 = new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(4),
                            new TreeNode(5)),
                    new TreeNode(3,
                            new TreeNode(6),
                            new TreeNode(7))
            );

            reverseOddLevelsBFS(root1);
            reverseOddLevelsDFS(root2);

            // simple verification via level order arrays
            System.out.println("BFS result:");
            printLevelOrder(root1);

            System.out.println("DFS result:");
            printLevelOrder(root2);
        }

        private static void printLevelOrder(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                System.out.print(node.value + " ");

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println();
        }
}
