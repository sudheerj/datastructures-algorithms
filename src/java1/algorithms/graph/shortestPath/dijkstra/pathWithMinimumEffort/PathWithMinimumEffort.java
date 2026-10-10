import java.util.*;

public class PathWithMinimumEffort {

    public static int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        // dist[r][c] = minimum effort required to reach cell (r,c)
        int[][] dist = new int[rows][cols];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // {effort, row, col}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {
                {-1, 0}, // up
                {1, 0},  // down
                {0, -1}, // left
                {0, 1}   // right
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            // Destination reached
            if (row == rows - 1 && col == cols - 1) {
                return effort;
            }

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Boundary check
                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Effort of this single move
                int currentDiff = Math.abs(
                        heights[row][col] - heights[newRow][newCol]
                );

                // Path effort = maximum difference seen so far
                int newEffort = Math.max(effort, currentDiff);

                // Relaxation
                if (newEffort < dist[newRow][newCol]) {

                    dist[newRow][newCol] = newEffort;

                    pq.offer(new int[]{
                            newEffort,
                            newRow,
                            newCol
                    });
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };

        System.out.println(minimumEffortPath(heights));
    }
}