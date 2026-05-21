package java1.algorithms.graph.numberOfIslands2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class UnionFind {
    private int[] rank;
    private int[] parent;

    UnionFind(int size) {
        rank = new int[size];
        parent = new int[size];

        Arrays.fill(parent, -1);
    }

    //find ultimate parent using path compression optimization
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    //convert water -> land
    public void addLand(int x) {
        parent[x] = x;
    }

    //check if its already land or not
    public boolean isLand(int x) {
        return parent[x] != -1;
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        //if same root, no need to combine
        if(rootX == rootY) return false;

        if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}

// Using Disjoint-set Union datastructure TC: O(k alpha(m * n)) ~= O(k) SC: O(m+n+k) ~= O(m+n) k= number of operations
public class NumberOfIslands2 {
    private List<Integer> numberOfIslands(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m*n);

        int islandsCount = 0;
        int[][] directions = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};

        for(int[] position: positions) {
            int row = position[0];
            int col = position[1];

            //Convert 2D index into 1D index
            int index = row * n + col;

            //Check if its already land or not
            if(uf.isLand(index)) {
                result.add(islandsCount);
                continue;
            }

            //Add new island and update its count
            uf.addLand(index);
            islandsCount++;

            for(int[] direction: directions) {
                int nr = row +direction[0];
                int nc = col + direction[1];

                //skip out of bounds cells
                if(nr < 0 || nc < 0 || nr >= m || nc >=n) continue;

                int neighbourIndex = nr * n + nc;

                //If neighbour is a land, try to merge the lands
                if(uf.isLand(neighbourIndex)) {
                    //if it is possible merge and then deduct the islands count
                    if(uf.union(index, neighbourIndex)) {
                        islandsCount--;
                    }
                }
            }
            //store latest islands count
            result.add(islandsCount);
        }
        return result;
    }
    public static void main(String[] args) {
        NumberOfIslands2 sol = new NumberOfIslands2();

        // Test 1: Adding islands one by one, some adjacent (merges occur)
        System.out.println(sol.numberOfIslands(3, 3, new int[][]{{0,0},{0,1},{1,2},{2,1}}));
        // Expected: [1, 1, 2, 3]

        // Test 2: All positions merge into a single island
        System.out.println(sol.numberOfIslands(2, 2, new int[][]{{0,0},{0,1},{1,0},{1,1}}));
        // Expected: [1, 1, 1, 1]

        // Test 3: Single cell grid
        System.out.println(sol.numberOfIslands(1, 1, new int[][]{{0,0}}));
        // Expected: [1]

        // Test 4: Duplicate position — already land, count unchanged
        System.out.println(sol.numberOfIslands(3, 3, new int[][]{{0,0},{0,0},{0,1}}));
        // Expected: [1, 1, 1]

        // Test 5: Islands grow and merge as bridge positions are added
        System.out.println(sol.numberOfIslands(3, 3, new int[][]{{0,0},{2,2},{1,1},{0,1},{1,0}}));
        // Expected: [1, 2, 3, 2, 2]
    }
}
