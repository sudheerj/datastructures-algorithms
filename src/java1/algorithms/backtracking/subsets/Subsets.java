package java1.algorithms.backtracking.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    //Backtracking binary decision tree TC:O(n * 2^n) SC: O(n * 2^n)
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(0, nums, subset, result);

        return result;
    }

    private static void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(i == nums.length) {
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

    //Iteration expansion TC: O(n * 2^n) SC: TC: O(n * 2^n)
    private static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num: nums) {
            int size = result.size();
            for(int i=0; i<size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }

    //Bit masking TC: O(n * 2^n) SC: O(n * 2^n)
    private static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int mask=0; mask<(1<<n); mask++) {
            List<Integer> subset = new ArrayList<>();

            for(int j=0; j<n; j++) {
                if((mask & 1<<j) !=0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }

    private static Set<String> normalize(List<List<Integer>> lists) {
        Set<String> set = new HashSet<>();
        for (List<Integer> list : lists) {
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            set.add(sorted.toString());
        }
        return set;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int[][]  inputs = { {1, 2, 3}, {0}, {}, {1, 2} };
        String[] labels = { "[1,2,3]", "[0]", "[]", "[1,2]" };

        List<List<Integer>>[] exp = new List[]{
            List.of(List.of(), List.of(1), List.of(2), List.of(3),
                    List.of(1,2), List.of(1,3), List.of(2,3), List.of(1,2,3)),
            List.of(List.of(), List.of(0)),
            List.of(List.of()),
            List.of(List.of(), List.of(1), List.of(2), List.of(1,2))
        };

        for (int i = 0; i < inputs.length; i++) {
            Set<String> expected = normalize(exp[i]);
            System.out.printf("%s [Backtracking] input=%s%n",
                normalize(subsets(inputs[i])).equals(expected)  ? "[PASS]" : "[FAIL]", labels[i]);
            System.out.printf("%s [Iterative   ] input=%s%n",
                normalize(subsets1(inputs[i])).equals(expected) ? "[PASS]" : "[FAIL]", labels[i]);
            System.out.printf("%s [Bit Masking ] input=%s%n",
                normalize(subsets2(inputs[i])).equals(expected) ? "[PASS]" : "[FAIL]", labels[i]);
        }

        // Test 5: [1,2,3,4] — expect 2^4 = 16 subsets
        int[] t5 = {1, 2, 3, 4};
        System.out.printf("%s [Backtracking] input=[1,2,3,4] count=%d expected=16%n",
            subsets(t5).size()  == 16 ? "[PASS]" : "[FAIL]", subsets(t5).size());
        System.out.printf("%s [Iterative   ] input=[1,2,3,4] count=%d expected=16%n",
            subsets1(t5).size() == 16 ? "[PASS]" : "[FAIL]", subsets1(t5).size());
        System.out.printf("%s [Bit Masking ] input=[1,2,3,4] count=%d expected=16%n",
            subsets2(t5).size() == 16 ? "[PASS]" : "[FAIL]", subsets2(t5).size());
    }
}
