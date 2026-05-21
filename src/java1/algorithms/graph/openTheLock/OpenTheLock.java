import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    //BFS TC:O(10 ^4) SC: O(10 ^4)
    private int openTheLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        //cannot start if starting point itself is blocked
        if(dead.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add("0000");
        visited.add("0000");

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            //process one BFS level
            for(int i=0; i< size; i++) {
                String current = queue.poll();

                //found target
                if(current.equals(target)) return steps;
                char[] arr = current.toCharArray();

                //try rotating 4 wheels
                for(int j=0; j<4; j++) {
                    char original = arr[j];

                    //Two directions: +1 or -1
                    for(int move: new int[]{1, -1}) {
                        //Rotate wheel
                        arr[j] = (char)(((original -'0' + move + 10)%10)+'0');

                        String next = new String(arr);
    
                        //next state
                        if(!dead.contains(next) && visited.add(next)) {
                            queue.add(next);
                        }
                    }
                    arr[j] = original;
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test 1: Classic example — 6 turns needed
        OpenTheLock sol1 = new OpenTheLock();
        System.out.println(sol1.openTheLock(
            new String[]{"0201","0101","0102","1212","2002"},
            "0202")); // Expected: 6

        // Test 2: One-step rotation (last wheel 0 -> 9)
        OpenTheLock sol2 = new OpenTheLock();
        System.out.println(sol2.openTheLock(
            new String[]{"8888"},
            "0009")); // Expected: 1

        // Test 3: Target surrounded by deadends — unreachable
        OpenTheLock sol3 = new OpenTheLock();
        System.out.println(sol3.openTheLock(
            new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},
            "8888")); // Expected: -1

        // Test 4: Starting point "0000" is a deadend
        OpenTheLock sol4 = new OpenTheLock();
        System.out.println(sol4.openTheLock(
            new String[]{"0000"},
            "8888")); // Expected: 0

        // Test 5: No deadends — one-step path
        OpenTheLock sol5 = new OpenTheLock();
        System.out.println(sol5.openTheLock(
            new String[]{},
            "0001")); // Expected: 1

        // Test 6: Target is already the starting position
        OpenTheLock sol6 = new OpenTheLock();
        System.out.println(sol6.openTheLock(
            new String[]{"1234"},
            "0000")); // Expected: 0
    }
}