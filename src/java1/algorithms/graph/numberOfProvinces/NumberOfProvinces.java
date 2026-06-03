package java1.algorithms.graph.numberOfProvinces;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    // Recursive DFS TC: O(n^2) SC: O(n)
    public static int numberOfProvinces(int[][] isConnected) {
        int n = isConnected.length;

        int provinces = 0;

        //track whether city was already visted
        boolean[] visited = new boolean[n];

        //Try starting DFS on every city
        for(int i=0; i<n; i++) {
            //if not visited yet, it belongs to a new province
            if(!visited[i]) {
                dfs(isConnected, visited, i);

                //once complete connected component found
                provinces++;
            }
        } 

        return provinces;
    }

    private static void dfs(int[][] graph, boolean[] visited, int city) {
        //mark city as visited
        visited[city] = true;

        //explore all neighbors
        for(int neighbor=0; neighbor<graph.length; neighbor++) {
            //if connected and not visited
            if(graph[city][neighbor] == 1 && !visited[neighbor]) {
                //connect DFS
                dfs(graph, visited, neighbor);
            }
        }
    }

    //BFS TC: O(n^2) SC: O(n)
    public static int numberOfProvinces2(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                queue.offer(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int city = queue.poll();

                    //explore all neighbours
                    for(int neighbor=0; neighbor<isConnected.length; neighbor++) {
                        if(isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                            queue.offer(neighbor);
                            visited[neighbor] = true;
                        }
                    }
                }
                provinces++;
            }

        }
        return provinces;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            //initially every city is its own province
            count = n;

            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        //ultimate parent through path compression
        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            //already connected if they have same parent
            if(rootX == rootY) return;

            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            count--;
        }

    }

    //Disjoint union set TC: O(n^2) SC: O(n)
    public static int numberOfProvinces3(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }



    public static void main(String[] args) {
        Object[][] tests = {
            // {isConnected, expected}
            {new int[][]{{1,1,0},{1,1,0},{0,0,1}},                  2},  // {0,1} and {2}
            {new int[][]{{1,0,0},{0,1,0},{0,0,1}},                  3},  // all isolated
            {new int[][]{{1,1,1},{1,1,1},{1,1,1}},                  1},  // all connected
            {new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}}, 2},  // {0,3} and {1,2}
            {new int[][]{{1}},                                       1},  // single city
        };

        System.out.println("--- Approach 1: Recursive DFS ---");
        for (Object[] test : tests) {
            int[][] isConnected = (int[][]) test[0];
            int expected = (int) test[1];
            int result = numberOfProvinces(isConnected);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }

        System.out.println("--- Approach 2: BFS ---");
        for (Object[] test : tests) {
            int[][] isConnected = (int[][]) test[0];
            int expected = (int) test[1];
            int result = numberOfProvinces2(isConnected);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }

        System.out.println("--- Approach 3: Union-Find ---");
        for (Object[] test : tests) {
            int[][] isConnected = (int[][]) test[0];
            int expected = (int) test[1];
            int result = numberOfProvinces3(isConnected);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
