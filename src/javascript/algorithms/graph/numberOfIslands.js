//DFS: TC: O(rows * cols) SC: O(1)

function numIslands(grid) {
    let rows = grid.length, cols = grid[0].length;
    let count = 0;

    for(let r=0; r< rows; r++) {
        for(let c=0; c<cols; c++) {
            if(grid[r][c] === '1') {
                count++;
                dfs(grid, r, c);
            }
        }
    }
    return count;
}

function dfs(grid, row, col){
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] === '0') return;
    grid[row][col] = '0';
    //down,top,right and left

    dfs(grid, row+1, col);
    dfs(grid, row-1, col);
    dfs(grid, row, col+1);
    dfs(grid, row, col-1);
}

let grid = [
    ['1','1','0','0','0'],
    ['1','1','0','0','0'],
    ['0','0','1','0','0'],
    ['0','0','0','1','1']
];
console.log(numIslands(grid));