"""
Course Schedule

There are numCourses courses you have to take, labeled from 0 to numCourses - 1.
Prerequisites[i] = [ai, bi] indicates you must take course bi first to take ai.
Return true if you can finish all courses.

Time Complexity: O(V + E)
Space Complexity: O(V + E)
"""

from collections import defaultdict, deque


def can_finish_dfs(num_courses, prerequisites):
    """
    DFS approach - detect cycle.
    TC: O(V + E), SC: O(V + E)
    """
    graph = defaultdict(list)
    for course, prereq in prerequisites:
        graph[course].append(prereq)
    
    # States: 0 = unvisited, 1 = visiting, 2 = visited
    state = [0] * num_courses
    
    def has_cycle(course):
        if state[course] == 1:  # Cycle detected
            return True
        if state[course] == 2:  # Already processed
            return False
        
        state[course] = 1  # Mark as visiting
        
        for prereq in graph[course]:
            if has_cycle(prereq):
                return True
        
        state[course] = 2  # Mark as visited
        return False
    
    for course in range(num_courses):
        if has_cycle(course):
            return False
    
    return True


def can_finish_bfs(num_courses, prerequisites):
    """
    BFS approach - Kahn's algorithm (topological sort).
    TC: O(V + E), SC: O(V + E)
    """
    graph = defaultdict(list)
    in_degree = [0] * num_courses
    
    for course, prereq in prerequisites:
        graph[prereq].append(course)
        in_degree[course] += 1
    
    queue = deque([i for i in range(num_courses) if in_degree[i] == 0])
    completed = 0
    
    while queue:
        course = queue.popleft()
        completed += 1
        
        for next_course in graph[course]:
            in_degree[next_course] -= 1
            if in_degree[next_course] == 0:
                queue.append(next_course)
    
    return completed == num_courses


# Test cases
if __name__ == "__main__":
    test_cases = [
        {"numCourses": 2, "prerequisites": [[1, 0]]},           # True
        {"numCourses": 2, "prerequisites": [[1, 0], [0, 1]]},   # False (cycle)
    ]
    
    for test in test_cases:
        print(f"Courses: {test['numCourses']}, Prerequisites: {test['prerequisites']}")
        print(f"Can finish (DFS): {can_finish_dfs(test['numCourses'], test['prerequisites'])}")
        print(f"Can finish (BFS): {can_finish_bfs(test['numCourses'], test['prerequisites'])}")
        print()
