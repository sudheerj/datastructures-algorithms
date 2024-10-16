 class NumberOfConnectedComponents {

    constructor(){
        this.parent = [];
        this.rank = [];
    }

    countConnectedComponents(n, edges) {
        this.parent = Array(n).fill().map((x, index) => index);
        this.rank = Array(n).fill(1);
    
        let count = n;
        for(let edge of edges) {
           if(this.union(edge[0], edge[1]) === 1) {
                count--;
           }
        }
        return count;
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


 let n1 = 3;
 let edges1 = [[0,1], [1,2]];

 let n2 = 6;
 let edges2 = [[0, 1], [1, 2], [2, 3], [4, 5]];
 const numOfConnectedComponents1 = new NumberOfConnectedComponents();
 const numOfConnectedComponents2 = new NumberOfConnectedComponents();
 console.log(numOfConnectedComponents1.countConnectedComponents(n1, edges1));
 console.log(numOfConnectedComponents2.countConnectedComponents(n2, edges2));