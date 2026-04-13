import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC:O(n**3) SC: O(1)
// K-sum recursion + two sum(two pointer) base approach
public class FourSum {
    public static void main(String[] args) {
        // Test case 1: General case
        System.out.println("Test 1: " + fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
        // Expected: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        // Test case 2: All same elements
        System.out.println("Test 2: " + fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
        // Expected: [[2, 2, 2, 2]]

        // Test case 3: No valid quadruplets
        System.out.println("Test 3: " + fourSum(new int[] { 1, 2, 3, 4 }, 100));
        // Expected: []

        // Test case 4: Negative numbers
        System.out.println("Test 4: " + fourSum(new int[] { -3, -2, -1, 0, 0, 1, 2, 3 }, 0));
        // Expected: [[-3, -2, 2, 3], [-3, -1, 1, 3], [-3, 0, 0, 3], [-3, 0, 1, 2], [-2,
        // -1, 0, 3], [-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]

        // Test case 5: Exactly four elements
        System.out.println("Test 5: " + fourSum(new int[] { 1, 2, 3, 4 }, 10));
        // Expected: [[1, 2, 3, 4]]

        // Test case 6: Less than four elements
        System.out.println("Test 6: " + fourSum(new int[] { 1, 2 }, 3));
        // Expected: []

        // Test case 7: Empty array
        System.out.println("Test 7: " + fourSum(new int[] {}, 0));
        // Expected: []
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadrets = new ArrayList<>();
        Arrays.sort(nums);
        kSum(nums, target, 0, 4, new ArrayList<>(), quadrets);
        return quadrets;
    }

    private static void kSum(int[] nums, int target, int start, int k, List<Integer> quad,
            List<List<Integer>> quadrets) {
        if (k != 2) {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;

                quad.add(nums[i]);
                kSum(nums, target - nums[i], i + 1, k - 1, quad, quadrets);
                quad.remove(quad.size() - 1);
            }
            return;
        }

        // Base case: 2-sum with two pointers
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[left]);
                temp.add(nums[right]);

                quadrets.add(temp);

                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            }
        }
    }
}
