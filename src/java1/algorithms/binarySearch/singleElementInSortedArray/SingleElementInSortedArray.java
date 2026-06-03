package java1.algorithms.binarySearch.singleElementInSortedArray;

public class SingleElementInSortedArray {
    //Binary search on Pair alignment TC: O(log n) SC: O(1)
    private int singleNonDuplicate(int[] nums) {
        int left =0, right = nums.length-1;

        while(left < right) {
            int mid = left +(right - left)/2;

            //force mid to even for comparison
            if(mid % 2 == 1) {
                mid--;
            }

            if(nums[mid] == nums[mid+1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
    // Utility to deep copy an array
    private static int[] deepCopy(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    public static void main(String[] args) {
        SingleElementInSortedArray sol = new SingleElementInSortedArray();
        int[][] tests = {
            {1,1,2,3,3,4,4,8,8}, // 2
            {3,3,7,7,10,11,11},   // 10
            {1,1,2,2,3,3,4,4,5},  // 5
            {0,1,1,2,2,3,3},      // 0
            {1,1,2,2,3,3,4},      // 4
            {5},                  // 5
            {1,1,2},              // 2
        };
        int[] expected = {2,10,5,0,4,5,2};

        System.out.println("Testing singleNonDuplicate (binary search):");
        for (int i = 0; i < tests.length; i++) {
            int[] input = deepCopy(tests[i]);
            int result = sol.singleNonDuplicate(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
