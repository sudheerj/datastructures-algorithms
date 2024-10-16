//DFS: TC: O(rows * cols) SC: O(rows * cols)

function numIslands1(grid) {
    let rows = grid.length, cols = grid[0].length;
    let islandsCount = 0;

    for(let r=0; r< rows; r++) {
        for(let c=0; c<cols; c++) {
            if(grid[r][c] === '1') {
                islandsCount++;
                dfs(grid, r, c);
            }
        }
    }
    return islandsCount;
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

//BFS: TC: O(rows * cols) SC: O(min(rows * cols))

function numIslands2(grid) {
    let rows = grid.length, cols = grid[0].length;
    let islandsCount = 0;

    for(let r=0; r< rows; r++) {
        for(let c=0; c<cols; c++) {
            if(grid[r][c] === '1') {
                islandsCount++;
                bfs(grid, r, c);
            }
        }
    }
    return islandsCount;
}

function bfs(grid, row, col){
    let queue = [[row,col]];
    grid[row][col] = '0';

    while(queue.length){
        const [r, c] = queue.shift();
        const directions = [[-1,0],[0,-1],[0,1],[1,0]];
        for (const [dr,dc] of directions) {
            row = r+dr; 
            col = c+dc;
            if(row >=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] === '1'){
                queue.push([row, col]);
                grid[row][col] = '0';
            }
        }
    }

}

let grid1 = [
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["0","1","0","1","0"],
    ["0","1","0","0","0"]
];
let grid11 = JSON.parse(JSON.stringify(grid1));
console.log(numIslands1(grid1));
console.log(numIslands2(grid11));

let grid2 = [
    ['1','1','0','1','1'],
    ['1','1','0','0','0'],
    ['0','0','1','0','1'],
    ['0','0','0','1','1']
];
let grid22 = JSON.parse(JSON.stringify(grid2));

console.log(numIslands1(grid2));
console.log(numIslands2(grid22));