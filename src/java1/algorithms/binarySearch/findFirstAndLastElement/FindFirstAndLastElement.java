public class FindFirstAndLastElement {
    public static void main(String[] args) {
        // Test 1: Target appears multiple times
        int[] r1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println("Test 1: [" + r1[0] + ", " + r1[1] + "]"); // [3, 4]

        // Test 2: Target not found
        int[] r2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println("Test 2: [" + r2[0] + ", " + r2[1] + "]"); // [-1, -1]

        // Test 3: Empty array
        int[] r3 = searchRange(new int[]{}, 0);
        System.out.println("Test 3: [" + r3[0] + ", " + r3[1] + "]"); // [-1, -1]

        // Test 4: Single element - found
        int[] r4 = searchRange(new int[]{5}, 5);
        System.out.println("Test 4: [" + r4[0] + ", " + r4[1] + "]"); // [0, 0]

        // Test 5: Single element - not found
        int[] r5 = searchRange(new int[]{5}, 3);
        System.out.println("Test 5: [" + r5[0] + ", " + r5[1] + "]"); // [-1, -1]

        // Test 6: All same elements
        int[] r6 = searchRange(new int[]{2, 2, 2, 2, 2}, 2);
        System.out.println("Test 6: [" + r6[0] + ", " + r6[1] + "]"); // [0, 4]

        // Test 7: Target at the beginning
        int[] r7 = searchRange(new int[]{1, 1, 3, 5, 7}, 1);
        System.out.println("Test 7: [" + r7[0] + ", " + r7[1] + "]"); // [0, 1]

        // Test 8: Target at the end
        int[] r8 = searchRange(new int[]{1, 3, 5, 7, 7}, 7);
        System.out.println("Test 8: [" + r8[0] + ", " + r8[1] + "]"); // [3, 4]
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = findBound(nums, target, true);
        result[1] = findBound(nums, target, false);
        return result;
    }

    private static int findBound(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length-1, index = -1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                index = mid;

                if(findFirst) {
                    right = mid-1; //shrink to left part
                } else {
                    left = mid+ 1; //shrink to right part
                }
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;
    }
}
