package java1.datastructures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UnweightedUndirectedGraph {

    private int numberOfVertices;
    private HashMap<String, List<String>> adjacentList;

    UnweightedUndirectedGraph() {
        this.numberOfVertices = 0;
        this.adjacentList = new HashMap<>();
    }

    public boolean addVertex(String vertex) {
        if (!this.adjacentList.containsKey(vertex)) {
            this.adjacentList.put(vertex, new ArrayList<>());
            this.numberOfVertices++;
            return true;
        }
        return false;
    }

    public boolean addEdge(String firstVertex, String secondVertex) {
        if (this.adjacentList.containsKey(firstVertex) && this.adjacentList.containsKey(secondVertex)) {
            this.adjacentList.get(firstVertex).add(secondVertex);
            this.adjacentList.get(secondVertex).add(firstVertex);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String firstVertex, String secondVertex) {
        if (this.adjacentList.containsKey(firstVertex) && this.adjacentList.containsKey(secondVertex)) {
            this.adjacentList.get(firstVertex).remove(secondVertex);
            this.adjacentList.get(secondVertex).remove(firstVertex);
            return true;
        }

        return false;
    }

    public void removeVertex(String vertex) {
        if (!this.adjacentList.containsKey(vertex))
            return;
        while (this.adjacentList.get(vertex).size() > 0) {
            String temp = this.adjacentList.get(vertex).removeLast();
            this.removeEdge(vertex, temp);
        }
        this.adjacentList.remove(vertex);
        this.numberOfVertices--;
    }

    public void showConnections() {
        Set<String> allVertices = this.adjacentList.keySet();
        for (String vertex : allVertices) {
            List<String> allConnections = this.adjacentList.get(vertex);
            String connectionStr = "";
            for (String connection : allConnections) {
                connectionStr += connection + ' ';
            }
            System.out.println(vertex + " --> " + connectionStr);
        }
    }

    public static void main(String[] args) {
        UnweightedUndirectedGraph myGraph = new UnweightedUndirectedGraph();
        System.out.println(myGraph.addVertex("1"));
        System.out.println(myGraph.addVertex("2"));
        System.out.println(myGraph.addVertex("3"));
        System.out.println(myGraph.addVertex("4"));
        System.out.println(myGraph.addVertex("5"));
        System.out.println(myGraph.addVertex("6"));
        System.out.println(myGraph.addEdge("1", "2"));
        System.out.println(myGraph.addEdge("1", "3"));
        System.out.println(myGraph.addEdge("2", "3"));
        System.out.println(myGraph.addEdge("2", "4"));
        System.out.println(myGraph.addEdge("3", "5"));
        myGraph.showConnections();
        System.out.println(myGraph.removeEdge("3", "5"));
        System.out.println(myGraph.removeEdge("2", "4"));
        myGraph.showConnections();
        myGraph.removeVertex("5");
        myGraph.removeVertex("4");
        myGraph.showConnections();
    }
}
