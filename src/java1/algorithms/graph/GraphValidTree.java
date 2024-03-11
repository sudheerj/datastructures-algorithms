package java1.algorithms.graph;

public class GraphValidTree {
    //Union-find TC:O(V+E) SC: O(V)
    private static boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++)  {
            root[i] = i;
        }

        int count = n;
        for(int[] edge: edges) {
            int A = edge[0], B = edge[1];
            int rootA = find(root, A), rootB = find(root, B);
            if(rootA == rootB) return false;

            if(rank[rootA] >= rank[rootB]) {
                root[rootB] = root[rootA];
                rank[rootA]++; 
            } else {
                root[rootA] = root[rootB];
                rank[rootB]++;
            }
            
            count--;
        }
        return count ==1;
    }

    private static int find(int[] root, int x) {
        if(root[x] != x) {
            root[x] = root[root[x]];
        }
        return root[x];
    }

    public static void main(String[] args) {
        int n1 = 7;
        int n2 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}, {5, 6}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(validTree(n1, edges1));
        System.out.println(validTree(n2, edges2));
    }
}
