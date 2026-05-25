package java1.algorithms.backtracking.combinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates, target, new ArrayList<>(), result);

        return result;
    }

    private static void dfs(int i, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // out of target
        if (target < 0 || i == candidates.length)
            return;

        // includate candidate number
        current.add(candidates[i]);
        dfs(i, candidates, target - candidates[i], current, result);
        current.remove(current.size() - 1);
        // exclude candidate number
        dfs(i + 1, candidates, target, current, result);
    }

    private static Set<String> normalize(List<List<Integer>> result) {
        Set<String> set = new HashSet<>();
        for (List<Integer> combo : result) {
            List<Integer> sorted = new ArrayList<>(combo);
            Collections.sort(sorted);
            set.add(sorted.toString());
        }
        return set;
    }

    public static void main(String[] args) {
        int[][] candidatesArr = { { 2, 3, 6, 7 }, { 2, 3 }, { 2 }, { 1 }, { 1, 2 } };
        int[] targets = { 7, 6, 1, 1, 4 };
        List<List<List<Integer>>> expected = new ArrayList<>();
        expected.add(List.of(List.of(2, 2, 3), List.of(7)));
        expected.add(List.of(List.of(2, 2, 2), List.of(3, 3)));
        expected.add(new ArrayList<>());
        expected.add(List.of(List.of(1)));
        expected.add(List.of(List.of(1, 1, 1, 1), List.of(1, 1, 2), List.of(2, 2)));

        for (int i = 0; i < candidatesArr.length; i++) {
            List<List<Integer>> result = combinationSum(candidatesArr[i], targets[i]);
            Set<String> resultSet = normalize(result);
            Set<String> expectedSet = normalize(expected.get(i));
            String status = resultSet.equals(expectedSet) ? "PASS" : "FAIL";
            System.out.println(status + " test " + (i + 1) + ": result=" + resultSet + " expected=" + expectedSet);
        }
    }
}
