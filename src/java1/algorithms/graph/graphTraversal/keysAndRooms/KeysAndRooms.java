package java1.algorithms.graph.graphTraversal.keysAndRooms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Graph reachability:- Rooms-> Nodes, Keys -> Edges
public class KeysAndRooms {
    //DFS Recursion TC: O(n + keys) SC: O(n)(recursion stack)
    private boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for(boolean v: visited) {
            if(!v) return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        if(visited[room]) return;

        visited[room] = true;

        for(Integer key: rooms.get(room)) {
            dfs(rooms, key, visited);
        }
    }

    //BFS Recursion TC: O(n + keys) SC: O(n)(Queue)
    private boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currRoom = queue.poll();

            for(int key: rooms.get(currRoom)) {
                if(!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        for(boolean v: visited) {
            if(!v) return false;
        }

        return true;
    }

    // -------- MAIN WITH TEST CASES --------
    public static void main(String[] args) {

        KeysAndRooms keysAndRooms = new KeysAndRooms();

        // Test Case 1 -> true
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));       // room 0
        rooms1.add(Arrays.asList(2));       // room 1
        rooms1.add(Arrays.asList(3));       // room 2
        rooms1.add(new ArrayList<>());      // room 3

        System.out.println("Test 1 (Expected true)");
        System.out.println("DFS: " + keysAndRooms.canVisitAllRoomsDFS(rooms1));
        System.out.println("BFS: " + keysAndRooms.canVisitAllRoomsBFS(rooms1));
        System.out.println();

        // Test Case 2 -> false
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));

        System.out.println("Test 2 (Expected false)");
        System.out.println("DFS: " + keysAndRooms.canVisitAllRoomsDFS(rooms2));
        System.out.println("BFS: " + keysAndRooms.canVisitAllRoomsBFS(rooms2));
        System.out.println();

        // Test Case 3 -> true (single room)
        List<List<Integer>> rooms3 = new ArrayList<>();
        rooms3.add(new ArrayList<>());

        System.out.println("Test 3 (Expected true)");
        System.out.println("DFS: " + keysAndRooms.canVisitAllRoomsDFS(rooms3));
        System.out.println("BFS: " + keysAndRooms.canVisitAllRoomsBFS(rooms3));
        System.out.println();

        // Test Case 4 -> false (disconnected)
        List<List<Integer>> rooms4 = new ArrayList<>();
        rooms4.add(Arrays.asList(1));
        rooms4.add(new ArrayList<>());
        rooms4.add(Arrays.asList(3));
        rooms4.add(new ArrayList<>());

        System.out.println("Test 4 (Expected false)");
        System.out.println("DFS: " + keysAndRooms.canVisitAllRoomsDFS(rooms4));
        System.out.println("BFS: " + keysAndRooms.canVisitAllRoomsBFS(rooms4));
    }
}
