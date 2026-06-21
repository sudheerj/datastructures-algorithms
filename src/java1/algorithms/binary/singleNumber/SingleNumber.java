package java1.algorithms.binary.singleNumber;

public class SingleNumber {
    //XOR operation: TC: O(n) SC: O(1)
    private static int singleNumber(int[] nums) {
        int result = 0;

        for(int num: nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] test1 = {2, 2, 1};
        System.out.println("Test 1: " + singleNumber(test1));
        // Expected: 1

        int[] test2 = {4, 1, 2, 1, 2};
        System.out.println("Test 2: " + singleNumber(test2));
        // Expected: 4

        int[] test3 = {1};
        System.out.println("Test 3: " + singleNumber(test3));
        // Expected: 1

        int[] test4 = {7, 3, 5, 3, 5};
        System.out.println("Test 4: " + singleNumber(test4));
        // Expected: 7
    }
}
