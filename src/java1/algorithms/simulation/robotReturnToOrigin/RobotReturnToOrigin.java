package java1.algorithms.simulation.robotReturnToOrigin;

public class RobotReturnToOrigin {
    // String simulation TC: O(n) SC: O(1)
    public static boolean judgeCircle(String moves) {
        int x=0, y=0;

        for(char move: moves.toCharArray()) {
            switch (move) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Object[][] tests = {
            // {moves, expected}
            {"UD",     true},   // up then down → origin
            {"LL",     false},  // two lefts → not origin
            {"LRUD",   true},   // balanced all directions
            {"LDRRUUUDDL", true},  // L+R cancel, U+D cancel → origin
            {"",       true},   // empty string → already at origin
            {"UDLR",   true},   // one of each → origin
        };

        for (Object[] test : tests) {
            String moves = (String) test[0];
            boolean expected = (boolean) test[1];
            boolean result = judgeCircle(moves);
            String status = result == expected ? "PASS" : "FAIL";
            System.out.println("[" + status + "] moves=\"" + moves + "\" result=" + result + " expected=" + expected);
        }
    }
}
