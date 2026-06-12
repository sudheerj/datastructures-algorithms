package java1.algorithms.simulation.robotBounded;

public class RobotBounded {
    //Simulation for cyclic detection TC: O(n) SC: O(1)
    public static boolean isRobotBounded(String instructions) {
        int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}}; //North-0, east-1, south-2 and west-3
        int dir = 0; //Facing north direction
        int x =0, y=0;

        for(char ch: instructions.toCharArray()) {
            if(ch == 'G')  {
                x += dirs[dir][0];
                y += dirs[dir][1];
            }
            if(ch == 'L') {
                dir = (dir+3)%4; // turn left
            }
            if(ch == 'R') {
                dir = (dir+1)%4; //turn right
            }
        }

        //bounded if it is back to origin or not facing to north
        return (x == 0 && y == 0) || dir !=0;
    }

    public static void main(String[] args) {
        Object[][] tests = {
            // {instructions, expected}
            {"GGLLGG",   true},   // returns to origin
            {"GG",       false},  // moves north forever
            {"GL",       true},   // not facing north after cycle
            {"GRGRGRGR", true},   // 4 right turns → back to origin
            {"GLGR",     false},  // ends at (-1,1) facing north
            {"LLLGGG",   true},   // facing east after cycle
        };

        for (Object[] test : tests) {
            String instructions = (String) test[0];
            boolean expected = (boolean) test[1];
            boolean result = isRobotBounded(instructions);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] instructions=\"" + instructions + "\" result=" + result + " expected=" + expected);
        }
    }
}
