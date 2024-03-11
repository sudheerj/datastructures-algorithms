package java1.algorithms.graph;

public class NumberOfConnectedComponents {
    // Union find:- TC: O(V+E) SC: O(V)
    private static int countConnectedComponents(int n, int[][] edges) {
        int[] root = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            root[i] = i;
        }

        int count = n;
        for(int[] edge: edges) {
            int A = edge[0], B = edge[1];
            int rootA = find(root, A), rootB = find(root, B);
            if(rootA != rootB) {
                count--;
            }

            if(rank[rootA] >= rank[rootB]) {
                root[rootB] = root[rootA];
                rank[rootA]++;
            } else {
                root[rootA] = root[rootB];
                rank[rootB]++;
            }
        }
        return count;
    }

    private static int find(int[] root, int x) {
        if(root[x] != x) {
            root[x] = find(root, root[x]);
        }
        return root[x];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}, {5, 6}};
        System.out.println(countConnectedComponents(n, edges));
    }
}
