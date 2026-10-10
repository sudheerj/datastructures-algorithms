package java1.algorithms.greedy.handOfStraights;

import java.util.TreeMap;

public class HandOfStraights {
    // Greedy approach: TC: O(n log n) SC: O(n)
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        // 1. Total must divide evenly
        if (groupSize <= 0 || hand.length % groupSize != 0) {
            return false;
        }

        // 2. Count cards
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // 3. Keep making groups
        while (!map.isEmpty()) {
            int first = map.firstKey();

            // 4. Next first, first+1, first + 2
            for (int card = first; card < first + groupSize; card++) {
                if (!map.containsKey(card)) {
                    return false;
                }

                // Remove one card
                if (map.get(card) == 1) {
                    map.remove(card);
                } else {
                    map.put(card, map.get(card) - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] hands = {
                { 1, 2, 3, 6, 2, 3, 4, 7, 8 },
                { 1, 2, 3, 4, 5 },
                { 1, 1, 2, 2, 3, 3 },
                { 1, 2, 3, 4 },
                { 5, 5, 5, 5 }
        };
        int[] groupSizes = { 3, 4, 3, 3, 1 };
        boolean[] expected = { true, false, true, false, true };

        for (int i = 0; i < hands.length; i++) {
            boolean actual = isNStraightHand(hands[i], groupSizes[i]);
            System.out.println("Test " + (i + 1) + ": expected=" + expected[i]
                    + ", actual=" + actual + (actual == expected[i] ? " [PASS]" : " [FAIL]"));
        }
    }
}
