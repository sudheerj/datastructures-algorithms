package java1.algorithms.graph.courseSchedule;

import java.util.*;

public class CourseSchedule {
    //DFS:==> TC: O(V+E) SC: O(V+E)
    private static boolean canFinish1(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            prereqMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            prereqMap.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visitSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, prereqMap, visitSet)) return false;
        }

        return true;

    }

    private static boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visitSet){
            if(visitSet.contains(course)) return false;
            if(prereqMap.get(course).size() == 0) return true;

            visitSet.add(course);
            for (Integer pre : prereqMap.get(course)) {
                if(!dfs(pre, prereqMap, visitSet)) return false;
            }
            visitSet.remove(course);
            prereqMap.put(course, new ArrayList<>());
            return true;

    }
    //BFS:==> TC: O(V+E) SC: O(V+E)
    private static boolean canFinish2(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> adjacenyMap = new HashMap<>(); 
        int[] indegree = new int[numCourses];

        for(int i=0; i< numCourses; i++) {
            adjacenyMap.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i< prerequisites.length; i++) {
            adjacenyMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        int enrolledCourses = 0;
        Queue<Integer> queue= new LinkedList<Integer>();
        for(int course=0; course< indegree.length; course++) {
            if(indegree[course] == 0) {
                queue.add(course);
                enrolledCourses++;
            }
        }

        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            for(int neighbour: adjacenyMap.get(currCourse)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                    enrolledCourses++;
                }
            }
        }
        return enrolledCourses == numCourses;
    }

    public static void main(String[] args) {
        int numCourses1 =6;
        int[][] prerequisites1 = {{0,4}, {0,5}, {1, 3}, {1, 4}, {2, 5}, {3, 2}};
        int numCourses2 =2;
        int[][] prerequisites2 = {{0,1}, {1,0}};
        System.out.println(canFinish1(numCourses1, prerequisites1));
        System.out.println(canFinish1(numCourses2, prerequisites2));
        System.out.println(canFinish2(numCourses1, prerequisites1));
        System.out.println(canFinish2(numCourses2, prerequisites2));
    }
    
}
