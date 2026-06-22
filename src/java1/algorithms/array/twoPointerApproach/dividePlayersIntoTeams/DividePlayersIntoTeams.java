package twoPointerApproach.dividePlayersIntoTeams;

import java.util.Arrays;

public class DividePlayersIntoTeams {
    //Sorting + Two-pointer approach TC: O(n log n) SC: O(1)
    //smallest and largest elements needs to form a pair
    private static long dividePlayers1(int[] skills) {
        Arrays.sort(skills);
        int n = skills.length;

        int left = 0, right = n-1;
        int target = skills[left] + skills[right];

        long chemistry = 0;

        while(left < right) {
            if(skills[left] + skills[right] != target) return -1;

            chemistry += (long) skills[left] * skills[right];
            left++;
            right--;
        }

        return chemistry;
    }

    //Frequency counting + compute complement TC: O(n) SC: O(1)
    private static long dividePlayers2(int[] skills) {
        long sum = 0;
        for(int skill: skills) {
            sum += skill;
        }

        int n = skills.length;
        int teams = n/2;

        if(sum%teams != 0) {
            return -1;
        }

        int target = (int)(sum/teams);

        int[] freqCount = new int[1001];
        for(int skill: skills) {
            freqCount[skill]++;
        }

        long chemistry = 0;

        for(int s=0; s<=1000; s++) {
            while(freqCount[s] > 0) {
                int partner = target - s;

                if(partner < 0 || partner > 1000 || freqCount[partner] == 0) return -1;

                chemistry += (long) s * partner;

                freqCount[s]--;
                freqCount[partner]--;
            }

        }

        return chemistry; //every pair counted twice
    }

    public static void main(String[] args) {

        int[][] tests = {
            {3, 2, 5, 1, 3, 4},      // 22
            {3, 4},                  // 12
            {1, 1, 2, 3},            // -1
            {5, 5, 5, 5},            // 25
            {7, 7, 7, 7, 7, 7},      // 147
            {1, 9, 2, 8, 3, 7, 4, 6},
            {2, 2, 2, 2, 2, 2},
            {1, 5, 2, 4},
            {1, 2, 3, 5},
            {1, 1, 1, 2, 2, 2},
            {1, 2, 3, 4, 5, 6},
            {1, 10, 2, 9, 3, 8, 4, 7, 5, 6},
            {1000, 1000},
            {1, 1000, 500, 501},
            {4, 6, 2, 8},
            {10, 20, 30, 40, 50, 60}
        };

        for (int[] test : tests) {
            System.out.println("Input: " + Arrays.toString(test));

            long sortAns = dividePlayers1(test.clone());
            long mapAns = dividePlayers2(test.clone());

            System.out.println("Sort Solution = " + sortAns);
            System.out.println("Map Solution  = " + mapAns);
            System.out.println();
        }
    }
}
