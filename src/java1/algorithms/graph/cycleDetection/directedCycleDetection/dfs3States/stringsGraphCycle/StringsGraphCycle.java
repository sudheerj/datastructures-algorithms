package java1.algorithms.graph.cycleDetection.directedCycleDetection.dfs3States.stringsGraphCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringsGraphCycle {
    //DFS- 3 states: TC: O(V^2) SC: O(V+E)
    public static boolean hasCycle(List<String> words) {
        int n = words.size();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && words.get(i).charAt(words.get(i).length()-1) == words.get(j).charAt(0)) {
                    graph.get(i).add(j);
                }
            }
        }

        //0=> unvisited, 1=> visting, 2 => visited
        int[] state = new int[n];

        for(int i=0; i<n; i++) {
            if(state[i] == 0) {
                if(dfs(i, graph, state)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if(state[node] == 1) {
            return true;
        }

        if(state[node] == 2) {
            return false;
        }

        state[node] = 1;

        for(int neighbour: graph.get(node)) {
            if(dfs(neighbour, graph, state)) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
            "abc",
            "cdg",
            "gza"
        );
        System.out.println(hasCycle(words));
    }
}
