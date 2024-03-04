package java1.algorithms.graph;

import java.util.*;

public class CourseSchedule {
    //BFS:==> TC: O(V+E) SC: O(V)
    private static boolean canFinish(int numCourses, int[][] prerequisites){
        Map<Integer, List<Integer>> adj = new HashMap<>(); 
        int[] indegree = new int[numCourses];

        for(int i=0; i< numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i< prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        int enrolled = 0;
        Queue<Integer> queue= new LinkedList<Integer>();
        for(int node=0; node< indegree.length; node++) {
            if(indegree[node] == 0) {
                queue.add(node);
                enrolled++;
            }
        }

        while(!queue.isEmpty()) {
            int currCourse = queue.poll();
            for(int neighbour: adj.get(currCourse)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                    enrolled++;
                }
            }
        }
        return enrolled == numCourses;
    }

    public static void main(String[] args) {
        int numCourses1 =6;
        int[][] prerequisites1 = {{0,4}, {0,5}, {1, 3}, {1, 4}, {2, 5}, {3, 2}};
        int numCourses2 =2;
        int[][] prerequisites2 = {{0,1}, {1,0}};
        System.out.println(canFinish(numCourses1, prerequisites1));
        System.out.println(canFinish(numCourses2, prerequisites2));
    }
    
}
