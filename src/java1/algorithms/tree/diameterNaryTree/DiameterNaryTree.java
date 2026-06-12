package java1.algorithms.tree.diameterNaryTree;

import java.util.List;

class Node {
    int val;
    List<Node> children;

    Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
public class DiameterNaryTree {
    private int diameter = 0;
    private int diameter(Node root) {
        if(root == null) return 0;
        dfs(root);
        return diameter;
    }

    private int dfs(Node node) {
        if(node == null) return 0;

        int max1 = 0, max2 = 0;

        for(Node child: node.children) {
            int h = dfs(child);

            if(h > max1) {
                max2 = max1;
                max1 = h;
            } else if(h > max2) {
                max2 = h;
            }
        }

        diameter = Math.max(diameter, max1 + max2);

        return 1 + max1;
    }
}
