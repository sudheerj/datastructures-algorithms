package java1.algorithms.binary.singleNumber2;

public class SingleNumber2 {
    private static int singleNumberCounting(int[] nums) {
        int result = 0;

        //check all 32 bits
        for(int i=0; i<32; i++) {
            int count = 0;

            for(int num: nums) {
                if(((num >> i) & 1) == 1) {
                    count++;
                }
            }

            if(count % 3 != 0) {
                result |= 1 << i;
            }
        }

        return result;
    }

    private static int singleNumberStateMachine(int[] nums) {
        int ones = 0, twos = 0;

        for(int num: nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {2, 2, 3, 2},
            {0, 1, 0, 1, 0, 1, 99},
            {-2, -2, -2, -7},
            {5, 3, 5, 5}
        };

        for (int i = 0; i < tests.length; i++) {
            int[] nums = tests[i];

            int result1 = singleNumberCounting(nums);
            int result2 = singleNumberStateMachine(nums);

            System.out.println("Test " + (i + 1));
            System.out.println("Counting Bits   : " + result1);
            System.out.println("State Machine   : " + result2);
            System.out.println("------------------------");
        }
    }
}
