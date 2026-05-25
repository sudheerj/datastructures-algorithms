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

### Approach 1 — BFS Topological Sort (Kahn's Algorithm) `findOrder`

1. Build an adjacency list `graph` (prereq → dependent) and an `indegrees[]` array of size `numCourses`.
2. For each `[a, b]` in prerequisites: add `a` to `graph[b]`, increment `indegrees[a]`.
3. Enqueue all courses with `indegrees[course] == 0` (no prerequisites).
4. While queue is not empty:
   1. Dequeue `currCourse`, append to `coursesOrder[index++]`.
   2. For each `neighbour` of `currCourse`: decrement `indegrees[neighbour]`; if it becomes `0`, enqueue it.
5. If `index != numCourses`, a cycle exists — return `[]`. Otherwise return `coursesOrder`.

### Approach 2 — DFS Topological Sort `findOrderDFS`

1. Build a `prereqMap` (course → its prerequisites list).
2. For each unvisited course, run `dfs(course)`:
   1. If course is in `visitSet` → cycle detected, return `false`.
   2. If `prereqMap[course]` is empty → no more deps, return `true`.
   3. Add course to `visitSet`, recurse on all prerequisites.
   4. Remove from `visitSet` (backtrack), clear `prereqMap[course]`, append course to `coursesOrder`.
3. Return `coursesOrder` reversed (or built in post-order).

**Time and Space complexity:**
Both approaches have time complexity `O(V + E)`, where `V` is `numCourses` and `E` is `|prerequisites|` — each node and edge is processed once.

Space complexity is `O(V + E)` for the adjacency list, plus `O(V)` for the queue/recursion stack and visited tracking.
