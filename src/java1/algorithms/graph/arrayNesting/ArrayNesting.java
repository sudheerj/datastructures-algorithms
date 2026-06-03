package java1.algorithms.graph.arrayNesting;

public class ArrayNesting {
    //Graph traversal with in-place visiting TC: O(n) SC: O(1)
    private int arrayNesting1(int[] nums) {
        int maxLength = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == -1) continue;
            
            int count = 0;
            int curr = i;
            while(nums[curr] != -1) {
                int next = nums[curr];
                nums[curr] = -1;
                curr = next;

                count++;
            }
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }

    //Graph traversal with visited array TC: O(n) SC: O(n)
    private int arrayNesting2(int[] nums) {
        int maxLength = 0;
        boolean[] visited = new boolean[nums.length];

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            int count = 0;
            int curr = i;

            while (!visited[curr]) {
                int next = nums[curr];
                visited[curr] = true;
                curr = next;
                count++;
            }

            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
    // Utility to deep copy an array
    private static int[] deepCopy(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    public static void main(String[] args) {
        ArrayNesting sol = new ArrayNesting();
        int[][] tests = {
            {5,4,0,3,1,6,2}, // 4
            {0,1,2},         // 1
            {1,0,3,4,2},     // 3
            {2,0,1},         // 3
            {1,2,3,4,0},     // 5
            {0},             // 1
            {1,2,0},         // 3
        };
        int[] expected = {4,1,3,3,5,1,3};

        System.out.println("Testing arrayNesting1 (in-place):");
        for (int i = 0; i < tests.length; i++) {
            int[] input = deepCopy(tests[i]);
            int result = sol.arrayNesting1(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }

        System.out.println("\nTesting arrayNesting2 (visited array):");
        for (int i = 0; i < tests.length; i++) {
            int[] input = deepCopy(tests[i]);
            int result = sol.arrayNesting2(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
