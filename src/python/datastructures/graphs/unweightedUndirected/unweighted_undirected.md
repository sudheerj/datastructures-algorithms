# Unweighted Undirected Graph

An unweighted undirected graph where edges have no direction and no weight.

## Operations

| Operation     | Time Complexity | Description |
|---------------|-----------------|-------------|
| add_vertex    | O(1)           | Add a new vertex |
| add_edge      | O(1)           | Add an edge between vertices |
| remove_edge   | O(E)           | Remove an edge |
| remove_vertex | O(V + E)       | Remove a vertex and its edges |

## Usage

```python
from unweighted_undirected import Graph

graph = Graph()
graph.add_vertex("A")
graph.add_vertex("B")
graph.add_edge("A", "B")
graph.show_connections()
```
