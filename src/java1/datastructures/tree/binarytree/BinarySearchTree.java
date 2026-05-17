package java1.datastructures.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int value;
    public Node left;
    public Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    private Node root;

    BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node currentNode = this.root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;

            } else if (value > currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            } else {
                return;
            }
        }
    }

    public boolean lookup(int value) {
        if (this.root == null)
            return false;

        Node currentNode = this.root;

        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value) {
        if (node == null)
            return null;

        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // two children exists
            Node minValueNode = minValueNode(node.right);
            // Replace with inorder successor
            node.value = minValueNode.value;
            // Delete duplicate inorder successor
            node.right = deleteNode(node.right, minValueNode.value);
        }

        return node;
    }

    public Node minValueNode(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public Node maxValueNode(Node current) {
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public void bfs() {
        if (root == null)
            return;

        Node currentNode = this.root;
        List<Integer> output = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        while (queue.size() != 0) {
            currentNode = queue.remove();
            output.add(currentNode.value);
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }

        System.out.println(output);
    }

    public void dfsPreOrder() {
        if (root == null)
            return;

        List<Integer> output = new ArrayList<>();
        preorder(root, output);
        System.out.println(output);
    }

    private void preorder(Node node, List<Integer> output) {
        if (node == null)
            return;

        output.add(node.value);
        if (node.left != null)
            preorder(node.left, output);
        if (node.right != null)
            preorder(node.right, output);
    }

    public void dfsPostOrder() {
        if (root == null)
            return;

        List<Integer> output = new ArrayList<>();
        postorder(root, output);
        System.out.println(output);
    }

    private void postorder(Node node, List<Integer> output) {
        if (node == null)
            return;

        postorder(node.left, output);
        postorder(node.right, output);
        output.add(node.value);
    }

    public void dfsInOrder() {
        if (root == null)
            return;
        List<Integer> output = new ArrayList<>();

        inorder(root, output);
        System.out.println(output);
    }

    private void inorder(Node node, List<Integer> output) {
        if (node == null)
            return;

        inorder(node.left, output);
        output.add(node.value);
        inorder(node.right, output);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(12);
        tree.insert(16);
        tree.insert(22);
        tree.insert(30);
        tree.insert(10);
        tree.insert(14);
        tree.insert(28);
        tree.insert(35);

        System.out.println(tree.lookup(25));
        System.out.println(tree.lookup(7));
        System.out.println(tree.lookup(10));
        System.out.println(tree.lookup(12));
        System.out.println(tree.minValueNode(tree.root.left).value);
        System.out.println(tree.maxValueNode(tree.root.right).value);

        tree.bfs();
        tree.dfsPreOrder();
        tree.dfsPostOrder();
        tree.dfsInOrder();

        // Delete leaf node (no children): remove 10
        tree.delete(10);
        System.out.print("After deleting leaf 10: ");
        tree.dfsInOrder(); // [12, 14, 15, 16, 20, 22, 25, 28, 30, 35]

        // Delete node with one child: remove 12 (only has right child 14)
        tree.delete(12);
        System.out.print("After deleting 12 (one child): ");
        tree.dfsInOrder(); // [14, 15, 16, 20, 22, 25, 28, 30, 35]

        // Delete node with two children: remove 25 (has children 22 and 30)
        // In-order successor is 28; 28 replaces 25
        tree.delete(25);
        System.out.print("After deleting 25 (two children): ");
        tree.dfsInOrder(); // [14, 15, 16, 20, 22, 28, 30, 35]

        // Delete root node: remove 20
        tree.delete(20);
        System.out.print("After deleting root 20: ");
        tree.dfsInOrder(); // [14, 15, 16, 22, 28, 30, 35]

        // Delete non-existent value: no change
        tree.delete(99);
        System.out.print("After deleting non-existent 99: ");
        tree.dfsInOrder(); // [14, 15, 16, 22, 28, 30, 35]
    }
}
