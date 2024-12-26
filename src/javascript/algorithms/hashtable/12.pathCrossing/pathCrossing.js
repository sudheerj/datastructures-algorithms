function isPathCrossing(path){
    const visited = new Set();

    let x = 0, y = 0;
    visited.add(`${x},${y}`);

    const directions = {
        'N': [0, 1],
        'S': [0, -1],
        'E': [1, 0],
        'W': [-1, 0]
    }

    for (const move of path) {
        x+= directions[move][0],
        y+= directions[move][1]

        if(visited.has(`${x},${y}`)) {
            return true;
        }

        visited.add(`${x},${y}`);
    }

    return false;
}

const path1="NESE";
const path2="NEWS";

console.log(isPathCrossing(path1));
console.log(isPathCrossing(path2));