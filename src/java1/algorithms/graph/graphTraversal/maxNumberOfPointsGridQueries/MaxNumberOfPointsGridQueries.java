package java1.algorithms.graph.graphTraversal.maxNumberOfPointsGridQueries;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfPointsGridQueries {

    //Sort queries + process incrementally using minHeap + BFS traversal TC: O(q log q) + O(m * n log (m * n)) SC: O(m * n)
    private static int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;

        //sort queries based on query value
        int[][] sortedQueries = new int[queries.length][2];

        for(int i=0; i<queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int[] maxPoints = new int[queries.length];

        int[][] dirs = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        for(int[] query: sortedQueries) {
            int limit = query[0];
            int index = query[1];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < limit) {
                int[] curr = minHeap.poll();

                count++;

                int r = curr[1];
                int c = curr[2];

                for(int[] dir: dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >=0 && nr < m && nc >=0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }
            maxPoints[index] = count;
        }

        return maxPoints;
    }

    public static void main(String[] args) {

        int[][] grid1 = {
                {1, 2, 3},
                {2, 5, 7},
                {3, 5, 1}
        };
        int[] queries1 = {5, 6, 2};
        System.out.println(Arrays.toString(maxPoints(grid1, queries1)));
        // Expected: [5, 8, 1]

        int[][] grid2 = {
                {5, 2, 1},
                {1, 1, 2}
        };
        int[] queries2 = {3};
        System.out.println(Arrays.toString(maxPoints(grid2, queries2)));
        // Expected: [0]

        int[][] grid3 = {
                {1}
        };
        int[] queries3 = {2, 1, 5};
        System.out.println(Arrays.toString(maxPoints(grid3, queries3)));
        // Expected: [1, 0, 1]

        int[][] grid4 = {
                {1, 1},
                {1, 1}
        };
        int[] queries4 = {1, 2, 3};
        System.out.println(Arrays.toString(maxPoints(grid4, queries4)));
        // Expected: [0, 4, 4]

        int[][] grid5 = {
                {10, 20, 30},
                {5, 15, 25},
                {1, 2, 3}
        };
        int[] queries5 = {5, 15, 35};
        System.out.println(Arrays.toString(maxPoints(grid5, queries5)));
        // Expected: [0, 1, 9]
    }

}
