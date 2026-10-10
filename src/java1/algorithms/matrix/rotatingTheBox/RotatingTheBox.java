package java1.algorithms.matrix.rotatingTheBox;

import java.util.Arrays;

public class RotatingTheBox {
    // Simulate gravity, then rotate clockwise: TC O(m*n), SC O(m*n)
    public static char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        // Stones fall to the right within each row, stopping at obstacles.
        for (int r = 0; r < rows; r++) {
            int empty = cols - 1;
            for (int c = cols - 1; c >= 0; c--) {
                if (box[r][c] == '*') {
                    empty = c - 1;
                } else if (box[r][c] == '#') {
                    box[r][c] = '.';
                    box[r][empty] = '#';
                    empty--;
                }
            }
        }

        // Rotate the settled box 90 degrees clockwise.
        char[][] rotated = new char[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rotated[c][rows - 1 - r] = box[r][c];
            }
        }
        return rotated;
    }

    private static boolean matricesEqual(char[][] actual, char[][] expected) {
        return Arrays.deepEquals(actual, expected);
    }

    private static String format(char[][] matrix) {
        StringBuilder result = new StringBuilder("[");
        for (int r = 0; r < matrix.length; r++) {
            if (r > 0) {
                result.append(", ");
            }
            result.append(Arrays.toString(matrix[r]));
        }
        return result.append(']').toString();
    }

    public static void main(String[] args) {
        char[][][] boxes = {
                {
                        { '#', '.', '*', '.' },
                        { '#', '#', '*', '.' }
                },
                {
                        { '#', '#', '*', '.', '*', '.' },
                        { '#', '#', '#', '*', '.', '.' },
                        { '#', '#', '#', '.', '#', '.' }
                },
                { { '#' } },
                {
                        { '.', '#', '.' },
                        { '#', '*', '#' }
                }
        };
        char[][][] expected = {
                {
                        { '#', '.' },
                        { '#', '#' },
                        { '*', '*' },
                        { '.', '.' }
                },
                {
                        { '.', '#', '#' },
                        { '.', '#', '#' },
                        { '#', '#', '*' },
                        { '#', '*', '.' },
                        { '#', '.', '*' },
                        { '#', '.', '.' }
                },
                { { '#' } },
                {
                        { '#', '.' },
                        { '*', '.' },
                        { '#', '#' }
                }
        };
        String[] labels = {
                "Example 1: stones settle beside obstacles",
                "Example 2: multiple rows and obstacles",
                "single cell",
                "stones on both sides of an obstacle"
        };

        for (int i = 0; i < boxes.length; i++) {
            char[][] actual = rotateTheBox(boxes[i]);
            boolean passed = matricesEqual(actual, expected[i]);
            System.out.println("[" + (passed ? "PASS" : "FAIL") + "] " + labels[i]
                    + ": " + format(actual) + " (expected " + format(expected[i]) + ")");
        }
    }
}
