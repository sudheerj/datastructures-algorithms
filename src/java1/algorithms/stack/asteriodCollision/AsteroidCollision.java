package java1.algorithms.stack.asteriodCollision;

import java.util.Stack;

public class AsteroidCollision {
    //Using stack push & pop operations TC: O(n) SC:O(n)
    private int[] asteriodCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                // smaller asteriod at top of stack
                if (stack.peek() < -a) {
                    stack.pop();
                    continue;
                }
                // both asteroids in same size
                if (stack.peek() == -a) {
                    stack.pop();
                    a = 0;
                    break;
                }

                // current asteroid is smaller
                a = 0;
                break;
            }

            // survived asteroid
            if (a != 0) {
                stack.push(a);
            }
        }

        int[] finalAsteroids = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            finalAsteroids[i] = stack.pop();
        }

        return finalAsteroids;
    }

    private static String pass(boolean ok) {
        return ok ? "PASS" : "FAIL";
    }

    public static void main(String[] args) {
        AsteroidCollision sol = new AsteroidCollision();

        int[][][] tests = {
                { { 5, 10, -5 }, { 5, 10 } }, // -5 destroyed by 10
                { { 8, -8 }, {} }, // equal size, both destroyed
                { { 10, 2, -5 }, { 10 } }, // -5 destroys 2, then hit by 10
                { { -2, -1, 1, 2 }, { -2, -1, 1, 2 } }, // no collision, all moving away
                { { 1, -2 }, { -2 } }, // -2 destroys 1 and survives
                { { -1, -2, 1, 2 }, { -1, -2, 1, 2 } } // left-movers already past right-movers
        };
        String[] labels = {
                "-5 destroyed by 10",
                "equal size, both destroyed",
                "-5 destroys 2, blocked by 10",
                "no collisions",
                "-2 destroys 1 and survives",
                "left-movers already past right-movers"
        };

        for (int i = 0; i < tests.length; i++) {
            int[] result = sol.asteriodCollision(tests[i][0]);
            int[] expected = tests[i][1];
            boolean ok = java.util.Arrays.equals(result, expected);
            System.out.println("  [" + pass(ok) + "] " + labels[i]
                    + ": " + java.util.Arrays.toString(result)
                    + "  (expected " + java.util.Arrays.toString(expected) + ")");
        }
    }
}
