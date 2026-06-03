package java1.algorithms.greedy.minInitialEngergyToFinishTasks;

import java.util.Arrays;

public class MinInitialEngergyToFinishTasks {
    //Greedy scheduling TC: O(n log n) SC: O(1) ignoring sorting stack
    private int minimumEffort(int[][] tasks) {
        // sort by (minimum-cost)
        Arrays.sort(tasks, (a, b) -> ((b[1]-b[0]) - (a[1] -a[0])));

        int initialEnergy = 0;
        int availableEnergy = 0;

        for(int[] task: tasks) {
            int actual = task[0];
            int min = task[1];

            if(availableEnergy < min) {
                initialEnergy += min-availableEnergy;

                availableEnergy = min;
            }
            availableEnergy -= actual;
        }

        return initialEnergy;
    }
    public static void main(String[] args) {
        MinInitialEngergyToFinishTasks sol = new MinInitialEngergyToFinishTasks();
        int[][][] tests = {
            { {1,2}, {2,4}, {4,8} }, // 8
            { {1,3}, {2,4}, {10,11}, {10,12}, {8,9} }, // 32
            { {1,7}, {2,8}, {3,9}, {4,10} }, // 16
            { {5,9}, {2,8}, {3,7}, {1,5} }, // 15
            { {1,2}, {2,2}, {3,3} }, // 6
        };
        int[] expected = {8,32,16,15,6};
        for (int i = 0; i < tests.length; i++) {
            int[][] input = new int[tests[i].length][2];
            for (int j = 0; j < tests[i].length; j++) input[j] = Arrays.copyOf(tests[i][j], 2);
            int result = sol.minimumEffort(input);
            boolean pass = result == expected[i];
            System.out.printf("Test %d: Output=%d, Expected=%d [%s]\n", i+1, result, expected[i], pass ? "PASS" : "FAIL");
        }
    }
}
