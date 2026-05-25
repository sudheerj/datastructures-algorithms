"""
Course Schedule II (LeetCode 210)

Return the ordering of courses to finish all numCourses, or [] if impossible.

Approach 1: BFS Topological Sort (Kahn's Algorithm)  TC: O(V+E)  SC: O(V+E)
Approach 2: DFS Topological Sort                      TC: O(V+E)  SC: O(V+E)
"""

from collections import deque, defaultdict


# --- Approach 1: BFS (Kahn's Algorithm) ---
def find_order_bfs(num_courses, prerequisites):
    graph = defaultdict(list)
    indegrees = [0] * num_courses

    for a, b in prerequisites:
        graph[b].append(a)
        indegrees[a] += 1

    queue = deque(c for c in range(num_courses) if indegrees[c] == 0)
    courses_order = []

    while queue:
        curr = queue.popleft()
        courses_order.append(curr)
        for neighbour in graph[curr]:
            indegrees[neighbour] -= 1
            if indegrees[neighbour] == 0:
                queue.append(neighbour)

    return courses_order if len(courses_order) == num_courses else []


# --- Approach 2: DFS ---
def find_order_dfs(num_courses, prerequisites):
    prereq_map = defaultdict(list)
    for a, b in prerequisites:
        prereq_map[a].append(b)

    visit_set = set()
    courses_order = []

    def dfs(course):
        if course in visit_set:
            return False
        if prereq_map[course] is None:  # already fully processed
            return True
        visit_set.add(course)
        for neighbour in prereq_map[course]:
            if not dfs(neighbour):
                return False
        visit_set.remove(course)
        prereq_map[course] = None  # mark as processed
        courses_order.append(course)
        return True

    for i in range(num_courses):
        if not dfs(i):
            return []

    return courses_order


if __name__ == "__main__":
    test_cases = [
        (2, [[1, 0]],                       True,  "linear chain (n=2)"),
        (4, [[1,0],[2,0],[3,1],[3,2]],       True,  "diamond graph (n=4)"),
        (2, [[0,1],[1,0]],                   False, "cycle — impossible (n=2)"),
        (3, [],                              True,  "no prerequisites (n=3)"),
        (1, [],                              True,  "single course (n=1)"),
    ]

    print("=== BFS ===")
    for num, prereqs, has_order, label in test_cases:
        result = find_order_bfs(num, prereqs)
        valid = (len(result) == num) == has_order
        print(f"  [{'PASS' if valid else 'FAIL'}] {label}: {result}")

    print("=== DFS ===")
    for num, prereqs, has_order, label in test_cases:
        result = find_order_dfs(num, prereqs)
        valid = (len(result) == num) == has_order
        print(f"  [{'PASS' if valid else 'FAIL'}] {label}: {result}")
