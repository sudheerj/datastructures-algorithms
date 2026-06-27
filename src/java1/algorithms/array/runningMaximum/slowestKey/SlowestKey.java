package runningMaximum.slowestKey;

public class SlowestKey {
    //Array traversal + running maximum TC: O(n) SC: O(1)
    private static char slowestKey(int[] releaseTimes, String keysPressed) {
        char ansKey = keysPressed.charAt(0);
        int maxDuration = releaseTimes[0];

        for(int i=1; i<releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i-1];
            char key = keysPressed.charAt(i);

            if(duration > maxDuration || (duration == maxDuration && key > ansKey)) {
                maxDuration = duration;
                ansKey = key;
            }
        }

        return ansKey;
    }

    public static void main(String[] args) {

        int[] releaseTimes1 = {9, 29, 49, 50};
        String keysPressed1 = "cbcd";
        System.out.println(slowestKey(releaseTimes1, keysPressed1)); // c

        int[] releaseTimes2 = {12, 23, 36, 46, 62};
        String keysPressed2 = "spuda";
        System.out.println(slowestKey(releaseTimes2, keysPressed2)); // a

        int[] releaseTimes3 = {10};
        String keysPressed3 = "a";
        System.out.println(slowestKey(releaseTimes3, keysPressed3)); // a

        int[] releaseTimes4 = {5, 10, 15, 20};
        String keysPressed4 = "abcd";
        System.out.println(slowestKey(releaseTimes4, keysPressed4)); // d

        int[] releaseTimes5 = {2, 5, 9, 15};
        String keysPressed5 = "abca";
        System.out.println(slowestKey(releaseTimes5, keysPressed5)); // a
    }
}
