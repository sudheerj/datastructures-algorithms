package java1.algorithms.graph.winnerOfCircularGame;

import java.util.LinkedList;
import java.util.Queue;

public class WinnerOfCircularGame {
    //Using queue TC: O(n * k) SC: O(n)
    private  int winnerOfCircularGame1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        //Add n people to the queue
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        //Iterate until queue has one person
        while(queue.size() > 1) {
            //Remove k-1 people from front and add them to back
            for(int j=1; j<k; j++) {
                queue.offer(queue.poll());
            }
            //Eliminate Kth person
            queue.poll();
        }

        return queue.peek();
    } 

    //Iterative Josephus problem TC: O(n) SC: O(1)
    private static int winnerOfCircularGame2(int n, int k) {
         //base case for 1 person(0-based indexing)
         int winner = 0;

         //find winner from smaller circles to bigger circles
         for(int i=2; i<=n; i++) {
            winner = (winner + k)%i;
         }

         //convert from 0-based indexing to 1-based persons
         return winner + 1;
    }

    //Recursive Josephus problem TC: O(n) SC: O(1)
    private static int winnerOfCircularGame3(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        if(n == 1) {
            return 0; // 0 index as winner for 1 person in circle
        }

        return (josephus(n-1, k) + k) %n;
    }


    public static void main(String[] args) {
        WinnerOfCircularGame obj = new WinnerOfCircularGame();

        // --- winnerOfCircularGame1 (Queue simulation) ---
        System.out.println("=== Queue Simulation ===");
        System.out.println("Test 1: " + obj.winnerOfCircularGame1(5, 2)); // 3
        System.out.println("Test 2: " + obj.winnerOfCircularGame1(6, 5)); // 1
        System.out.println("Test 3: " + obj.winnerOfCircularGame1(1, 1)); // 1
        System.out.println("Test 4: " + obj.winnerOfCircularGame1(4, 1)); // 4
        System.out.println("Test 5: " + obj.winnerOfCircularGame1(3, 3)); // 2

        // --- winnerOfCircularGame2 (Iterative Josephus) ---
        System.out.println("=== Iterative Josephus ===");
        System.out.println("Test 1: " + winnerOfCircularGame2(5, 2)); // 3
        System.out.println("Test 2: " + winnerOfCircularGame2(6, 5)); // 1
        System.out.println("Test 3: " + winnerOfCircularGame2(1, 1)); // 1
        System.out.println("Test 4: " + winnerOfCircularGame2(4, 1)); // 4
        System.out.println("Test 5: " + winnerOfCircularGame2(3, 3)); // 2

        // --- winnerOfCircularGame3 (Recursive Josephus) ---
        System.out.println("=== Recursive Josephus ===");
        System.out.println("Test 1: " + winnerOfCircularGame3(5, 2)); // 3
        System.out.println("Test 2: " + winnerOfCircularGame3(6, 5)); // 1
        System.out.println("Test 3: " + winnerOfCircularGame3(1, 1)); // 1
        System.out.println("Test 4: " + winnerOfCircularGame3(4, 1)); // 4
        System.out.println("Test 5: " + winnerOfCircularGame3(3, 3)); // 2
    }
}
