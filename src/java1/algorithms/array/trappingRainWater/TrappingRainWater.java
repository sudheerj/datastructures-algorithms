public class TrappingRainWater {

    private static int trappingRainWater(int[] heights) {
        if (heights.length == 0) return 0;

        int left = 0, right = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[right];
        int res = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                res += leftMax - heights[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, heights[right]);
                res += rightMax - heights[right];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Test 1: General case
        System.out.println("Test 1: " + trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        // Test 2: V-shaped
        System.out.println("Test 2: " + trappingRainWater(new int[]{4, 2, 0, 3, 2, 5})); // 9

        // Test 3: Flat - no water
        System.out.println("Test 3: " + trappingRainWater(new int[]{1, 1})); // 0

        // Test 4: Empty array
        System.out.println("Test 4: " + trappingRainWater(new int[]{})); // 0

        // Test 5: Deep valley
        System.out.println("Test 5: " + trappingRainWater(new int[]{3, 0, 0, 2, 0, 4})); // 10
    }
}
