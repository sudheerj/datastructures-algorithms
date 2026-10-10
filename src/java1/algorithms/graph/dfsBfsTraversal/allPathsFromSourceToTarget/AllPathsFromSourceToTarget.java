package java1.algorithms.graph.dfsBfsTraversal.allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    //DFS + Backtracking TC: O(P * V) SC: O(P * V)
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(0, graph, path, result);
        return result;
    }

    public static void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> result) {
        //Reached target
        if(node == graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int next: graph[node]) {
            //choose
            path.add(next);

            //explore
            dfs(next, graph, path, result);

            //undo choice
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };

        System.out.println(allPathsSourceTarget(graph));
    }
}
