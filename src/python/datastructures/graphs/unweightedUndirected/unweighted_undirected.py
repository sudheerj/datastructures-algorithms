"""
Unweighted Undirected Graph implementation in Python.
"""


class Graph:
    """Unweighted Undirected Graph using adjacency list."""
    
    def __init__(self):
        self.number_of_vertices = 0
        self.adjacent_list = {}

    def add_vertex(self, vertex):
        """Adds a new vertex to the graph."""
        if vertex not in self.adjacent_list:
            self.adjacent_list[vertex] = []
            self.number_of_vertices += 1
            return True
        return False

    def add_edge(self, first_vertex, second_vertex):
        """Adds an edge between two vertices."""
        if first_vertex in self.adjacent_list and second_vertex in self.adjacent_list:
            self.adjacent_list[first_vertex].append(second_vertex)
            self.adjacent_list[second_vertex].append(first_vertex)
            return True
        return False

    def remove_edge(self, first_vertex, second_vertex):
        """Removes an edge between two vertices."""
        if first_vertex in self.adjacent_list and second_vertex in self.adjacent_list:
            self.adjacent_list[first_vertex] = [
                v for v in self.adjacent_list[first_vertex] if v != second_vertex
            ]
            self.adjacent_list[second_vertex] = [
                v for v in self.adjacent_list[second_vertex] if v != first_vertex
            ]
            return True
        return False

    def remove_vertex(self, vertex):
        """Removes a vertex and all its edges from the graph."""
        if vertex not in self.adjacent_list:
            return None
        
        while self.adjacent_list[vertex]:
            temp = self.adjacent_list[vertex].pop()
            self.remove_edge(vertex, temp)
        
        del self.adjacent_list[vertex]
        self.number_of_vertices -= 1
        return self

    def show_connections(self):
        """Displays all connections in the graph."""
        for vertex in self.adjacent_list:
            connections = ' '.join(str(v) for v in self.adjacent_list[vertex])
            print(f"{vertex} --> {connections}")


# Usage example
if __name__ == "__main__":
    my_graph = Graph()
    
    print(my_graph.add_vertex("1"))
    print(my_graph.add_vertex("2"))
    print(my_graph.add_vertex("3"))
    print(my_graph.add_vertex("4"))
    print(my_graph.add_vertex("5"))
    print(my_graph.add_vertex("6"))
    
    print(f"\nGraph: {my_graph.adjacent_list}")
    
    print(my_graph.add_edge("1", "2"))
    print(my_graph.add_edge("1", "3"))
    print(my_graph.add_edge("2", "3"))
    print(my_graph.add_edge("2", "4"))
    print(my_graph.add_edge("3", "5"))
    
    print(f"\nGraph after adding edges: {my_graph.adjacent_list}")
    
    print(my_graph.remove_edge("3", "5"))
    print(my_graph.remove_edge("2", "4"))
    
    print(f"\nGraph after removing edges: {my_graph.adjacent_list}")
    
    print(my_graph.remove_vertex("5"))
    print(my_graph.remove_vertex("4"))
    
    print("\nFinal connections:")
    my_graph.show_connections()
