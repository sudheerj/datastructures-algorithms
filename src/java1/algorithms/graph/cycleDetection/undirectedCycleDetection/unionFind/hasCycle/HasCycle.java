package java1.algorithms.graph.cycleDetection.undirectedCycleDetection.unionFind.hasCycle;

public class HasCycle {
    //Union-Find with path compression + union by rank: TC: O(E α(V))≈ O(E) SC: O(V)
    public static boolean hasCycle(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);

            if(rootU == rootV) {
                return true;
            }

            union(rootU, rootV, parent, rank);
        }

        return false;
    }

    public static int find(int node, int[] parent) {
        if(parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }

    public static void union(int rootU, int rootV, int[] parent, int[] rank) {
        if(rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if(rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0}
        };
        System.out.println(hasCycle(n, edges));
    }
}
