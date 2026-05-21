package java1.algorithms.graph.maxPathQuality;

import java.util.ArrayList;
import java.util.List;

public class MaxPathQuality {
    int maxScore = 0; //final score
    int[] values; // node values
    List<int[]>[] graph; //adjacency list {neighbour, time cost}

    //DFS + Backtracking TC: O(2^V) exploring all possible paths  SC: O(V+E) for graph + O(V) for recursion stack ~= O(V)
    private int maxPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        int n = values.length;

        //build the graph
        graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        //undirected weighted graph
        for(int[] edge: edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int[] vistedCount = new int[n]; // track visited count for each node in graph

        //start DFS from node0
        dfs(0, 0, 0, vistedCount, maxTime);

        return maxScore;
    }

    private void dfs(int node, int time, int score, int[] visitedCount, int maxTime) {
        //add node value to score for first time visit
        if(visitedCount[node] == 0) {
            score += values[node];
        }

        //mark as visited
        visitedCount[node]++;

        //update maxScore if we are back at node0
        if(node == 0) {
            maxScore = Math.max(maxScore, score);
        }

        //explore neighbours
        for(int[] edge: graph[node]) {
            int nei = edge[0]; //next neighbour
            int cost = edge[1]; // travel time

            //only move if with in time limit
            if(time + cost <= maxTime) {
                dfs(nei, time+cost, score, visitedCount, maxTime);
            }
        }

        //backtrack(undo visit)
        visitedCount[node]--;
    }

    public static void main(String[] args) {
        // Test 1: Classic example — two detours possible, best is 0->3->0->1->0
        MaxPathQuality sol1 = new MaxPathQuality();
        System.out.println(sol1.maxPathQuality(
            new int[]{0,32,10,43},
            new int[][]{{0,1,10},{1,2,15},{0,3,10}},
            49)); // Expected: 75

        // Test 2: Star graph — visit two best-value leaves within maxTime
        MaxPathQuality sol2 = new MaxPathQuality();
        System.out.println(sol2.maxPathQuality(
            new int[]{1,2,3,4},
            new int[][]{{0,1,5},{0,2,5},{0,3,5}},
            20)); // Expected: 8 (node0+node2+node3 = 1+3+4)

        // Test 3: Single node, no edges
        MaxPathQuality sol3 = new MaxPathQuality();
        System.out.println(sol3.maxPathQuality(
            new int[]{5},
            new int[][]{},
            10)); // Expected: 5

        // Test 4: Can't travel to any node and return within maxTime
        MaxPathQuality sol4 = new MaxPathQuality();
        System.out.println(sol4.maxPathQuality(
            new int[]{1,100},
            new int[][]{{0,1,20}},
            10)); // Expected: 1

        // Test 5: Linear path — can traverse full chain and return
        MaxPathQuality sol5 = new MaxPathQuality();
        System.out.println(sol5.maxPathQuality(
            new int[]{10,20,30},
            new int[][]{{0,1,5},{1,2,5}},
            20)); // Expected: 60 (0->1->2->1->0, time=20)
    }
}
