package java1.algorithms.math.sortIntegersByPowerValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortIntegersByPowerValue {
    // Store already computed power values
    static Map<Integer, Integer> memo = new HashMap<>();

    // Using memoization TC: O(n logn) SC: O(n)
    private static int getKth(int low, int high, int k) {
        memo.put(1, 0);

        // Store number and power values
        List<int[]> list = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            int power = power(i);
            list.add(new int[] { i, power });
        }

        // Sort based on power value, if tie sort based on numbers
        Collections.sort(list, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        return list.get(k - 1)[0];
    }

    private static int power(int x) {
        if (memo.containsKey(x)) {
            return memo.get(x);
        }

        int steps = 0;

        if (x % 2 == 0) {
            steps = 1 + power(x / 2);
        } else {
            steps = 1 + power(3 * x + 1);
        }

        memo.put(x, steps);

        return steps;
    }

    public static void main(String[] args) {
        int r1 = getKth(12, 15, 2);
        System.out.println(
                "Test 1 - lo=12 hi=15 k=2: " + (r1 == 13 ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=13");

        int r2 = getKth(7, 11, 4);
        System.out.println(
                "Test 2 - lo=7 hi=11 k=4: " + (r2 == 7 ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=7");

        int r3 = getKth(1, 5, 3);
        System.out.println(
                "Test 3 - lo=1 hi=5 k=3: " + (r3 == 4 ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=4");

        int r4 = getKth(3, 5, 2);
        System.out.println(
                "Test 4 - lo=3 hi=5 k=2: " + (r4 == 5 ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=5");

        int r5 = getKth(1, 3, 1);
        System.out.println(
                "Test 5 - lo=1 hi=3 k=1: " + (r5 == 1 ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=1");
    }
}
