package java1.algorithms.graph.topologicalSort.courseSchedule;

import java.util.*;

public class CourseSchedule {
    // Recursive DFS:==> TC: O(V+E) SC: O(V+E)
    private static boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.get(course).add(pre);
        }

        // 0=unvisited, 1=currentlyVisiting, 2=processed
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        // Cycle detected
        if (state[course] == 1) {
            return false;
        }

        // Already processed
        if (state[course] == 2) {
            return true;
        }

        // Currently processing
        state[course] = 1;

        for (int prerequiste : graph.get(course)) {
            if (!dfs(prerequiste, graph, state)) {
                return false;
            }
        }

        state[course] = 2;
        return true;
    }

    // BFS Topological sort(or Kahn's algorithm) ==> TC: O(V+E) SC: O(V+E)
    private static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); // adjacency list
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        int enrolledCourses = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.add(course);
                enrolledCourses++;
            }
        }

        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            for (int neighbour : graph.get(currCourse)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                    enrolledCourses++;
                }
            }
        }
        return enrolledCourses == numCourses;
    }

    private static boolean canFinish3(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            prereqMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visitSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs1(i, prereqMap, visitSet))
                return false;
        }

        return true;

    }

    private static boolean dfs1(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visitSet) {
        if (visitSet.contains(course))
            return false;
        if (prereqMap.get(course).size() == 0)
            return true;

        visitSet.add(course);
        for (Integer pre : prereqMap.get(course)) {
            if (!dfs1(pre, prereqMap, visitSet))
                return false;
        }
        visitSet.remove(course);
        prereqMap.put(course, new ArrayList<>());
        return true;

    }

    public static void main(String[] args) {
        int numCourses1 = 6;
        int[][] prerequisites1 = { { 0, 4 }, { 0, 5 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 3, 2 } };
        int numCourses2 = 2;
        int[][] prerequisites2 = { { 0, 1 }, { 1, 0 } };
        System.out.println(canFinish1(numCourses1, prerequisites1));
        System.out.println(canFinish1(numCourses2, prerequisites2));
        System.out.println(canFinish2(numCourses1, prerequisites1));
        System.out.println(canFinish2(numCourses2, prerequisites2));
        System.out.println(canFinish3(numCourses1, prerequisites1));
        System.out.println(canFinish3(numCourses2, prerequisites2));
    }

}
