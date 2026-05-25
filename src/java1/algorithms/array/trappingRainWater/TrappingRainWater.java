public class TrappingRainWater {
    //Two pointer=> TC: O(n) SC(1)
    private static int trappingRainWater(int[] heights) {
        if (heights.length == 0) return 0;

        int left = 0, right = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[right];
        int water = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, heights[left]);
                water += leftMax - heights[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, heights[right]);
                water += rightMax - heights[right];
            }
        }

        return water;
    }

    //Prefix and suffix arrays TC: O(n) SC: O(n)
    private static int trappingRainWater2(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = heights[0];
        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]);
        }

        rightMax[n-1] = heights[n-1];
        for(int j=n-2; j>=0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], heights[j]);
        }

        int water = 0;

        for(int i=0; i<n; i++) {
            water += Math.min(leftMax[i], rightMax[i])-heights[i];
        }

        return water;
    }

    //BruteForce approach TC: O(n^2) SC: O(1)
    private static int trappingRainWater3(int[] height) {
        int n = height.length;
        if(n == 0) {
            return 0;
        }
        int water = 0;

        for(int i=0; i<n; i++) {
            int leftMax = 0;
            for(int j=0; j<=i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for(int j=i; j<n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int[] t1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] t2 = {4,2,0,3,2,5};
        int[] t3 = {1,1};
        int[] t4 = {};
        int[] t5 = {3,0,0,2,0,4};

        // Approach 1: Two Pointers
        int r1 = trappingRainWater(t1);
        System.out.println("Test 1 (two-ptr): " + (r1 == 6 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=6");
        int r2 = trappingRainWater(t2);
        System.out.println("Test 2 (two-ptr): " + (r2 == 9 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=9");
        int r3 = trappingRainWater(t3);
        System.out.println("Test 3 (two-ptr): " + (r3 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=0");
        int r4 = trappingRainWater(t4);
        System.out.println("Test 4 (two-ptr): " + (r4 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=0");
        int r5 = trappingRainWater(t5);
        System.out.println("Test 5 (two-ptr): " + (r5 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=10");

        // Approach 2: Prefix/Suffix Arrays
        int r6 = trappingRainWater2(t1);
        System.out.println("Test 1 (prefix): " + (r6 == 6 ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=6");
        int r7 = trappingRainWater2(t2);
        System.out.println("Test 2 (prefix): " + (r7 == 9 ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=9");
        int r8 = trappingRainWater2(t3);
        System.out.println("Test 3 (prefix): " + (r8 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=0");
        int r9 = trappingRainWater2(t4);
        System.out.println("Test 4 (prefix): " + (r9 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=0");
        int r10 = trappingRainWater2(t5);
        System.out.println("Test 5 (prefix): " + (r10 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=10");

        // Approach 3: Brute Force
        int r11 = trappingRainWater3(t1);
        System.out.println("Test 1 (brute): " + (r11 == 6 ? "[PASS]" : "[FAIL]") + " result=" + r11 + " expected=6");
        int r12 = trappingRainWater3(t2);
        System.out.println("Test 2 (brute): " + (r12 == 9 ? "[PASS]" : "[FAIL]") + " result=" + r12 + " expected=9");
        int r13 = trappingRainWater3(t3);
        System.out.println("Test 3 (brute): " + (r13 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r13 + " expected=0");
        int r14 = trappingRainWater3(t4);
        System.out.println("Test 4 (brute): " + (r14 == 0 ? "[PASS]" : "[FAIL]") + " result=" + r14 + " expected=0");
        int r15 = trappingRainWater3(t5);
        System.out.println("Test 5 (brute): " + (r15 == 10 ? "[PASS]" : "[FAIL]") + " result=" + r15 + " expected=10");
    }
}
