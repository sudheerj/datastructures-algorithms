package equillibriumIndex;

public class EquilibriumIndex {
    public static void main(String[] args) {
        // Test case 1: Equilibrium index exists
        int[] nums1 = {1, 3, 5, 2, 2};
        System.out.println("Test 1: " + equilibriumIndex(nums1)); // Expected: 2

        // Test case 2: No equilibrium index
        int[] nums2 = {1, 2, 3};
        System.out.println("Test 2: " + equilibriumIndex(nums2)); // Expected: -1

        // Test case 3: Single element
        int[] nums3 = {10};
        System.out.println("Test 3: " + equilibriumIndex(nums3)); // Expected: 0

        // Test case 4: Empty array
        int[] nums4 = {};
        System.out.println("Test 4: " + equilibriumIndex(nums4)); // Expected: -1
    }

    public static int equilibriumIndex(int[] nums) {
        int total = 0, leftSum = 0, rightSum = 0;
        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }
        return nums.length == 1 ? 0 : -1;
    }
}
