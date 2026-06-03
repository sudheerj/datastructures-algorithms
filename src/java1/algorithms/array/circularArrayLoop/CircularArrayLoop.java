package circularArrayLoop;

public class CircularArrayLoop {
    private boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {

            if(nums[i] == 0) {
                continue;
            }

            boolean forward = nums[i] > 0;

            int slow = i;
            int fast = i;

            while(true) {
                slow = next(nums, forward, slow);

                if(slow == -1) {
                    break;
                }

                fast = next(nums, forward, fast);

                if(fast == -1) {
                    break;
                }

                fast = next(nums, forward, fast);

                if(fast == -1) {
                    break;
                }

                if(slow == fast) {
                    return true;
                }
            }

            int index = i;
            while(nums[index] != 0 && (nums[index] > 0) == forward) {
                int nextIndex = ((index + nums[index])%n + n)%n;
                nums[index] = 0; // mark as visited
                index = nextIndex;
            }
        }

        return false;
    }

    private int next(int[] nums, boolean forward, int current) {
        boolean direction = nums[current] > 0;

        //different direction is not allowed
        if(forward != direction) {
            return -1;
        }

        int n = nums.length;
        int next = ((current + nums[current])%n + n)%n;

        //self loop is not allowed
        if(next == current) {
            return -1;
        }

        return next;
    }
    public static void main(String[] args) {
        CircularArrayLoop sol = new CircularArrayLoop();
        int[][] tests = {
            {2,-1,1,2,2}, // true
            {-1,2}, // false
            {-2,1,-1,-2,-2}, // false
            {1,1,2}, // true
            {1,2,3,4,5,6,7,8,9,10}, // true
            {1,1,1,1,1,1,1,1,1,1}, // true
        };
        boolean[] expected = {true, false, false, true, true, true};
        for (int i = 0; i < tests.length; i++) {
            int[] input = java.util.Arrays.copyOf(tests[i], tests[i].length);
            boolean result = sol.circularArrayLoop(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%b, Expected=%b [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
