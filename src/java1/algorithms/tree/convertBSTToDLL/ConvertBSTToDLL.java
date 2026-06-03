package java1.algorithms.tree.convertBSTToDLL;

import java.util.Arrays;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

//Level order traversal TC: O(n) SC: O(n)
public class ConvertBSTToDLL {
    Node head = null;
    Node prev = null;
    
    private  Node convertTreeToDLL(Node root) {
        if(root == null) return null;

        dfs(root);

        return head;
    }

    private void dfs(Node node) {
        if(node == null) return;

        //left node
        dfs(node.left);

        //Process current node
        if(prev == null) {
            head = node; //smallest node
        } else {
            prev.right = node;
            node.left = prev;
        }

        prev = node;

        //right node
        dfs(node.right);
    }

    private static Node buildBST(int[] vals) {
        Node root = null;
        for (int v : vals) root = insert(root, v);
        return root;
    }

    private static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    private static int[] dllToArray(Node head) {
        int count = 0;
        for (Node c = head; c != null; c = c.right) count++;
        int[] arr = new int[count];
        Node c = head;
        for (int i = 0; i < count; i++, c = c.right) arr[i] = c.data;
        return arr;
    }

    public static void main(String[] args) {
        int[][][] tests = {
            {{4},           {4}},
            {{4,2,6,1,3,5,7}, {1,2,3,4,5,6,7}},
            {{3,2,1},       {1,2,3}},
            {{1,2,3},       {1,2,3}},
            {{5,3,7,2,4},   {2,3,4,5,7}},
        };

        for (int i = 0; i < tests.length; i++) {
            Node root = buildBST(tests[i][0]);
            ConvertBSTToDLL sol = new ConvertBSTToDLL();
            Node result = sol.convertTreeToDLL(root);
            int[] resultArr = dllToArray(result);
            String status = Arrays.equals(resultArr, tests[i][1]) ? "PASS" : "FAIL";
            System.out.println(status + " test " + (i+1) + ": result=" + Arrays.toString(resultArr) + " expected=" + Arrays.toString(tests[i][1]));
        }
    }
}
