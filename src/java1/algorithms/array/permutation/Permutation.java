import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        // Example 1: Standard case
        int[] nums1 = { 1, 2, 3 };
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + permutations(nums1));

        // Example 2: Two elements
        int[] nums2 = { 0, 1 };
        System.out.println("Input: [0, 1]");
        System.out.println("Output: " + permutations(nums2));

        // Example 3: Single element
        int[] nums3 = { 1 };
        System.out.println("Input: [1]");
        System.out.println("Output: " + permutations(nums3));

        // Example 4: Empty array
        int[] nums4 = {};
        System.out.println("Input: []");
        System.out.println("Output: " + permutations(nums4));

        // Example 5: Negative numbers
        int[] nums5 = { -1, 2 };
        System.out.println("Input: [-1, 2]");
        System.out.println("Output: " + permutations(nums5));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }

            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}