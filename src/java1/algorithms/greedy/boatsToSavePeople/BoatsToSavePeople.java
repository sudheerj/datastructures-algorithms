package java1.algorithms.greedy.boatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {
    //Two-pointer solution + Sorting TC: O(n log n) SC: O(n) 
    // Pair lightest persion with heaviest persion. If not possible, heaviest person go alone
    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length-1, minBoats = 0;

        while (left <= right) {
            if(people[left] + people[right] <= limit) left++;

            right--;
            minBoats++;
        }

        return minBoats;
    }

    public static void main(String[] args) {

        System.out.println(numRescueBoats(new int[]{1, 2}, 3));                  // 1
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));            // 3
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));            // 4
        System.out.println(numRescueBoats(new int[]{1, 1, 1, 1}, 2));            // 2
        System.out.println(numRescueBoats(new int[]{2, 2, 2, 2}, 4));            // 2
        System.out.println(numRescueBoats(new int[]{2, 2, 2}, 4));               // 2
        System.out.println(numRescueBoats(new int[]{5, 1, 4, 2}, 6));            // 2
        System.out.println(numRescueBoats(new int[]{5, 2, 3}, 5));               // 2
        System.out.println(numRescueBoats(new int[]{4}, 5));                     // 1
        System.out.println(numRescueBoats(new int[]{1, 2, 3, 4, 5}, 5));         // 3
        System.out.println(numRescueBoats(new int[]{1, 1, 2, 2, 3, 3}, 4));      // 3
        System.out.println(numRescueBoats(new int[]{6, 6, 6}, 6));               // 3
        System.out.println(numRescueBoats(new int[]{1, 2, 2, 3, 4}, 5));         // 3
        System.out.println(numRescueBoats(new int[]{1, 3, 4, 5}, 5));            // 3
        System.out.println(numRescueBoats(new int[]{2, 3}, 5));                  // 1
        System.out.println(numRescueBoats(new int[]{2, 3}, 4));                  // 2
        System.out.println(numRescueBoats(new int[]{1, 2, 2, 2, 3}, 4));         // 3
        System.out.println(numRescueBoats(new int[]{1, 1, 1, 2, 2, 3}, 3));      // 4
        System.out.println(numRescueBoats(new int[]{3, 3, 3, 3}, 6));            // 2
        System.out.println(numRescueBoats(new int[]{3, 3, 3, 3}, 5));            // 4
    }
}
