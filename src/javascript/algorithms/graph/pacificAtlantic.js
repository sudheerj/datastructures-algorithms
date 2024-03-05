//DFS: TC:O(rows * cols) SC:O(rows * cols)

function pacificAtlantic(heights) {
    let rows = heights.length, cols = heights[0].length;
    let result = [];

    let pacific = Array(rows).fill(false).map((row) => Array(cols).fill(false));
    let atlantic = Array(rows).fill(false).map((row) => Array(cols).fill(false));

    // first row & last row visit
    for(let c=0; c< cols; c++) {
        dfs(heights, 0, c, pacific, Number.NEGATIVE_INFINITY);
        dfs(heights, rows-1, c, atlantic, Number.NEGATIVE_INFINITY);
    }

    // first col & last col visit
    for(let r=0; r< cols; r++) {
        dfs(heights, r, 0, pacific, Number.NEGATIVE_INFINITY);
        dfs(heights, r, cols-1, atlantic, Number.NEGATIVE_INFINITY);
    }

    for(let r=0; r<rows; r++) {
        for(let c=0; c<cols; c++) {
            if(pacific[r][c] && atlantic[r][c]) {
                result.push([r, c]);
            }
        }
    }
    return result;
}

function dfs(heights, row, col, visited, prevHeight) {
    if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[row][col] < prevHeight || visited[row][col]) return;
    visited[row][col] = true;

    //down, top, right & left
    dfs(heights, row+1, col, visited, heights[row][col]);
    dfs(heights, row-1, col, visited, heights[row][col]);
    dfs(heights, row, col+1, visited, heights[row][col]);
    dfs(heights, row, col-1, visited, heights[row][col]);
}

let heights = [[1,2,2,3,5], [3,2,3,4,4], [2,4,5,3,1], [6,7,1,4,5], [5,1,1,2,4]];
console.log(pacificAtlantic(heights));