**Problem statement:**
Given an array `prerequisites` course pairs where `prerequisites[i] = [a, b]` indicates that you must take course `b` first if you want to take course `a`. There are a total of `numCourses` courses you are required to take, labeled from `0` to `numCourses - 1`.

For example, the pair [0, 1], indicates that must take course 1 before taking course 0.

Return `true` if it is possible to finish all courses, otherwise return `false`.

## Examples:
Example1:

Input: numCourses = 2, prerequisites = [[0,1]]

Output: true

Example2:

Input: numCourses = 2, prerequisites = [[0,1],[1,0]]

Output: false

**Algorithmic Steps**
This problem is solved by DFS using recursion. The algorithmic approach can be summarized as follows: 

1. Create a function(`canFinish1`) to determine all courses can be finished or not  with number of courses(`numCourses`) and prerequisite courses(`prerequisites`) as their properties.
   
2. Create a prerequisite map property(`prereqMap`) with key as a course name and value as list of prerequistes for the given course
   
3. Iterate over all the courses and update the prerequisite map values as empty array.
   
4. Iterate over the prerequistes and update the prerequisite map with their respective given prerequisite courses.

5. Create a dfs function(`dfs`) to determine whether any cycle/loop exists with the given prerequisites or not. If the courses forms a cycle, all the courses cannot be completed.
   
   1. This function accepts current course, prerequisite map and visit course set as input parameters.
   2. If the course already present in visit set, return `false` indicating that all courses cannot be finished due to a cycle.
   3. Return `true` if there are no prerequiste for the given course.
   4. Add the current course to the visit set since the course is processed.
   5. Iterate over each prerequiste course and perform DFS function on each course. Return `false` if dfs function return `false` for any course.
   6. Remove the current course from the visit set because the current path is traversed.
   7. Reset the prerequiste map for given course to empty array. This is because all prerequiste courses are processed.
   8. At the end, Return `true` from dfs function indicating that all courses can be finished. 

6. Create a visit course set to track the already enrolled courses along the DFS path or not.
   
7. Invoke the dfs function for each course and return false if any course path cannot be finished.
8. As a last step, return `true` indicating that all courses can be completed.

**Time and Space complexity:**
This algorithm has a time complexity of `O(V+E)`, where `V` is the number of courses in graph and `E` is the number of edges. This is because each course is visited exactly once during the traversal of dfs function, results in `V` time complexity. While visiting each course, all of its prerequistes(edges) are iterated to find any possible cycles, contributing to `E` time complexity. Hence, the overall time complexity is `O(V+E)`.

The `canFinish1` function requires `O(V+E)` space complexity, where `V` is the number of courses in the graph and `E` is the number of edges. This is because the prequisite map(or adjacency map) dominates the memory to store the nodes and their prerequisites. 
