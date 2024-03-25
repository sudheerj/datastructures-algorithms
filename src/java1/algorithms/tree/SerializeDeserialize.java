package java1.algorithms.tree;

import java.util.*;


public class SerializeDeserialize {
    private int i;

    // Preorder traversal DFS: TC:O(n) SC: O(n)
    private String serialize(TreeNode root) { 
        List<String> list = new ArrayList<>();
        serializeDFS(root, list);
        return String.join(",", list);
    }

    private void serializeDFS(TreeNode node, List<String> list) {
        if(node == null) {
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.value));
        serializeDFS(node.left, list);
        serializeDFS(node.right, list);
    }

    // DFS: TC:O(n) SC: O(n)
    private TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDFS(tokens);
    }

    private TreeNode deserializeDFS(String[] tokens) {
        String token = tokens[this.i];
        if(token.equals("N")) {
            this.i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(token));
        this.i++;
        node.left = deserializeDFS(tokens);
        node.right = deserializeDFS(tokens);

        return node;
    }

    private static void printTree(TreeNode root) {
        if(root == null) return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        SerializeDeserialize serializeDeserializeObj = new SerializeDeserialize();
        String serializedString = serializeDeserializeObj.serialize(root);
        System.out.println(serializedString);
        printTree(serializeDeserializeObj.deserialize(serializedString));
    }

}
