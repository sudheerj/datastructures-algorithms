package numPairsDivisibleBy60;

public class NumPairsDivisibleBy60 {
    //Remainder or compliment hashing with fixed bucket size TC: O(n) SC: O(1)
    private int numPairsDivisibleBy60(int[] time) {
        int[] countRemainders = new int[60];
        int pairs = 0;

        for(int duration : time) {
            int remainder = duration%60;
            int compliment = (60 -remainder)%60;

            pairs += countRemainders[compliment];
            countRemainders[remainder]++;
        }

        return pairs;
    }
        public static void main(String[] args) {
            NumPairsDivisibleBy60 solver = new NumPairsDivisibleBy60();
            int[][] testCases = {
                {30, 20, 150, 100, 40},    // 3 pairs
                {60, 60, 60},              // 3 pairs
                {10, 50, 90, 30},          // 2 pairs
                {1, 2, 3, 4, 5, 6},        // 0 pairs
                {60, 120, 180},            // 3 pairs
                {20, 40, 60, 80, 100, 120} // 5 pairs
            };
            int[] expected = {3, 3, 2, 0, 3, 5};
            for (int i = 0; i < testCases.length; i++) {
                int result = solver.numPairsDivisibleBy60(testCases[i]);
                String status = result == expected[i] ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
            }
        }

}
