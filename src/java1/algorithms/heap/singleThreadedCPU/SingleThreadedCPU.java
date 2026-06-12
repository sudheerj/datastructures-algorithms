package java1.algorithms.heap.singleThreadedCPU;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    //Event simulation + Greedy scheduling with MinHeap TC: O(n log n) SC: O(n)
    private int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        //Add index
        int[][] tasksWithIndex = new int[n][3];
        for(int i=0; i<n; i++) {
            tasksWithIndex[i][0] = tasks[i][0]; //enqueing time
            tasksWithIndex[i][1] = tasks[i][1]; //processing time
            tasksWithIndex[i][2] = i;
        }

        //Sort by enqueing time, if tie by index
        Arrays.sort(tasksWithIndex, (a, b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

        int[] tasksOrder = new int[n];
        int i=0, time =0, k =0;

        while(i<n || !pq.isEmpty()) {

            //If not tasks available, jump time forward
            if(pq.isEmpty() && time < tasksWithIndex[i][0]) {
                time = tasksWithIndex[i][0];
            }

            //Push all available tasks
            if(i < n && tasksWithIndex[i][0] <= time) {
                pq.offer(new int[]{tasksWithIndex[i][1], tasksWithIndex[i][2]});
                i++;
            }

            int[] task = pq.poll();
            time += task[0];
            tasksOrder[k++] = task[1];
        }

        return tasksOrder;
    }
}
