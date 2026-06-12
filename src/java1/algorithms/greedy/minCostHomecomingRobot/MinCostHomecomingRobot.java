package java1.algorithms.greedy.minCostHomecomingRobot;

public class MinCostHomecomingRobot {
    //Greedy traversal or simulation TC: O(R+C) number of rows/columns entered SC: O(1)
    private int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0;
        int row = startPos[0], col = startPos[1];

        //move vertically
        while(row != homePos[0]) {
            row += (homePos[0] > row) ? 1 : -1;
            cost += rowCosts[row];
        }
        //horizontally
        while(col != homePos[1]) {
            col += (homePos[1] > col) ? 1 : -1;
            cost += colCosts[col];
        }

        return cost;
    }
}
