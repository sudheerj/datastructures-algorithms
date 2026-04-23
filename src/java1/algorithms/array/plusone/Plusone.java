package plusone;

public class Plusone {
    public static void main(String[] args) {
        // Example 1: No carry
        int[] digits1 = { 1, 2, 3 };
        System.out.print("Input: [1, 2, 3] -> Output: ");
        printArray(plusOne(digits1));

        // Example 2: Carry at the end
        int[] digits2 = { 1, 2, 9 };
        System.out.print("Input: [1, 2, 9] -> Output: ");
        printArray(plusOne(digits2));

        // Example 3: All 9's
        int[] digits3 = { 9, 9, 9 };
        System.out.print("Input: [9, 9, 9] -> Output: ");
        printArray(plusOne(digits3));

        // Example 4: Single digit, no carry
        int[] digits4 = { 5 };
        System.out.print("Input: [5] -> Output: ");
        printArray(plusOne(digits4));

        // Example 5: Single digit, carry
        int[] digits5 = { 9 };
        System.out.print("Input: [9] -> Output: ");
        printArray(plusOne(digits5));

        // Example 6: Leading zeros
        int[] digits6 = { 0, 0, 1 };
        System.out.print("Input: [0, 0, 1] -> Output: ");
        printArray(plusOne(digits6));

        // Example 7: Empty array (edge case)
        int[] digits7 = {};
        System.out.print("Input: [] -> Output: ");
        printArray(plusOne(digits7));
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // carry over
        }

        // Incase of all 9's
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
