package java1.algorithms.graph.earliestMomentFriends;

import java.util.Arrays;

public class EarliestMomentFriends {
    //Using Disjoint set union TC: O(m log m) sorting + O(m *alpha(n)) ~= O(m logm), SC: O(n) for parent/rank arrays
    public int findTime(int[][] logs, int n) {
        //Sort by timestamp
        Arrays.sort(logs, (a, b) -> a[0]-b[0]);
        UnionFind uf = new UnionFind(n);

        for(int[] log: logs) {
            int time = log[0];
            int p1 = log[1];
            int p2 = log[2];

            if(uf.union(p1, p2)) {
                
                //if the group count reduced to 1
                if(uf.getCount() == 1) {
                    return time;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        EarliestMomentFriends sol = new EarliestMomentFriends();

        // Test 1: All friends become connected at timestamp 20
        System.out.println(sol.findTime(new int[][]{{20,0,1},{30,1,2},{10,0,3},{40,2,3}}, 4)); // Expected: 30

        // Test 2: Already connected after first log — all 2 people meet
        System.out.println(sol.findTime(new int[][]{{9,3,0},{0,2,1},{8,0,1},{5,2,0}}, 4)); // Expected: 9

        // Test 3: Logs never connect everyone — return -1
        System.out.println(sol.findTime(new int[][]{{10,0,1},{20,2,3}}, 5)); // Expected: -1

        // Test 4: Single log connects all 2 people
        System.out.println(sol.findTime(new int[][]{{5,0,1}}, 2)); // Expected: 5

        // Test 5: Connection happens at the last log
        System.out.println(sol.findTime(new int[][]{{1,0,1},{2,1,2},{3,2,3},{4,3,4}}, 5)); // Expected: 4
    }
}

class UnionFind {
    private int[] rank;
    private int[] parent;
    private int count;

    UnionFind(int n) {
        count = n;
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY) {
            return false;
        }

        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;

        return true;
    }

    public int getCount() {
        return count;
    }
}
