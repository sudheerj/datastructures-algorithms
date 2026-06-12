package java1.algorithms.backtracking.permutations3;

import java.util.ArrayList;
import java.util.List;

public class Permutations3 {
    private List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if(nums.length == current.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }

            //extra parity check
            if(!current.isEmpty() && current.get(current.size()-1)%2 == nums[i]%2) continue;

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, current, result, used);

            current.remove(nums[i]);
            used[i] = false;
        }
    }
}

