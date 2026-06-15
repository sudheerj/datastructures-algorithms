package java1.algorithms.graph.graphTraversal.islandPerimeter;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
    //Check all 4 directions TC: O(m * n) SC: O(m * n)
    private int islandPerimeter1(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int perimeter = 0;
        int[][] dirs = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 1) {
                    perimeter += 4;

                    for(int[] dir: dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if(nr >= 0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc] == 1) {
                            perimeter--;
                        }
                    }
                }
            }
        }

        return perimeter;
    }

    //count only land cells and shared edges TC: O(m * n) SC: O(1)
    private int islandPerimeter2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int land = 0, sharedEdges = 0;

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 1) {
                    land++;

                    //check bottom neighbour
                    if(r+1 < rows && grid[r+1][c] == 1) {
                        sharedEdges++;
                    }

                    //check right neighbour
                    if(c+1 < cols && grid[r][c+1] == 1) {
                        sharedEdges++;
                    }
                }
            }
        }

        return land * 4 - 2 * sharedEdges;
    }

    //DFS recursion TC: O(m * n) SC: O(m * n)
    private int islandPerimeter3(int[][] grid) {
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == 1) {
                    return dfs(grid, r, c);
                }
            }
        }

        return 0;
    }

    private int dfs(int[][] grid, int r, int c) {
        //boundary check
        if(r < 0 || r>= grid.length || c < 0 || c>= grid[0].length) return 1;

        //water check
        if(grid[r][c] == 0) return 1;

        if(grid[r][c] == -1) {
            return 0;
        }

        grid[r][c] = -1;

        return dfs(grid, r-1, c) 
                + dfs(grid, r, c+1)
                + dfs(grid, r+1, c)
                + dfs(grid, r, c-1);
    }

    //BFS TC: O(m * n) SC: O(m * n)
    private int islandPerimeter4(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c] == 1) {

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    grid[r][c] = -1;

                    int perimeter = 0;

                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();

                        for(int[] dir: dirs) {
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];

                            if(nr < 0 || nr >= rows || nc < 0 || nc >= cols) { //boundary
                                perimeter += 1;
                            } else if(grid[nr][nc] == 0) { // water
                                perimeter += 1;
                            } else if(grid[nr][nc] == 1) {
                                grid[nr][nc] = -1;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }

                    return perimeter;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        IslandPerimeter perimeter = new IslandPerimeter();

        System.out.println("Shared Edges     : "
                + perimeter.islandPerimeter1(copy(grid)));

        System.out.println("4 Directions     : "
                + perimeter.islandPerimeter2(copy(grid)));

        System.out.println("DFS              : "
                + perimeter.islandPerimeter3(copy(grid)));

        System.out.println("BFS              : "
                + perimeter.islandPerimeter4(copy(grid)));
    }

    private static int[][] copy(int[][] grid) {
        int[][] result = new int[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            result[i] = grid[i].clone();
        }

        return result;
    }

}
