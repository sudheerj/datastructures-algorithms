package java1.algorithms.backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

//Backtracking TC: O(k * n!/((n-k)! * k!)) or(commonly written as O(k * C(n, k))) SC: O(k * n!/((n-k)! * k!))
public class Combinations {
    private static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k, List<Integer> comb, List<List<Integer>> result) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(i + 1, n, k, comb, result);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 4, 2 }, // Expected: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
                { 1, 1 }, // Expected: [[1]]
                { 3, 1 }, // Expected: [[1],[2],[3]]
                { 3, 3 }, // Expected: [[1,2,3]]
                { 5, 3 } // Expected: 10 combinations
        };
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i][0], k = testCases[i][1];
            System.out.println("Test case " + (i + 1) + ": n=" + n + ", k=" + k);
            List<List<Integer>> result = combinations(n, k);
            System.out.println("Output: " + result);
            System.out.println("Total combinations: " + result.size());
        }
    }
}
