package java1.algorithms.stack.minMaxRiddle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class MinMaxRiddle {
    // Monotonic increasing stack using Deque TC: O(n) SC: O(n)
    public static List<Long> minMaxRiddle(List<Long> nums) {
        int n = nums.size();
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();

        // Find smaller element to Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums.get(stack.peek()) >= nums.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();
        // Find smaller element to Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums.get(stack.peek()) >= nums.get(i)) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        // Find answer window size
        long[] answer = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            answer[windowSize] = Math.max(answer[windowSize], nums.get(i));
        }

        // Fill missing window sizes
        for (int i = n - 1; i >= 1; i--) {
            answer[i] = Math.max(answer[i], answer[i + 1]);
        }

        List<Long> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(answer[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Long>> tests = Arrays.asList(
                Arrays.asList(6L, 3L, 5L, 1L, 12L),
                Arrays.asList(1L, 2L, 3L, 5L, 1L, 13L, 3L),
                Arrays.asList(4L),
                Arrays.asList(2L, 2L, 2L));
        List<List<Long>> expected = Arrays.asList(
                Arrays.asList(12L, 3L, 3L, 1L, 1L),
                Arrays.asList(13L, 3L, 2L, 1L, 1L, 1L, 1L),
                Arrays.asList(4L),
                Arrays.asList(2L, 2L, 2L));
        String[] labels = {
                "Example 1",
                "Example 2",
                "single element",
                "all values equal"
        };

        for (int i = 0; i < tests.size(); i++) {
            List<Long> actual = minMaxRiddle(tests.get(i));
            System.out.println("[" + (actual.equals(expected.get(i)) ? "PASS" : "FAIL") + "] "
                    + labels[i] + ": " + actual + " (expected " + expected.get(i) + ")");
        }
    }
}
