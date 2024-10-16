//Union-find TC:O(V+E) SC: O(V)

class GraphValidTree {

    constructor(){
        this.parent = [];
        this.rank = [];
    }

    isValidTree(n, edges) {
        this.parent = Array(n).fill().map((x, index) => index);
        this.rank = Array(n).fill(1);
    
        let count = n;
        for(let edge of edges) {
           if(this.union(edge[0], edge[1]) === 1) {
                count--;
           }
        }
        return count == 1;
     }
    
     find(n) {
        let curNode = n;
        while(curNode !== this.parent[curNode]) {
            this.parent[curNode] = this.parent[this.parent[curNode]];
            curNode = this.parent[curNode];
        }
        return curNode;
     }

     union(n1, n2){
        let p1 = this.find(n1), p2 = this.find(n2);
        if(p1 === p2) {
            return 0;
        }

        if(this.rank[p1] > this.rank[p2]) {
            this.parent[p2] = p1;
            this.rank[p1] += this.rank[p2];
        } else {
            this.parent[p1] = p2;
            this.rank[p2] += this.rank[p1];
        }

        return 1;
     }
    
 }


let n1 = 5;
let n2 = 7;
let edges1 = [[0, 1], [0, 2], [0, 3], [2, 4]];
let edges2 = [[0, 1], [1, 2], [3, 4], [5, 6]];

const graphValidTree = new GraphValidTree();
console.log(graphValidTree.isValidTree(n1, edges1));
console.log(graphValidTree.isValidTree(n2, edges2));