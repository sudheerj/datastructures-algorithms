package java1.algorithms.backtracking.optimalAccountBalancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    //Backtracking on net balance state space to minimum transactions TC: O(n!) SC: O(n)
    private int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();

        //Step1: Build net balances array
        for(int[] transaction: transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0)- transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }

        //Step2: Extract non-zero balances
        List<Integer> debt = new ArrayList<>();
        for(int amount: map.values()) {
            if(amount != 0) debt.add(amount);
        }

        return dfs(debt, 0);
    }

    private int dfs(List<Integer> debt, int start) {
        //skip settled nodes
        while(start < debt.size() && debt.get(start) == 0) {
            start++;
        }

        if(start == debt.size()) {
            return 0;
        }

        int minTransfers = Integer.MAX_VALUE;

        for(int i= start+1; i<debt.size(); i++) {
            if(debt.get(i) * debt.get(start) < 0) {
                //try settlement
                debt.set(i, debt.get(i) + debt.get(start));

                minTransfers = Math.min(minTransfers, 1 + dfs(debt, start + 1));

                //backtrack
                debt.set(i, debt.get(i)-debt.get(start));
            } 
        }
        return minTransfers;

    }
    public static void main(String[] args) {
        OptimalAccountBalancing sol = new OptimalAccountBalancing();
        int[][][] tests = {
            // Example 1: 0->1 $10, 2->0 $5
            { {0,1,10}, {2,0,5} }, // 2
            // Example 2: 0->1 $10, 1->0 $10
            { {0,1,10}, {1,0,10} }, // 0
            // Example 3: 0->1 $10, 1->2 $5, 2->0 $5
            { {0,1,10}, {1,2,5}, {2,0,5} }, // 1
            // Example 4: 0->1 $10, 1->2 $5, 2->3 $5, 3->0 $5
            { {0,1,10}, {1,2,5}, {2,3,5}, {3,0,5} }, // 1
            // Example 5: 0->1 $5, 0->2 $10, 1->2 $5
            { {0,1,5}, {0,2,10}, {1,2,5} }, // 1
            // Example 6: 0->1 $1, 1->2 $1, 2->0 $1
            { {0,1,1}, {1,2,1}, {2,0,1} }, // 0
        };
        int[] expected = {2,0,1,1,1,0};
        for (int i = 0; i < tests.length; i++) {
            int[][] input = tests[i];
            int result = sol.minTransfers(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
