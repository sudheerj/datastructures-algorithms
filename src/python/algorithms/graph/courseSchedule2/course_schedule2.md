**Problem statement:**
There are a total of `numCourses` courses labeled `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a, b]` means you must take course `b` before course `a`. Return **the ordering of courses** you should take to finish all courses. If it is impossible (cycle exists), return an **empty array**.

## Examples:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0, 1]
(Take course 0 first, then course 1)

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3] or [0,1,2,3]
(Course 0 first, then 1 and 2 in either order, then 3)

Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
Output: []
(Cycle: 0 → 1 → 0, impossible to complete all courses)

**Algorithmic Steps**

### Approach 1 — BFS Topological Sort (Kahn's Algorithm) `find_order_bfs`

1. Build a `graph` (prereq → dependents) using `defaultdict(list)` and an `indegrees` list of size `num_courses`.
2. For each `[a, b]` in prerequisites: append `a` to `graph[b]`, increment `indegrees[a]`.
3. Initialize a deque with all courses where `indegrees[c] == 0`.
4. While deque is not empty:
   1. Pop `curr`, append to `courses_order`.
   2. For each `neighbour` of `curr`: decrement `indegrees[neighbour]`; if `0`, append to deque.
5. Return `courses_order` if its length equals `num_courses`, else `[]`.

### Approach 2 — DFS Topological Sort `find_order_dfs`

1. Build `prereq_map` (course → its prerequisites).
2. For each course, run `dfs(course)`:
   1. If course is in `visit_set` → cycle, return `False`.
   2. If `prereq_map[course]` is empty → no more deps, return `True`.
   3. Add course to `visit_set`, recurse on all prerequisites.
   4. Remove from `visit_set`, clear `prereq_map[course]`, append course to `courses_order`.
3. Return `courses_order` or `[]` on cycle.

**Time and Space complexity:**
Both approaches have time complexity `O(V + E)`, where `V` is `num_courses` and `E` is `len(prerequisites)`.

Space complexity is `O(V + E)` for the graph, plus `O(V)` for the deque/stack and visited tracking.
