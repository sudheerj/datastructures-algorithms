# Cycle Detection in a String Graph

## Problem statement

Given a list of non-empty strings, treat each string as a vertex in a directed graph. Add a directed edge from word `i` to word `j` when `i != j` and the last character of word `i` matches the first character of word `j`. Determine whether the resulting graph contains a directed cycle.

## Examples

### Example 1: Cycle exists

Input: `words = ["abc", "cdg", "gza"]`

Output: `true`

Explanation: `abc -> cdg` because both meet at `c`; `cdg -> gza` because both meet at `g`; and `gza -> abc` because both meet at `a`. These edges form a directed cycle.

### Example 2: No cycle

Input: `words = ["ab", "bc", "cd"]`

Output: `false`

Explanation: The edges form a path `ab -> bc -> cd`, with no edge returning to an earlier word.

### Example 3: Disconnected components

Input: `words = ["ab", "bc", "xy", "yz"]`

Output: `false`

Explanation: The generated graph contains separate paths. DFS must check every unvisited component.

## Algorithm: DFS with three states

Construct an adjacency list by checking each ordered pair of distinct words. Use a state array to track each vertex:

- `0`: unvisited
- `1`: currently being explored (on the DFS recursion path)
- `2`: fully explored

For each unvisited vertex, run DFS. Encountering a vertex in state `1` means there is a back edge to the current recursion path and therefore a directed cycle. After exploring all neighbors, mark the vertex state `2`. If all vertices are explored without finding a back edge, return `false`.

**Time complexity:** `O(V^2 + V + E)`, where `V` is the number of words and `E` is the number of generated edges. Pairwise graph construction takes `O(V^2)`.

**Space complexity:** `O(V + E)` for the adjacency list, state array, and recursion stack.

## Java implementation

[StringsGraphCycle.java](./StringsGraphCycle.java)
