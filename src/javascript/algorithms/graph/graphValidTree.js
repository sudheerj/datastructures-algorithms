//Union-find TC:O(V+E) SC: O(V)

function validTree(n, edges) {
    let root = Array(n).fill(0).map((x, index) => index);
    let rank = Array(n).fill(0);
    let counter = n;

    for(let edge of edges) {
        let A = edge[0], B = edge[1];
        let rootA = find(root, A), rootB = find(root, B);
        if(rootA === rootB) return false;

        if(rank[rootA] >= rank[rootB]) {
            root[rootB] = root[rootA];
            rank[rootA]++;
        } else {
            root[rootA] = root[rootB];
            rank[rootB]++;
        }
        counter--;
    }
    return counter ===1;
}

function find(root, x) {
    if(root[x] != x) {
        root[x] = root[root[x]];
    }
    return root[x];
}

let n1 = 7;
let n2 = 5;
let edges1 = [[0, 1], [1, 2], [3, 4], [5, 6]];
let edges2 = [[0, 1], [0, 2], [0, 3], [1, 4]];
console.log(validTree(n1, edges1));
console.log(validTree(n2, edges2));