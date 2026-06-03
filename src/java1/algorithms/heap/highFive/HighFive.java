package java1.algorithms.heap.highFive;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    //Tree map with min heap for top 5 scores TC: O(n log 5) ~= O(n) SC: O(n) 
    public static int[][] highFive(int[][] items) {
        // Map student id -> min heap of top 5 scores
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(id);

            pq.offer(score);

            if (pq.size() > 5) {
                pq.poll();
            }
        }

        int[][] result = new int[map.size()][2];
        int index = 0;

        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);

            int sum = 0;

            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            result[index][0] = id;
            result[index][1] = sum / 5;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        // Test 1: Multiple students with more than 5 scores each
        // Student 1 top-5: [65,87,91,92,100] -> avg = 87
        // Student 2 top-5: [76,77,93,97,100] -> avg = 88
        int[][] items1 = { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 2, 100 },
                { 1, 87 }, { 1, 100 }, { 2, 76 } };
        System.out.println("Test 1: " + java.util.Arrays.deepToString(highFive(items1))); // [[1,87],[2,88]]

        // Test 2: Exactly 5 scores per student
        // [90,80,70,60,50] -> sum=350, avg=70
        int[][] items2 = { { 1, 90 }, { 1, 80 }, { 1, 70 }, { 1, 60 }, { 1, 50 } };
        System.out.println("Test 2: " + java.util.Arrays.deepToString(highFive(items2))); // [[1,70]]

        // Test 3: Low score excluded from top-5
        // top-5 are all 100s -> avg=100
        int[][] items3 = { { 1, 100 }, { 1, 100 }, { 1, 100 }, { 1, 100 }, { 1, 100 }, { 1, 1 } };
        System.out.println("Test 3: " + java.util.Arrays.deepToString(highFive(items3))); // [[1,100]]

        // Test 4: Three students with equal averages
        // Each: [100,80,60,40,20] -> sum=300, avg=60
        int[][] items4 = {
                { 1, 100 }, { 2, 100 }, { 3, 100 },
                { 1, 80 }, { 2, 80 }, { 3, 80 },
                { 1, 60 }, { 2, 60 }, { 3, 60 },
                { 1, 40 }, { 2, 40 }, { 3, 40 },
                { 1, 20 }, { 2, 20 }, { 3, 20 }
        };
        System.out.println("Test 4: " + java.util.Arrays.deepToString(highFive(items4))); // [[1,60],[2,60],[3,60]]

        // Test 5: Floor division
        // [88,89,90,91,92] -> sum=450, avg=90
        int[][] items5 = { { 1, 88 }, { 1, 89 }, { 1, 90 }, { 1, 91 }, { 1, 92 } };
        System.out.println("Test 5: " + java.util.Arrays.deepToString(highFive(items5))); // [[1,90]]

        // Test 6: Result sorted by student id regardless of input order
        int[][] items6 = { { 3, 80 }, { 3, 80 }, { 3, 80 }, { 3, 80 }, { 3, 80 }, { 1, 60 }, { 1, 60 }, { 1, 60 },
                { 1, 60 }, { 1, 60 } };
        System.out.println("Test 6: " + java.util.Arrays.deepToString(highFive(items6))); // [[1,60],[3,80]]
    }
}
