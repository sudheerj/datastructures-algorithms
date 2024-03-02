package java1.algorithms.graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbours;

    public Node() {
        val = 0;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _val, List<Node> _neighbours) {
        val = _val;
        neighbours = _neighbours;
    }
}

public class CloneGraph {
    private static Map<Integer, Node> map = new HashMap<>();

    //DFS: TC:O(n) SC:O(n)
    private static Node cloneGraph1(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        else {
            Node copyNode = new Node(node.val);
            map.put(node.val, copyNode);
    
            for (Node neighbour : node.neighbours) {
                copyNode.neighbours.add(cloneGraph1(neighbour));
            }
            return copyNode;
        }
    }

    //BFS: TC:O(n+e) SC:O(n)
    private static Node cloneGraph2(Node node) {
        if(node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(clonedNode);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            List<Node> newNeighbours = currNode.neighbours;
            for(Node neighbour: newNeighbours) {
                if(!map.containsKey(neighbour.val)) {
                    Node temp = new Node(neighbour.val);
                    map.put(neighbour.val, temp);
                    queue.add(neighbour);
                } 
                newNeighbours.add(map.get(neighbour.val));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node3);

        node2.neighbours.add(node1);
        node2.neighbours.add(node4);

        node4.neighbours.add(node2);
        node4.neighbours.add(node3);

        node3.neighbours.add(node4);
        node3.neighbours.add(node1);

        System.out.println(cloneGraph1(node1));
        System.out.println(cloneGraph2(node1));
    }
}
