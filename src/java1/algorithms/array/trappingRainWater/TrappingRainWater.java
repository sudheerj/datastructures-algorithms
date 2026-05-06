public class TrappingRainWater {
    //Two pointer=> TC: O(n) SC(1)
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

    //DP(Prefix and suffix arrays) TC: O(n) SC: O(n)
    private static int trappingRainWater2(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = rightMax[n-1] = 0;

        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i-1]);
        }

        for(int j=n-2; j>=0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], heights[j+1]);
        }

        int water = 0;

        for(int i=0; i<n; i++) {
            water += Math.max(0, Math.min(leftMax[i], rightMax[i])-heights[i]);
        }

        return water;
    }

    public static void main(String[] args) {
        // Test 1: General case
        System.out.println("Test 1: " + trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6
        System.out.println("Test 1 (DP): " + trappingRainWater2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})); // 6

        // Test 2: V-shaped
        System.out.println("Test 2: " + trappingRainWater(new int[]{4, 2, 0, 3, 2, 5})); // 9
        System.out.println("Test 2 (DP): " + trappingRainWater2(new int[]{4, 2, 0, 3, 2, 5})); // 9

        // Test 3: Flat - no water
        System.out.println("Test 3: " + trappingRainWater(new int[]{1, 1})); // 0
        System.out.println("Test 3 (DP): " + trappingRainWater2(new int[]{1, 1})); // 0

        // Test 4: Empty array
        System.out.println("Test 4: " + trappingRainWater(new int[]{})); // 0
        System.out.println("Test 4 (DP): " + trappingRainWater2(new int[]{})); // 0

        // Test 5: Deep valley
        System.out.println("Test 5: " + trappingRainWater(new int[]{3, 0, 0, 2, 0, 4})); // 10
        System.out.println("Test 5 (DP): " + trappingRainWater2(new int[]{3, 0, 0, 2, 0, 4})); // 10
    }
}
