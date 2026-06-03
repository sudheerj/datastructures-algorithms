package java1.algorithms.graph.shortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    // BFS Shortest path TC: O(k * m * n) SC: O(m * n) k = number of buildings
    public static int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        int walk = 0; // controls which layer is allowed

        int answer = Integer.MAX_VALUE;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // go through all cells to find buildings
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { i, j });

                    int level = 0;

                    while (!q.isEmpty()) {

                        int size = q.size();

                        for (int s = 0; s < size; s++) {

                            int[] cur = q.poll();
                            int r = cur[0], c = cur[1];

                            for (int[] d : dirs) {

                                int nr = r + d[0];
                                int nc = c + d[1];

                                // ONLY allow cells from previous BFS layer
                                if (nr < 0 || nr >= m ||
                                        nc < 0 || nc >= n ||
                                        grid[nr][nc] != walk) {
                                    continue;
                                }

                                // mark as visited for this BFS
                                grid[nr][nc]--;

                                // accumulate distance
                                dist[nr][nc] += level + 1;

                                // update best answer
                                answer = Math.min(answer, dist[nr][nc]);

                                q.offer(new int[] { nr, nc });
                            }
                        }

                        level++;
                    }

                    // move to next BFS layer
                    walk--;
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        Object[][] tests = {
                // Simple: one building, one empty land
                { new int[][] { { 1, 0 } }, 1 },
                // No empty land
                { new int[][] { { 1 } }, -1 },
                // Empty land blocked by obstacle from the only building
                { new int[][] { { 0, 2, 1 } }, -1 },
        };

        for (Object[] test : tests) {
            int[][] grid = (int[][]) test[0];
            int expected = (int) test[1];
            int[][] gridCopy = deepCopyGrid(grid);
            int result = shortestDistance(gridCopy);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }

    // Utility for true deep copy of 2D int array
    private static int[][] deepCopyGrid(int[][] grid) {
        if (grid == null)
            return null;
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i] != null ? grid[i].clone() : null;
        }
        return copy;
    }
}
