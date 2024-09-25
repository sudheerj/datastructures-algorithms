package java1.datastructures.tree.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public Node left;
    public Node right;
    public int value;

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree {

    private Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(this.root == null) {
            this.root = newNode;
            return;
        }

        Node currentNode = this.root;
        while (true) {
            if(value < currentNode.value) {
                if(currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;

            } else if(value > currentNode.value) {
                if(currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            } else {
                return;
            }
        }
    }

    public boolean lookup(int value){
        if(this.root == null) return false;

        Node currentNode = this.root;

        while (currentNode != null) {
            if(value < currentNode.value) {
                currentNode = currentNode.left;
            } else if(value > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public Node minValueNode(Node current){
        while(true){
            if(current.left == null) return current;
            current = current.left;
        }  
    }

    public Node maxValueNode(Node current){
        while(true){
            if(current.right == null) return current;
            current = current.right;
        }  
    }

    public void bfs(){
        Node currentNode = this.root;
        List<Integer> output = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);

        while (queue.size() != 0) {
            currentNode = queue.remove();
            output.add(currentNode.value);
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }

        System.out.println(Arrays.deepToString(output.toArray()));
    }

    public void dfsPreOrder(){
        List<Integer> output = new ArrayList<>();

        class Traversal {
            Traversal(Node currentNode){
                output.add(currentNode.value);
                if(currentNode.left != null) new Traversal(currentNode.left);
                if(currentNode.right != null) new Traversal(currentNode.right);
            }
        }

        new Traversal(root);
        System.out.println(Arrays.deepToString(output.toArray()));
    }

    public void dfsPostOrder(){
        List<Integer> output = new ArrayList<>();

        class Traversal {
            Traversal(Node currentNode) {
                if(currentNode.left != null) new Traversal(currentNode.left);
                if(currentNode.right != null) new Traversal(currentNode.right);
                output.add(currentNode.value);
            }
        }

        new Traversal(root);
        System.out.println(Arrays.deepToString(output.toArray()));
    }

    public void dfsInOrder(){
        List<Integer> output = new ArrayList<>();

        class Traversal {
            Traversal(Node currentNode) {
                if(currentNode.left != null) new Traversal(currentNode.left);
                output.add(currentNode.value);
                if(currentNode.right != null) new Traversal(currentNode.right);
            }
        }

        new Traversal(root);
        System.out.println(Arrays.deepToString(output.toArray()));
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
    }
}
