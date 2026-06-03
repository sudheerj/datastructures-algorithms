# Evaluate Division

**Description:**
You are given an array of variable pairs `equations` and an array of real numbers `values`, where `equations[i] = [Ai, Bi]` and `values[i]` represent the equation `Ai / Bi = values[i]`. Each `Ai` or `Bi` is a string that represents a single variable.

You are also given some `queries`, where `queries[j] = [Cj, Dj]` represents the jth query where you must find the answer for `Cj / Dj = ?`.

Return the answers to all queries. If a single answer cannot be determined, return `-1.0`.

**Note:** The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

## Problem Statement:
Given equations representing division relationships between variables and their values, evaluate queries to find the result of dividing one variable by another. Use graph traversal (DFS/BFS) to find paths between variables and calculate the product of weights along the path.

## Examples:

**Example 1:**
```javascript
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0]
note: x is undefined => -1.0
```

**Example 2:**
```javascript
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Explanation:
a / c = (a/b) * (b/c) = 1.5 * 2.5 = 3.75
c / b = 1 / (b/c) = 1 / 2.5 = 0.4
bc / cd = 5.0 (direct)
cd / bc = 1 / 5.0 = 0.2
```

**Example 3:**
```javascript
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
Explanation:
a / b = 0.5 (given)
b / a = 1 / 0.5 = 2.0
a / c = -1.0 (c not in graph)
x / y = -1.0 (neither x nor y in graph)
```

**Example 4:**
```javascript
Input: equations = [["a","b"],["b","c"],["c","d"]], values = [2.0,3.0,4.0], queries = [["a","d"],["d","a"]]
Output: [24.00000,0.04167]
Explanation:
a / d = (a/b) * (b/c) * (c/d) = 2.0 * 3.0 * 4.0 = 24.0
d / a = 1 / 24.0 ≈ 0.04167
```

**Example 5:**
```javascript
Input: equations = [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]], values = [3.0,4.0,5.0,6.0], 
queries = [["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"]]
Output: [360.00000,0.04167,20.00000,1.00000,-1.00000]
Explanation:
x1 / x5 = 3.0 * 4.0 * 5.0 * 6.0 = 360.0
x5 / x2 = 1 / (3.0 * 4.0) ≈ 0.04167
x2 / x4 = 4.0 * 5.0 = 20.0
x2 / x2 = 1.0 (same variable)
x2 / x9 = -1.0 (x9 not in graph)
```

## Algorithmic Steps (Graph + DFS Approach)

This problem is solved by modeling the equations as a **weighted directed graph** and using **Depth-First Search (DFS)** to find paths between query variables.

### 1. **Build the Graph**:
   - Create an adjacency list representation using a Map where each variable is a node
   - For each equation `a / b = value`:
     - Add edge from `a` to `b` with weight `value`
     - Add edge from `b` to `a` with weight `1.0 / value` (reciprocal)
   - This creates a bidirectional graph where we can traverse in both directions
   - Use `Map` for graph storage and arrays for adjacency lists

### 2. **Process Each Query**:
   For each query `[C, D]`:
   
   **a) Check if both variables exist in the graph**:
   - If either variable is not in the graph, push `-1.0` to results
   
   **b) Handle special case**:
   - If `C === D` and the variable exists, the DFS will return `1.0`
   
   **c) Perform DFS to find path from C to D**:
   - Start DFS from source variable `C`
   - Track visited nodes in a Set to avoid cycles
   - Multiply weights along the path (product accumulation)
   - If we reach target variable `D`, return the accumulated product
   - If no path exists, return `-1.0`

### 3. **DFS Helper Function**:
   ```javascript
   function dfs(curr, target, product, visited) {
       if (curr === target) {
           return product;
       }
       
       visited.add(curr);
       
       const neighbors = graph.get(curr) || [];
       for (const [neighbor, weight] of neighbors) {
           if (!visited.has(neighbor)) {
               const result = dfs(neighbor, target, product * weight, visited);
               if (result !== -1.0) {
                   return result;
               }
           }
       }
       
       return -1.0;  // no path found
   }
   ```

### 4. **Return Results**:
   - Return array of results for all queries

## Key Insights:

- **Graph representation**: Each variable is a node, each equation creates two directed edges (forward and reciprocal)
- **DFS traversal**: Find path from source to destination and multiply edge weights along the path
- **Cycle detection**: Use Set for O(1) visited checking to prevent infinite loops
- **Early termination**: If either variable doesn't exist in graph, immediately return -1.0
- **Self-division**: Any variable divided by itself equals 1.0 (handled by base case in DFS)
- **Product accumulation**: The result is the product of all edge weights along the path
- **Map usage**: Provides efficient key-value storage for graph adjacency lists

## Alternative Approaches:

### 1. **BFS (Breadth-First Search)**:
```javascript
function bfs(graph, src, dst) {
    if (src === dst) return 1.0;
    
    const queue = [[src, 1.0]];
    const visited = new Set([src]);
    
    while (queue.length > 0) {
        const [curr, product] = queue.shift();
        
        for (const [neighbor, weight] of graph.get(curr) || []) {
            if (!visited.has(neighbor)) {
                const newProduct = product * weight;
                if (neighbor === dst) {
                    return newProduct;
                }
                queue.push([neighbor, newProduct]);
                visited.add(neighbor);
            }
        }
    }
    
    return -1.0;
}
```

### 2. **Union-Find (Disjoint Set Union)**:
Can be used with weights to track division relationships, but more complex to implement.

### 3. **Floyd-Warshall (All Pairs Shortest Path)**:
Precompute all division results, but requires O(V³) time and space.

## Time and Space Complexity:

**Time Complexity:** `O(E + Q * (V + E))`
- Building the graph: `O(E)` where E is the number of equations
- For each query Q:
  - DFS traversal: `O(V + E)` in worst case (V = number of variables)
- Total: `O(E + Q * (V + E))`
- In practice, if the graph is sparse and queries find paths quickly, the average case is much better

**Space Complexity:** `O(E + V)`
- Graph storage: `O(E)` for adjacency list (each equation creates 2 edges)
- DFS recursion stack: `O(V)` in worst case (depth of recursion)
- Visited set: `O(V)`
- Result array: `O(Q)` where Q is the number of queries

## Constraints:
- 1 ≤ equations.length ≤ 20
- equations[i].length == 2
- 1 ≤ Ai.length, Bi.length ≤ 5
- values.length == equations.length
- 0.0 < values[i] ≤ 20.0
- 1 ≤ queries.length ≤ 20
- queries[i].length == 2
- 1 ≤ Cj.length, Dj.length ≤ 5
- Ai, Bi, Cj, Dj consist of lower case English letters and digits

## Edge Cases to Consider:
1. **Variable not in graph**: Return -1.0
2. **Self-division**: x / x = 1.0 (if x exists)
3. **No path between variables**: Return -1.0 even if both exist
4. **Single equation**: Only two variables with their reciprocals
5. **Long chains**: Multiple equations creating a long path
6. **Empty graph**: All queries return -1.0

## JavaScript-Specific Notes:
- Use `Map` for efficient graph storage (better than plain objects for this use case)
- Use `Set` for O(1) membership testing in visited tracking
- Array destructuring: `const [a, b] = equations[i]`
- Array of arrays for storing neighbors: `[[neighbor, weight], ...]`
- Use `||` operator for default empty array when accessing neighbors

## Running the tests:
```bash
node evaluateDivision.js
```
