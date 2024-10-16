package java1.algorithms.graph.cloneGraph;

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
    private Map<Integer, Node> visitedMap = new HashMap<>();

    //DFS: TC:O(V+E) SC:O(n)
    private Node cloneGraph1(Node node) {
        if (node == null) return null;

        if (visitedMap.containsKey(node.val)) {
            return visitedMap.get(node.val);
        }
        else {
            Node copyNode = new Node(node.val);
            visitedMap.put(node.val, copyNode);
    
            for (Node neighbour : node.neighbours) {
                copyNode.neighbours.add(cloneGraph1(neighbour));
            }
            return copyNode;
        }
    }

    //BFS: TC:O(V+E) SC:O(n)
    private Node cloneGraph2(Node node) {
        if(node == null) return null;
        Node clonedNode = new Node(node.val);
        visitedMap.put(node.val, clonedNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            List<Node> newNeighbours = currNode.neighbours;
            for(Node neighbour: newNeighbours) {
                if(!visitedMap.containsKey(neighbour.val)) {
                    Node temp = new Node(neighbour.val);
                    visitedMap.put(neighbour.val, temp);
                    queue.add(neighbour);
                } 
                visitedMap.get(currNode.val).neighbours.add(visitedMap.get(neighbour.val));
            }
        }
        return clonedNode;
    }

    public void showConnections() {
        Set<Integer> allVertices = visitedMap.keySet();
        for (int vertex : allVertices) {
            List<Node> allConnections = visitedMap.get(vertex).neighbours;
            String connectionStr = "";
            for (Node connection : allConnections) {
                connectionStr += connection.val + " ";
            }
            System.out.println(vertex + " --> " + connectionStr);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = null;

        Node node11 = new Node(1);
        Node node21 = new Node(2);
        Node node31 = new Node(3);
        Node node41 = new Node(4);
        Node node51 = new Node(5);
        Node node61 = null;

        node1.neighbours.add(node2);
        node2.neighbours.add(node1);
        node2.neighbours.add(node3);
        node3.neighbours.add(node2);
        node3.neighbours.add(node4);
        node4.neighbours.add(node3);

        node11.neighbours.add(node21);
        node21.neighbours.add(node11);
        node21.neighbours.add(node31);
        node31.neighbours.add(node21);
        node31.neighbours.add(node41);
        node41.neighbours.add(node31);

        CloneGraph graph1 = new CloneGraph();
        graph1.cloneGraph1(node1);
        graph1.showConnections();
        System.out.println("---------------");
        CloneGraph graph2 = new CloneGraph();
        graph2.cloneGraph1(node5);
        graph2.showConnections();
        System.out.println("---------------");
        CloneGraph graph3 = new CloneGraph();
        graph3.cloneGraph1(node6);
        graph3.showConnections();
        System.out.println("---------------");

        CloneGraph graph4 = new CloneGraph();
        graph4.cloneGraph2(node11);
        graph4.showConnections();
        System.out.println("---------------");
        CloneGraph graph5 = new CloneGraph();
        graph5.cloneGraph2(node51);
        graph5.showConnections();
        System.out.println("---------------");
        CloneGraph graph6 = new CloneGraph();
        graph6.cloneGraph2(node61);
        graph6.showConnections();
        System.out.println("---------------");
    }
}
