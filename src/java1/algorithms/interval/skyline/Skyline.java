package java1.algorithms.interval.skyline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Skyline {

    // Sweep-line + TreeMap(multiset) TC: O(n log n) SC: O(n)
    public List<List<Integer>> getSkyline1(int[][] buildings) {
        // Step1: Start converting buildings into sweepline events
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[] { b[0], -b[2] }); // negative height for start
            events.add(new int[] { b[1], b[2] }); // positive height for end
        }

        // Step2: Sort events by x, if same x sort by height
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // Step3: Treemap stores multiset(height -> frequency)
        // insert: O(log n) remove: O(log n) get max: O(log n)
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1); // ground height always exist

        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        // Step4: Sweepline processing
        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                heights.put(-h, heights.getOrDefault(-h, 0) + 1); // add start building
            } else {
                Integer count = heights.get(h);
                if (count != null) {
                    if (count == 1)
                        heights.remove(h); // remove end building
                    else {
                        heights.put(h, count - 1);
                    }
                }
            }

            int currMaxHeight = heights.lastKey();

            // building height changes -> record it
            if (currMaxHeight != prevMaxHeight) {
                result.add(List.of(x, currMaxHeight)); // Add skyline key points
                prevMaxHeight = currMaxHeight;
            }
        }
        return result;

    }

    // Sweepline + priority queue TC: O(n^2) worst-case SC: O(n)
    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] b : buildings) {
            events.add(new int[] { b[0], -b[2] }); // add start
            events.add(new int[] { b[1], b[2] }); // add end
        }

        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            if (h < 0) {
                pq.add(-h);
            } else {
                pq.remove(h);
            }

            int currMaxHeight = pq.peek();

            if (currMaxHeight != prevMaxHeight) {
                result.add(Arrays.asList(x, currMaxHeight));
                prevMaxHeight = currMaxHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Skyline solver = new Skyline();
        Object[][] tests = {
                // Format: { buildings, expected }
                { new int[][] { { 1, 2, 1 } }, List.of(List.of(1, 1), List.of(2, 0)) },
                { new int[][] { { 0, 2, 3 }, { 2, 5, 3 } }, List.of(List.of(0, 3), List.of(5, 0)) },
                { new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } },
                        List.of(List.of(2, 10), List.of(3, 15), List.of(7, 12), List.of(12, 0), List.of(15, 10),
                                List.of(20, 8), List.of(24, 0)) },
                { new int[][] { { 1, 3, 4 }, { 3, 4, 4 }, { 2, 6, 2 } },
                        List.of(List.of(1, 4), List.of(4, 2), List.of(6, 0)) },
        };
        System.out.println("Testing getSkyline1 (TreeMap):");
        for (Object[] test : tests) {
            int[][] buildings = (int[][]) test[0];
            List<List<Integer>> expected = (List<List<Integer>>) test[1];
            List<List<Integer>> result = solver.getSkyline1(buildings);
            boolean pass = result.equals(expected);
            String status = pass ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
        System.out.println("\nTesting getSkyline2 (PriorityQueue):");
        for (Object[] test : tests) {
            int[][] buildings = (int[][]) test[0];
            List<List<Integer>> expected = (List<List<Integer>>) test[1];
            List<List<Integer>> result = solver.getSkyline2(buildings);
            boolean pass = result.equals(expected);
            String status = pass ? "PASS" : "FAIL";
            System.out.println("[" + status + "] result=" + result + " expected=" + expected);
        }
    }
}
