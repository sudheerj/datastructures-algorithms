# **Number of Connected Components**

## **Problem Statement**
Given n nodes labeled from 0 to n-1 and a list of undirected edges, return the number of connected components in the graph.

---

## **Examples**

### Example 1:
- **Input**: `n = 5, edges = [[0,1],[1,2],[3,4]]`
- **Output**: `2`

### Example 2:
- **Input**: `n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]`
- **Output**: `1`

---

## **Algorithmic Approach**

### Union-Find:
1. Initialize parent array where each node is its own parent.
2. For each edge, union the two nodes.
3. Count number of distinct roots.

### DFS/BFS:
1. Build adjacency list.
2. For each unvisited node, do DFS/BFS and mark all reachable nodes.
3. Increment component count after each DFS/BFS.

---

## **Time and Space Complexity**

**Union-Find:**
- **Time Complexity**: `O(E * α(N))` ≈ `O(E)`
- **Space Complexity**: `O(N)`

**DFS/BFS:**
- **Time Complexity**: `O(V + E)`
- **Space Complexity**: `O(V + E)`
