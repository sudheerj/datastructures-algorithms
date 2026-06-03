package java1.algorithms.graph.validArrangementOfPairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidArrangementOfPairs {
    //used to store nodes in reverse Euler path order
    List<Integer> path = new ArrayList<>();

    private int[][] validArrangement(int[][] pairs) {

        //Graph a -> list of all outgoing nodes(b)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Track how many incoming edges on to a node
        Map<Integer, Integer> in = new HashMap<>();
        //Track how many edges go out of a node
        Map<Integer, Integer> out = new HashMap<>();

        //Build graph + compute in/out edges
        for(int[] pair: pairs) {
            int u = pair[0];
            int v = pair[1];

            //Add a directed edge u -> v
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            out.putIfAbsent(u, out.getOrDefault(u, 0)+1);
            in.putIfAbsent(v, in.getOrDefault(u, 0)+1);
        }

        //find the start node of Euler path(node with out-in = 1 if exists)
        int start = pairs[0][0];

        for(int node: out.keySet()) {
            int outDegree = out.getOrDefault(node, 0);
            int inDegree = in.getOrDefault(node, 0);

            if(outDegree-inDegree == 1) {
                start = node;
                break;
            }
        }

        //Run DFS to find Euler path
        dfs(start, graph);

        //Path in reverse order, fix it
        Collections.sort(path);

        int[][] result = new int[pairs.length][2];

        for(int i=0; i<pairs.length; i++) {
            result[i][0] = path.get(i);
            result[i][1] = path.get(i+1);
        }

        return result;
    }

    //Run Heirholzer algorithm
    private void dfs(int start, Map<Integer, List<Integer>> graph) {
        List<Integer> neighbours = graph.get(start);

        while(neighbours != null & !neighbours.isEmpty()) {
            int next = neighbours.remove(neighbours.size()-1);

            //Go deeper DFS
            dfs(next, graph);
        }

        //Add node after all unused edges covered
        path.add(start);
    }
}
