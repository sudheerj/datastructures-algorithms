package java1.algorithms.priorityQueue.taskScheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    private static int leastIntervals(char[] tasks, int n) {
        int[] charFrequency = new int[26];

        //Count task frequencies
        for(char task: tasks) {
            charFrequency[task-'A']++;
        }

        //Max heap with high frequency at top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int freq: charFrequency) {
            if(freq >0) pq.offer(freq);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;

            //fill one cycle
            while(cycle > 0 && !pq.isEmpty()) {
                int curr = pq.poll();

                if(curr>1) {
                    temp.add(curr-1);
                }

                time++;
                cycle--;
            }

            //Push remaining tasks back
            pq.addAll(temp);

            //Add idle time if tasks remain
            if(!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;

    }

    public static void main(String[] args) {
        char[][] taskSets = {
            {'A','A','A','B','B','B'},
            {'A','A','A','B','B','B'},
            {'A','A','A','B','B','B','C','C'},
            {'A','A','A','A','A'},
            {'A','B','C','D','E','F'},
            {'A','A','B','B'},
            {'A','A','A','B'},
            {'A','A'},
            {'A'},
            {'A','A','A','B','B','C'}
        };
        int[] ns       = {2, 0, 2, 2, 2, 1, 2, 3, 0, 2};
        int[] expected = {8, 6, 8, 13, 6, 4, 7, 5, 1, 7};

        for (int i = 0; i < taskSets.length; i++) {
            int result = leastIntervals(taskSets[i], ns[i]);
            String status = result == expected[i] ? "PASS" : "FAIL (expected " + expected[i] + ")";
            System.out.println("tasks=" + new String(taskSets[i]) + ", n=" + ns[i] + " => " + result + " " + status);
        }
    }
}
