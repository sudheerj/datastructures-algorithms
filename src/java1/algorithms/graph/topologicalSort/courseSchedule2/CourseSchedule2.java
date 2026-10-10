package java1.algorithms.graph.topologicalSort.courseSchedule2;

import java.util.*;

public class CourseSchedule2 {
    // BFS Topological sort (Kahn's algorithm): TC O(V + E), SC O(V + E)
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course, so indegree counts remaining prerequisites
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        int[] courseOrder = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            courseOrder[index++] = currentCourse;

            for (int neighbor : graph.get(currentCourse)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return index == numCourses ? courseOrder : new int[0];
    }

    // Recursive DFS: TC O(V + E), SC O(V + E)
    private int[] findOrderDFSTopological(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // course -> prerequisite; postorder places prerequisites first
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        // 0 = unvisited, 1 = currently visiting, 2 = processed
        int[] state = new int[numCourses];
        List<Integer> courseOrder = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, graph, state, courseOrder)) {
                return new int[0];
            }
        }

        return courseOrder.stream().mapToInt(course -> course).toArray();
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state, List<Integer> courseOrder) {
        if (state[course] == 1) {
            return false;
        }
        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;
        for (int prerequisite : graph.get(course)) {
            if (!dfs(prerequisite, graph, state, courseOrder)) {
                return false;
            }
        }

        state[course] = 2;
        courseOrder.add(course);
        return true;
    }

    // Retained as an alias for the earlier DFS approach.
    private int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        return findOrderDFSTopological(numCourses, prerequisites);
    }

    private static String pass(boolean ok) {
        return ok ? "PASS" : "FAIL";
    }

    public static void main(String[] args) {
        CourseSchedule2 solution = new CourseSchedule2();

        int[] testNumCourses = { 2, 4, 2, 3, 1 };
        int[][][] testPrerequisites = {
                { { 1, 0 } },
                { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } },
                { { 0, 1 }, { 1, 0 } },
                {},
                {}
        };
        boolean[] hasOrder = { true, true, false, true, true };
        String[] labels = {
                "linear chain (n=2)",
                "diamond graph (n=4)",
                "cycle — impossible (n=2)",
                "no prerequisites (n=3)",
                "single course (n=1)"
        };

        System.out.println("=== BFS ===");
        for (int i = 0; i < labels.length; i++) {
            int[] result = solution.findOrder(testNumCourses[i], testPrerequisites[i]);
            boolean valid = (result.length == testNumCourses[i]) == hasOrder[i];
            System.out.println("  [" + pass(valid) + "] " + labels[i] + ": " + Arrays.toString(result));
        }

        System.out.println("=== DFS ===");
        for (int i = 0; i < labels.length; i++) {
            int[] result = solution.findOrderDFS(testNumCourses[i], testPrerequisites[i]);
            boolean valid = (result.length == testNumCourses[i]) == hasOrder[i];
            System.out.println("  [" + pass(valid) + "] " + labels[i] + ": " + Arrays.toString(result));
        }
    }
}
