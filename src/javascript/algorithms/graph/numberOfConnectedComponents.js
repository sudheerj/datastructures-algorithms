 // Union find:- TC: O(V+E) SC: O(V)

 function countConnectedComponents(n, edges) {
    let root = Array(n).fill(0).map((x, index) => index);
    let rank = Array(n).fill(0);

    let count = n;
    for(let edge of edges) {
        let A = edge[0], B = edge[1];
        let rootA = find(root, A), rootB = find(root, B);
        if(rootA != rootB) {
            count--;
        }

        if(rank[rootA] >= rank[rootB]) {
            root[rootB] = root[rootA];
            rank[rootA]++;
        } else {
            root[rootA] = root[rootB];
            rank[rootB]++;
        }
    }
    return count;
 }

 function find(root, x) {
    if(root[x] != x) {
        root[x] = root[root[x]];
    }
    return root[x];
 }

 let n = 7;
 let edges = [[0, 1], [1, 2], [3, 4], [5, 6]];
 console.log(countConnectedComponents(n, edges));