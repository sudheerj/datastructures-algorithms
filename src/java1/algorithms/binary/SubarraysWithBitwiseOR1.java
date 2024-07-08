package java1.algorithms.binary;

public class SubarraysWithBitwiseOR1 {
    // Method to solve the problem of counting subarrays with bitwise OR 1
    public static long solve(int A, int[] B) {
        // Initialize total count of subarrays
        long subArrCount = 0;

        // Iterate over array B from the end to start
        for (int i = A - 1; i >= 0; i--) {
            // If current element is 1, calculate number of subarrays ending at index i
            if (B[i] == 1) {
                int count = A - i;
                subArrCount += count;
            }
            // Add count of subarrays where B[i] is 0 (same as previous iteration)
            subArrCount += B[i] == 0 ? 0 : 1; // If B[i] is 1, add 1; if B[i] is 0, add 0
        }

        return subArrCount;
    }

    public static void main(String[] args) {
        int A = 5;
        int[] B = {0, 1, 0, 1, 1};
        long result = solve(A, B);
        System.out.println("Total subarrays with bitwise OR 1: " + result);
    }

}
