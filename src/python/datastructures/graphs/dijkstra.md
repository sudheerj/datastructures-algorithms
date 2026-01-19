# **Dijkstra's Algorithm**

## **Problem Statement**
Find the shortest path from a source vertex to all other vertices in a weighted graph with non-negative edge weights.

---

## **Examples**

### Example 1:
- **Input**: Graph with vertices 0-4, source = 0
- **Output**: Shortest distances from 0 to all vertices

---

## **Algorithmic Approach**

1. Initialize distances: source = 0, others = infinity.
2. Use a priority queue (min-heap) with (distance, vertex) pairs.
3. While queue not empty:
   - Extract minimum distance vertex.
   - For each neighbor:
     - Calculate new distance through current vertex.
     - If shorter, update distance and add to queue.
4. Return distances array.

---

## **Time and Space Complexity**

- **Time Complexity**: `O((V + E) log V)`  
  With binary heap implementation.

- **Space Complexity**: `O(V)`  
  For distances and priority queue.
