package java1.algorithms.graph.numberOfConnectedComponents;

public class NumberOfConnectedComponents {

    private int[] parent;
    private  int[] rank;

    public int countConnectedComponents(int n, int[][] edges) {

        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1; 
        }

        int count = n;
        for(int[] edge: edges) {
            if(this.union(edge[0], edge[1]) == 1) {
                count--;
            }
        }

        return count;
           
    }

    private int find(int n) {
        int curNode = n;
        while(curNode != this.parent[curNode]) {
            this.parent[curNode] = this.parent[this.parent[curNode]];
            curNode = this.parent[curNode];
        }
        return curNode;
    }

    private int union(int n1, int n2) {
        int p1 = this.find(n1);
        int p2 = this.find(n2);
        if(p1 == p2) {
            return 0;
        }

        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
    
        return 1;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] edges1 = {{0,1}, {1,2}};

        int n2 = 6;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {4, 5}};

        NumberOfConnectedComponents numConnected = new NumberOfConnectedComponents();
        System.out.println(numConnected.countConnectedComponents(n1, edges1));
        System.out.println(numConnected.countConnectedComponents(n2, edges2));
    }
}
