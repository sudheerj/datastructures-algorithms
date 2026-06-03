package java1.algorithms.graph.shortestPath.busRoutes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {
    //BFS Shortest path TC: O(n * m) SC: O(n * m) n= number of buses(routes) m = avg number of stops in each route
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        //Stop -> list of buses passing this stop
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for(int bus=0; bus<routes.length; bus++) {
            for(int stop: routes[bus]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        Queue<Integer> queue = new LinkedList<>(); //Store stops
        queue.add(source);
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        visitedStops.add(source);

        int busesTaken = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++; //each level -> take 1 more bus

            for(int i=0; i<size; i++) {
                int stop = queue.poll();

                //list of buses passes this stop
                List<Integer> buses = stopToBuses.getOrDefault(stop, new ArrayList<>());

                for(int bus: buses) {
                    if(visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    //travel through this bus -> reach all stops
                    for(int nextStop: routes[bus]){
                        if(nextStop == target) {
                            return busesTaken;
                        }
                        if(!visitedStops.contains(nextStop)) {
                            queue.add(nextStop);
                            visitedStops.add(nextStop);
                        };
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BusRoutes solution = new BusRoutes();

        // Test case 1
        int[][] routes1 = {{1, 2, 7}, {3, 6, 7}};
        int source1 = 1, target1 = 6;
        int result1 = solution.numBusesToDestination(routes1, source1, target1);
        System.out.println("Test case 1: routes = [[1,2,7],[3,6,7]], source = 1, target = 6");
        System.out.println("Output: " + result1);
        System.out.println("Expected: 2");
        System.out.println("Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.");
        System.out.println();

        // Test case 2
        int[][] routes2 = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        int source2 = 15, target2 = 12;
        int result2 = solution.numBusesToDestination(routes2, source2, target2);
        System.out.println("Test case 2: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12");
        System.out.println("Output: " + result2);
        System.out.println("Expected: -1");
        System.out.println("Explanation: There is no way to reach stop 12 from stop 15.");
        System.out.println();

        // Test case 3
        int[][] routes3 = {{1, 7}, {3, 5}};
        int source3 = 5, target3 = 5;
        int result3 = solution.numBusesToDestination(routes3, source3, target3);
        System.out.println("Test case 3: routes = [[1,7],[3,5]], source = 5, target = 5");
        System.out.println("Output: " + result3);
        System.out.println("Expected: 0");
        System.out.println("Explanation: Already at the target, no buses needed.");
        System.out.println();

        // Test case 4
        int[][] routes4 = {{1, 2, 3, 4}, {3, 4, 5, 6}};
        int source4 = 1, target4 = 6;
        int result4 = solution.numBusesToDestination(routes4, source4, target4);
        System.out.println("Test case 4: routes = [[1,2,3,4],[3,4,5,6]], source = 1, target = 6");
        System.out.println("Output: " + result4);
        System.out.println("Expected: 2");
        System.out.println("Explanation: Take first bus to stop 3 or 4, then take second bus to stop 6.");
        System.out.println();

        // Test case 5
        int[][] routes5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int source5 = 1, target5 = 9;
        int result5 = solution.numBusesToDestination(routes5, source5, target5);
        System.out.println("Test case 5: routes = [[1,2,3],[4,5,6],[7,8,9]], source = 1, target = 9");
        System.out.println("Output: " + result5);
        System.out.println("Expected: -1");
        System.out.println("Explanation: No connection between buses, impossible to reach target.");
    }
}
