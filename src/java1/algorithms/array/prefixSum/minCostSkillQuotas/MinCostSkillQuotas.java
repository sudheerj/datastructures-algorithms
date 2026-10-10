package java1.algorithms.array.prefixSum.minCostSkillQuotas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostSkillQuotas {
    public static long[] minimumCostForSkillQuotas(int[] costs, int[] skill1, int[] skill2) {
        // Each item belongs to exactly one bucket: both skills, skill 1 only, or skill
        // 2 only.
        // Items with neither skill cannot help satisfy a quota.
        List<Integer> bothSkills = new ArrayList<>();
        List<Integer> skillOne = new ArrayList<>();
        List<Integer> skillTwo = new ArrayList<>();

        // 1. Make three buckets
        for (int i = 0; i < costs.length; i++) {
            if (skill1[i] == 1 && skill2[i] == 1) {
                bothSkills.add(costs[i]);
            } else if (skill1[i] == 1) {
                skillOne.add(costs[i]);
            } else if (skill2[i] == 1) {
                skillTwo.add(costs[i]);
            }
        }

        // 2. Cheapest first
        Collections.sort(bothSkills);
        Collections.sort(skillOne);
        Collections.sort(skillTwo);

        // Prefix sums let us get the cost of the cheapest t items in each bucket in
        // O(1).
        long[] bothPrefix = prefixSum(bothSkills);
        long[] onePrefix = prefixSum(skillOne);
        long[] twoPrefix = prefixSum(skillTwo);

        int n = costs.length;
        long[] ans = new long[n];
        Arrays.fill(ans, -1);

        // ans[k - 1] is the minimum cost to obtain at least k items for each skill.
        for (int k = 1; k <= n; k++) {
            long best = Long.MAX_VALUE;

            // Choose x items that provide both skills. Then k-x single-skill items
            // are needed from each of the other two buckets.
            for (int x = 0; x <= k; x++) {
                int remaining = k - x;

                if (x <= bothSkills.size() && remaining <= skillOne.size() && remaining <= skillTwo.size()) {
                    // Sorted buckets and prefix sums make this the cheapest cost for this x.
                    long cost = bothPrefix[x] + onePrefix[remaining] + twoPrefix[remaining];
                    best = Math.min(best, cost);
                }
            }

            // Keep -1 when there are not enough items to satisfy both quotas.
            if (best != Long.MAX_VALUE) {
                ans[k - 1] = best;
            }
        }

        return ans;
    }

    private static long[] prefixSum(List<Integer> list) {
        long[] p = new long[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            p[i + 1] = p[i] + list.get(i);
        }

        return p;
    }

    public static void main(String[] args) {
        int[][] costs = {
                { 5, 3, 4, 2 },
                { 2, 3, 1, 4 },
                { 7, 2, 5 }
        };
        int[][] skill1 = {
                { 1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 1 }
        };
        int[][] skill2 = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 1 },
                { 1, 1, 1 }
        };
        long[][] expected = {
                { 3, 12, -1, -1 },
                { 3, 10, -1, -1 },
                { 2, 7, 14 },
                { 2, 6, -1, -1, -1 },
                { -1, -1 }
        };
        int[][] mixedCosts = { { 6, 2, 3, 4, 1 }, { 1, 2 } };
        int[][] mixedSkill1 = { { 1, 1, 1, 0, 0 }, { 1, 1 } };
        int[][] mixedSkill2 = { { 0, 1, 0, 1, 1 }, { 0, 0 } };
        String[] labels = {
                "separate skill groups with one overlapping item",
                "both quotas can be met from overlapping items",
                "all items provide both skills",
                "mix of overlapping and single-skill items",
                "missing all items for skill 2"
        };

        for (int i = 0; i < expected.length; i++) {
            int[] testCosts = i < costs.length ? costs[i] : mixedCosts[i - costs.length];
            int[] testSkill1 = i < skill1.length ? skill1[i] : mixedSkill1[i - costs.length];
            int[] testSkill2 = i < skill2.length ? skill2[i] : mixedSkill2[i - costs.length];
            long[] actual = minimumCostForSkillQuotas(testCosts, testSkill1, testSkill2);
            boolean passed = Arrays.equals(actual, expected[i]);
            System.out.println(labels[i] + ": expected=" + Arrays.toString(expected[i])
                    + ", actual=" + Arrays.toString(actual) + (passed ? " [PASS]" : " [FAIL]"));
        }
    }
}
