package java1.algorithms.graph.courseSchedule2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule2 {
    //BFS Topological sort TC: O(V+E) SC: O(V+E)
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];

        //Initialize graph
        for(int i=0; i<numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        //build the graph
        for(int[] prereq: prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }

        int[] coursesOrder = new int[numCourses];
        int index = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int course=0; course<numCourses; course++) {
            if(indegrees[course] == 0) {
                queue.add(course);
            }
        }

        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            coursesOrder[index++] = currCourse;

            for(int neighbour: graph.get(currCourse)) {
                indegrees[neighbour]--;
                if(indegrees[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return index == numCourses ? coursesOrder : new int[0];
    }

    //DFS Topological sorting TC: O(V+E) SC: O(V+E)
    private int[] findOrderDFSTopological(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            
        }
    }

    //DFS TC: O(V+E) SC: O(V+E)
    private int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        List<Integer> coursesOrder = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] prereq: prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visitSet = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i, visitSet, prereqMap, coursesOrder)) return new int[0];
        }

        return coursesOrder.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(int course, Set<Integer> visitSet, Map<Integer, List<Integer>> prereqMap, List<Integer> coursesOrder) {
        if(visitSet.contains(course))  return false;
        if(prereqMap.get(course) == null) return true;  // already fully processed

        visitSet.add(course);
        for(int neighbour: prereqMap.get(course)) {
            if(!dfs(neighbour, visitSet, prereqMap, coursesOrder)) return false;
        }
        visitSet.remove(course);
        coursesOrder.add(course);
        prereqMap.put(course, null);  // mark as processed

        return true;
    }

    private static String pass(boolean ok) { return ok ? "PASS" : "FAIL"; }

    public static void main(String[] args) {
        CourseSchedule2 sol = new CourseSchedule2();

        int[][] tests_numCourses = {{2}, {4}, {2}, {3}, {1}};
        int[][][] tests_prereqs = {
            {{1, 0}},
            {{1,0},{2,0},{3,1},{3,2}},
            {{0,1},{1,0}},
            {},
            {}
        };
        boolean[] hasOrder = {true, true, false, true, true};
        String[] labels = {
            "linear chain (n=2)",
            "diamond graph (n=4)",
            "cycle — impossible (n=2)",
            "no prerequisites (n=3)",
            "single course (n=1)"
        };

        System.out.println("=== BFS ===");
        for (int i = 0; i < labels.length; i++) {
            int[] result = sol.findOrder(tests_numCourses[i][0], tests_prereqs[i]);
            boolean valid = (result.length == tests_numCourses[i][0]) == hasOrder[i];
            System.out.println("  [" + pass(valid) + "] " + labels[i] + ": " + java.util.Arrays.toString(result));
        }

        System.out.println("=== DFS ===");
        for (int i = 0; i < labels.length; i++) {
            int[] result = sol.findOrderDFS(tests_numCourses[i][0], tests_prereqs[i]);
            boolean valid = (result.length == tests_numCourses[i][0]) == hasOrder[i];
            System.out.println("  [" + pass(valid) + "] " + labels[i] + ": " + java.util.Arrays.toString(result));
        }
    }
}
