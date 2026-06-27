package buttonWithLongestPushTime;

public class ButtonWithLongestPushTime {
    // Track best while scanning events TC: O(n) SC: O(1)
    private static int buttonWithLongestTime(int[][] events) {
        int buttonIndex = events[0][0];
        int maxDuration = events[0][1];

        for(int i=1; i<events.length; i++) {
            int duration = events[i][1] - events[i-1][1];

            if(duration > maxDuration || (duration == maxDuration && events[i][0] < buttonIndex)) {
                maxDuration = duration;
                buttonIndex = events[i][0];
            }
        }

        return buttonIndex;
    }

        public static void main(String[] args) {

        // Test 1
        int[][] events1 = {
                {1, 2},
                {2, 5},
                {3, 9},
                {1, 15}
        };
        System.out.println(buttonWithLongestTime(events1)); // 1

        // Test 2: all durations equal
        int[][] events2 = {
                {0, 3},
                {2, 6},
                {1, 9}
        };
        System.out.println(buttonWithLongestTime(events2)); // 0

        // Test 3: single event
        int[][] events3 = {
                {7, 10}
        };
        System.out.println(buttonWithLongestTime(events3)); // 7

        // Test 4: longest duration in middle
        int[][] events4 = {
                {1, 2},
                {2, 10},
                {3, 12},
                {4, 15}
        };
        System.out.println(buttonWithLongestTime(events4)); // 2

        // Test 5: tie, smaller button wins
        int[][] events5 = {
                {5, 4},
                {2, 8},
                {1, 12}
        };
        System.out.println(buttonWithLongestTime(events5)); // 1

        // Test 6: first event has longest duration
        int[][] events6 = {
                {3, 20},
                {1, 25},
                {2, 28}
        };
        System.out.println(buttonWithLongestTime(events6)); // 3

        // Test 7: larger example
        int[][] events7 = {
                {9, 2},
                {4, 7},
                {8, 10},
                {1, 18},
                {3, 25},
                {0, 30}
        };
        System.out.println(buttonWithLongestTime(events7)); // 1

        // Test 8: multiple ties
        int[][] events8 = {
                {8, 5},
                {4, 10},
                {2, 15},
                {1, 20}
        };
        System.out.println(buttonWithLongestTime(events8)); // 1
    }
}
