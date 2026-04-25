package subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    //Backtracking TC:O(n * 2^n) SC: O(n * 2^n)
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, nums, subset, result);

        return result;
    }

    private static void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        //Include value to subset
        subset.add(nums[i]);
        dfs(i+1, nums, subset, result);

        //Exclude value in subset
        subset.remove(subset.size()-1);
        dfs(i+1, nums, subset, result);
    }

    public static void main(String[] args) {
        // Helper to print list of lists
        java.util.function.Consumer<List<List<Integer>>> printResult = res -> {
            System.out.println(res);
        };

        // Example 1: [1,2,3]
        // Expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
        printResult.accept(subsets(new int[]{1,2,3}));

        // Example 2: [0]
        // Expected: [[], [0]]
        printResult.accept(subsets(new int[]{0}));

        // Example 3: []
        // Expected: [[]]
        printResult.accept(subsets(new int[]{}));
    }
}
