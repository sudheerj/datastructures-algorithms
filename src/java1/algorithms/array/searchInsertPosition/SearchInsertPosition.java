package searchInsertPosition;

public class SearchInsertPosition {
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {},
            {1},
            {1},
            {1}
        };
        int[] targets = {5, 2, 7, 0, 3, 0, 2, 1};
        int[] expected = {2, 1, 4, 0, 0, 0, 1, 0};

        for (int i = 0; i < testArrays.length; i++) {
            int result = searchInsertPosition(testArrays[i], targets[i]);
            System.out.printf("Test %d: searchInsertPosition(%s, %d) = %d | Expected: %d | %s\n",
                i+1, arrayToString(testArrays[i]), targets[i], result, expected[i],
                (result == expected[i] ? "PASS" : "FAIL"));
        }
    }

    private static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    //Binary search: TC:O(log n) TC: O(1)
    private static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left<=right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                return mid; // exact match found
            }

            if(nums[mid] < target) {
                left = mid + 1; // search right half
            } else {
                right = mid -1; // search left half
            }
        }
        // target not found: left is the correct insert position
        return left;
    }
}
