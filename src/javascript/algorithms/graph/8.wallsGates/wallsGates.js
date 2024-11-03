const INF = 2147483647;

function wallsAndGates(grid) {
    let rows = grid.length;
    let cols = grid[0].length;
    let queue = [];

    for (let r = 0; r < rows; r++) {
        for(let c = 0; c < cols; c++) {
            if(grid[r][c] === 0){
                queue.push([r, c]);
            }
        }
    }

    let directions = [[1,0], [-1,0], [0, 1], [0, -1]];
    while(queue.length >0) {
        let [r, c] = queue.shift();

        for(const [dr, dc] of directions) {
            const nr = r+dr, nc = c+dc;
            if(nr < 0 || nr>= rows || nc < 0 || nc>= cols || grid[nr][nc] !== INF) {
                continue;
            }
        
            queue.push([nr, nc]);
            grid[nr][nc] = grid[r][c]+1;
        }
    }

}

let grid1 = [
    [INF,  -1,  0,  INF],
    [INF, INF, INF,  -1],
    [INF,  -1, INF,  -1],
    [0,   -1,   INF, INF]
];
wallsAndGates(grid1)
console.log(grid1);

let grid2 = [
    [-1,  0],
    [INF, INF]
];
wallsAndGates(grid2)
console.log(grid2);