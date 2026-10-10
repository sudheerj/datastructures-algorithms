package java1.algorithms.graph.connectedComponents.numberOfConnectedComponents.unionFindByRank;

public class NumberOfConnectedComponents {
    //Union Find by rank TC: O(E Alpha(V)) SC: O(E)
    public static int countConnectedComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;
        for(int[] edge: edges) {
            if(union(edge[0], edge[1], parent, rank)) {
                components--;
            }
        }

        return components;
    }

    public static int find(int node, int[] parent) {
        if(node != parent[node]) {
            parent[node] = find(parent[node], parent);
        }

        return parent[node];
    }

    public static boolean union(int node1, int node2, int[] parent, int[] rank) {
        int p1 = find(node1, parent);
        int p2 = find(node2, parent);

        if(p1 == p2) {
            return false;
        }

        if(rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }

        return true;
    }

        public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {4, 5}
        };

        System.out.println(
                countConnectedComponents(n, edges)
        );
    }
}
