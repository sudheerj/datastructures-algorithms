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

### Approach 1 — BFS Topological Sort (Kahn's Algorithm) `findOrderBFS`

1. Build `graph[b] = [a, ...]` (prereq → dependents) and `indegrees[]` array of size `numCourses`.
2. For each `[a, b]` in prerequisites: push `a` to `graph[b]`, increment `indegrees[a]`.
3. Enqueue all courses where `indegrees[c] === 0`.
4. While queue is not empty:
   1. Shift `curr`, push to `coursesOrder`.
   2. For each `neighbour` of `curr`: decrement `indegrees[neighbour]`; if `0`, push to queue.
5. Return `coursesOrder` if `length === numCourses`, else `[]`.

### Approach 2 — DFS Topological Sort `findOrderDFS`

1. Build `prereqMap[a] = [b, ...]` (course → its prerequisites).
2. For each course, run `dfs(course)`:
   1. If course is in `visitSet` → cycle, return `false`.
   2. If `prereqMap[course].length === 0` → no more deps, return `true`.
   3. Add course to `visitSet`, recurse on all prerequisites.
   4. Delete from `visitSet`, clear `prereqMap[course]`, push course to `coursesOrder`.
3. Return `coursesOrder` or `[]` on cycle.

**Time and Space complexity:**
Both approaches have time complexity `O(V + E)`, where `V` is `numCourses` and `E` is `prerequisites.length`.

Space complexity is `O(V + E)` for the graph, plus `O(V)` for the queue/stack and visited Set.
