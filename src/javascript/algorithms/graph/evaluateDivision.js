/**
 * Evaluate Division
 * 
 * Given equations and values representing division relationships,
 * evaluate queries to find division results between variables.
 * 
 * TC: O(E + Q * (V + E)) where E=equations, Q=queries, V=variables
 * SC: O(E + V) for graph storage and recursion stack
 * 
 * @param {string[][]} equations - Array of variable pairs [a, b] representing a/b
 * @param {number[]} values - Array of values for each equation
 * @param {string[][]} queries - Array of query pairs [c, d] to evaluate c/d
 * @return {number[]} Array of results for each query, -1.0 if cannot be determined
 */
function calcEquation(equations, values, queries) {
    // Build the graph
    const graph = new Map();
    
    for (let i = 0; i < equations.length; i++) {
        const [a, b] = equations[i];
        const val = values[i];
        
        if (!graph.has(a)) graph.set(a, []);
        if (!graph.has(b)) graph.set(b, []);
        
        graph.get(a).push([b, val]);
        graph.get(b).push([a, 1.0 / val]);
    }
    
    /**
     * DFS to find path from curr to target, accumulating product
     */
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
        
        return -1.0;
    }
    
    // Process each query
    const results = [];
    for (const [src, dst] of queries) {
        if (!graph.has(src) || !graph.has(dst)) {
            results.push(-1.0);
        } else {
            const visited = new Set();
            results.push(dfs(src, dst, 1.0, visited));
        }
    }
    
    return results;
}


// Test cases
console.log("Test case 1:");
const equations1 = [["a", "b"], ["b", "c"]];
const values1 = [2.0, 3.0];
const queries1 = [["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"]];
const result1 = calcEquation(equations1, values1, queries1);
console.log(`Output: ${JSON.stringify(result1)}`);
console.log("Expected: [6.0, 0.5, -1.0, 1.0, -1.0]");
console.log("Explanation: a/b = 2.0, b/c = 3.0, so a/c = 6.0");
console.log();

console.log("Test case 2:");
const equations2 = [["a", "b"], ["b", "c"], ["bc", "cd"]];
const values2 = [1.5, 2.5, 5.0];
const queries2 = [["a", "c"], ["c", "b"], ["bc", "cd"], ["cd", "bc"]];
const result2 = calcEquation(equations2, values2, queries2);
console.log(`Output: ${JSON.stringify(result2)}`);
console.log("Expected: [3.75, 0.4, 5.0, 0.2]");
console.log();

console.log("Test case 3:");
const equations3 = [["a", "b"]];
const values3 = [0.5];
const queries3 = [["a", "b"], ["b", "a"], ["a", "c"], ["x", "y"]];
const result3 = calcEquation(equations3, values3, queries3);
console.log(`Output: ${JSON.stringify(result3)}`);
console.log("Expected: [0.5, 2.0, -1.0, -1.0]");
console.log();

console.log("Test case 4:");
const equations4 = [["a", "b"], ["b", "c"], ["c", "d"]];
const values4 = [2.0, 3.0, 4.0];
const queries4 = [["a", "d"], ["d", "a"]];
const result4 = calcEquation(equations4, values4, queries4);
console.log(`Output: ${JSON.stringify(result4)}`);
console.log("Expected: [24.0, 0.04166...]");
console.log("Explanation: a/d = (a/b) * (b/c) * (c/d) = 2 * 3 * 4 = 24");
console.log();

console.log("Test case 5:");
const equations5 = [["x1", "x2"], ["x2", "x3"], ["x3", "x4"], ["x4", "x5"]];
const values5 = [3.0, 4.0, 5.0, 6.0];
const queries5 = [["x1", "x5"], ["x5", "x2"], ["x2", "x4"], ["x2", "x2"], ["x2", "x9"]];
const result5 = calcEquation(equations5, values5, queries5);
console.log(`Output: ${JSON.stringify(result5)}`);
console.log("Expected: [360.0, 0.04166..., 20.0, 1.0, -1.0]");
console.log("Explanation: x1/x5 = 3 * 4 * 5 * 6 = 360");

module.exports = calcEquation;
