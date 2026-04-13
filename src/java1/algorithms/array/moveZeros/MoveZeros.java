public class MoveZeros {
    private static int[] moveZeros(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Test case 1: General case with zeros interspersed
        int[] result1 = moveZeros(new int[] { 0, 1, 0, 3, 12 });
        System.out.println("Test 1: " + java.util.Arrays.toString(result1)); // [1, 3, 12, 0, 0]

        // Test case 2: Single zero
        int[] result2 = moveZeros(new int[] { 0 });
        System.out.println("Test 2: " + java.util.Arrays.toString(result2)); // [0]

        // Test case 3: No zeros
        int[] result3 = moveZeros(new int[] { 1, 2, 3 });
        System.out.println("Test 3: " + java.util.Arrays.toString(result3)); // [1, 2, 3]

        // Test case 4: All zeros
        int[] result4 = moveZeros(new int[] { 0, 0, 0 });
        System.out.println("Test 4: " + java.util.Arrays.toString(result4)); // [0, 0, 0]

        // Test case 5: Zeros at the end already
        int[] result5 = moveZeros(new int[] { 1, 2, 0, 0 });
        System.out.println("Test 5: " + java.util.Arrays.toString(result5)); // [1, 2, 0, 0]

        // Test case 6: Single non-zero element
        int[] result6 = moveZeros(new int[] { 5 });
        System.out.println("Test 6: " + java.util.Arrays.toString(result6)); // [5]

        // Test case 7: Negative numbers with zeros
        int[] result7 = moveZeros(new int[] { -1, 0, 0, 3, -2 });
        System.out.println("Test 7: " + java.util.Arrays.toString(result7)); // [-1, 3, -2, 0, 0]
    }
}
