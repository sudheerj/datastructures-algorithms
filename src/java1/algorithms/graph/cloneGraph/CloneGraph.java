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

    //Recursive DFS + visited HashMap => TC:O(V+E) SC:O(V)
    private Node cloneGraph1(Node node) {
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node node, Map<Node, Node> visitedMap) {
        if(node == null) return null;

        if(visitedMap.containsKey(node)) {
            return visitedMap.get(node);
        }

        Node cloneNode = new Node(node.val);
        visitedMap.put(node, cloneNode);

        for(Node neighbour: node.neighbours) {
            cloneNode.neighbours.add(cloneGraph1(neighbour));
        }

        return cloneNode;
    }


    //BFS: TC:O(V+E) SC:O(V)
    private Node cloneGraph2(Node node) {
        if(node == null) return null;

        Map<Node, Node> visitedMap = new HashMap<>();
        Node clonedNode = new Node(node.val);
        visitedMap.put(node, clonedNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            for(Node neighbour: currNode.neighbours) {
                if(!visitedMap.containsKey(neighbour)) {
                    visitedMap.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                } 
                visitedMap.get(currNode).neighbours.add(visitedMap.get(neighbour));
            }
        }
        return clonedNode;
    }

    public void showConnections(Node node) {
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            StringBuilder sb = new StringBuilder();
            for (Node neighbour : curr.neighbours) {
                sb.append(neighbour.val).append(" ");

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }

            System.out.println(curr.val + " --> " + sb.toString());
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
        graph1.showConnections(node1);
        System.out.println("---------------");
        CloneGraph graph2 = new CloneGraph();
        graph2.cloneGraph1(node5);
        graph2.showConnections(node5);
        System.out.println("---------------");
        CloneGraph graph3 = new CloneGraph();
        graph3.cloneGraph1(node6);
        graph3.showConnections(node6);
        System.out.println("---------------");

        CloneGraph graph4 = new CloneGraph();
        graph4.cloneGraph2(node11);
        graph4.showConnections(node11);
        System.out.println("---------------");
        CloneGraph graph5 = new CloneGraph();
        graph5.cloneGraph2(node51);
        graph5.showConnections(node51);
        System.out.println("---------------");
        CloneGraph graph6 = new CloneGraph();
        graph6.cloneGraph2(node61);
        graph6.showConnections(node61);
        System.out.println("---------------");
    }
}
