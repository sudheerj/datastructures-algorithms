package productExceptSelf;

import java.util.Arrays;

public class ProductExceptSelf {
    // Using prefix and postfix pattern(Optimized space) TC: O(n) SC: O(1)(output
    // array excluded)
    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1, postfix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    // Using prefix and postfix arrays TC: O(n) SC: O(n)
    private static int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];

        int[] prefixArr = new int[nums.length];
        int[] postfixArr = new int[nums.length];

        prefixArr[0] = 1;
        postfixArr[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixArr[i] = nums[i - 1] * prefixArr[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            postfixArr[i] = nums[i + 1] * postfixArr[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArr[i] * postfixArr[i];
        }

        return result;
    }

    // Using division TC: O(n) SC: O(1)
    private static int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        int product = 1, zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                result[i] = nums[i] == 0 ? product : 0;
            } else {
                result[i] = product / nums[i];
            }
        }

        return result;
    }

    // Using bruteforce TC: O(n^2) SC: O(1)
    private static int[] productExceptSelf4(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                product *= nums[j];
            }
            result[i] = product;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 2, 3, 4 };
        int[] t2 = { -1, 1, 0, -3, 3 };
        int[] t3 = { 1, 2, 3, 4, 5 };
        int[] t4 = { 0, 0 };
        int[] t5 = { 2, 3, 4 };
        String e1 = "[24, 12, 8, 6]";
        String e2 = "[0, 0, 9, 0, 0]";
        String e3 = "[120, 60, 40, 30, 24]";
        String e4 = "[0, 0]";
        String e5 = "[12, 8, 6]";

        // Approach 1: prefix/postfix optimized
        String r1 = Arrays.toString(productExceptSelf(t1));
        System.out.println(
                "Test 1 (opt): " + (r1.equals(e1) ? "[PASS]" : "[FAIL]") + " result=" + r1 + " expected=" + e1);
        String r2 = Arrays.toString(productExceptSelf(t2));
        System.out.println(
                "Test 2 (opt): " + (r2.equals(e2) ? "[PASS]" : "[FAIL]") + " result=" + r2 + " expected=" + e2);
        String r3 = Arrays.toString(productExceptSelf(t3));
        System.out.println(
                "Test 3 (opt): " + (r3.equals(e3) ? "[PASS]" : "[FAIL]") + " result=" + r3 + " expected=" + e3);
        String r4 = Arrays.toString(productExceptSelf(t4));
        System.out.println(
                "Test 4 (opt): " + (r4.equals(e4) ? "[PASS]" : "[FAIL]") + " result=" + r4 + " expected=" + e4);
        String r5 = Arrays.toString(productExceptSelf(t5));
        System.out.println(
                "Test 5 (opt): " + (r5.equals(e5) ? "[PASS]" : "[FAIL]") + " result=" + r5 + " expected=" + e5);

        // Approach 2: prefix/postfix arrays
        String r6 = Arrays.toString(productExceptSelf1(t1));
        System.out.println(
                "Test 1 (arr): " + (r6.equals(e1) ? "[PASS]" : "[FAIL]") + " result=" + r6 + " expected=" + e1);
        String r7 = Arrays.toString(productExceptSelf1(t2));
        System.out.println(
                "Test 2 (arr): " + (r7.equals(e2) ? "[PASS]" : "[FAIL]") + " result=" + r7 + " expected=" + e2);
        String r8 = Arrays.toString(productExceptSelf1(t3));
        System.out.println(
                "Test 3 (arr): " + (r8.equals(e3) ? "[PASS]" : "[FAIL]") + " result=" + r8 + " expected=" + e3);
        String r9 = Arrays.toString(productExceptSelf1(t4));
        System.out.println(
                "Test 4 (arr): " + (r9.equals(e4) ? "[PASS]" : "[FAIL]") + " result=" + r9 + " expected=" + e4);
        String r10 = Arrays.toString(productExceptSelf1(t5));
        System.out.println(
                "Test 5 (arr): " + (r10.equals(e5) ? "[PASS]" : "[FAIL]") + " result=" + r10 + " expected=" + e5);

        // Approach 3: division
        String r11 = Arrays.toString(productExceptSelf3(t1));
        System.out.println(
                "Test 1 (div): " + (r11.equals(e1) ? "[PASS]" : "[FAIL]") + " result=" + r11 + " expected=" + e1);
        String r12 = Arrays.toString(productExceptSelf3(t2));
        System.out.println(
                "Test 2 (div): " + (r12.equals(e2) ? "[PASS]" : "[FAIL]") + " result=" + r12 + " expected=" + e2);
        String r13 = Arrays.toString(productExceptSelf3(t3));
        System.out.println(
                "Test 3 (div): " + (r13.equals(e3) ? "[PASS]" : "[FAIL]") + " result=" + r13 + " expected=" + e3);
        String r14 = Arrays.toString(productExceptSelf3(t4));
        System.out.println(
                "Test 4 (div): " + (r14.equals(e4) ? "[PASS]" : "[FAIL]") + " result=" + r14 + " expected=" + e4);
        String r15 = Arrays.toString(productExceptSelf3(t5));
        System.out.println(
                "Test 5 (div): " + (r15.equals(e5) ? "[PASS]" : "[FAIL]") + " result=" + r15 + " expected=" + e5);

        // Approach 4: brute force
        String r16 = Arrays.toString(productExceptSelf4(t1));
        System.out.println(
                "Test 1 (brute): " + (r16.equals(e1) ? "[PASS]" : "[FAIL]") + " result=" + r16 + " expected=" + e1);
        String r17 = Arrays.toString(productExceptSelf4(t2));
        System.out.println(
                "Test 2 (brute): " + (r17.equals(e2) ? "[PASS]" : "[FAIL]") + " result=" + r17 + " expected=" + e2);
        String r18 = Arrays.toString(productExceptSelf4(t3));
        System.out.println(
                "Test 3 (brute): " + (r18.equals(e3) ? "[PASS]" : "[FAIL]") + " result=" + r18 + " expected=" + e3);
        String r19 = Arrays.toString(productExceptSelf4(t4));
        System.out.println(
                "Test 4 (brute): " + (r19.equals(e4) ? "[PASS]" : "[FAIL]") + " result=" + r19 + " expected=" + e4);
        String r20 = Arrays.toString(productExceptSelf4(t5));
        System.out.println(
                "Test 5 (brute): " + (r20.equals(e5) ? "[PASS]" : "[FAIL]") + " result=" + r20 + " expected=" + e5);
    }
}
