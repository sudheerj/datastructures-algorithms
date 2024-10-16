package java1.algorithms.graph.pacificAtlantic;
import java.util.*;

public class PacificAtlantic {
    //DFS: TC:O(rows * cols) SC:O(rows * cols)
    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //first row and last row visit
        for(int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific, Integer.MIN_VALUE);
            dfs(heights, rows-1, c, atlantic, Integer.MIN_VALUE);
        }

        //first column and last column vist
        for(int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, r, cols-1, atlantic, Integer.MIN_VALUE);
        }

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length ||
           heights[row][col] < prevHeight || visited[row][col]) return;
        visited[row][col] = true;

        //down, top, right, left traversal
        dfs(heights, row+1, col, visited, heights[row][col]);
        dfs(heights, row-1, col, visited, heights[row][col]);
        dfs(heights, row, col+1, visited, heights[row][col]);
        dfs(heights, row, col-1, visited, heights[row][col]);
    }

    public static void main(String[] args) {
        int[][] heights1 = {{3,4,5,3,6}, {4,3,4,5,5}, {1,3,6,4,2}, {8,9,4,1,6}, {9,3,3,1,5}};
        int[][] heights2 = {{2},{2}};
        System.out.println(pacificAtlantic(heights1));
        System.out.println(pacificAtlantic(heights2));
    }
}
