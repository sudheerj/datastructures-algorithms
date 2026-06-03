package java1.algorithms.strings.performStringShifts;

public class PerformStringShifts {

    //Compute net shift TC: O(m + n) m= number of operations, n= length of string, SC: O(n)
    private String stringShift(String str, int[][] shift) {
        int netShift = 0;

        for(int[] ops: shift) {
            int direction = ops[0], shiftAmount = ops[1];

            if(direction == 0) {
                netShift -= shiftAmount;
            } else {
                netShift += shiftAmount;
            }
        }

        int n = str.length();

        //convert netShift to rightShift
        netShift = ((netShift%n) +n)%n;

        return str.substring(n-netShift) + str.substring(0, n-netShift);
    }
        public static void main(String[] args) {
            PerformStringShifts solver = new PerformStringShifts();
            String[] testStrings = {"abc", "abcdefg", "x", "hello", "rotation"};
            int[][][] testShifts = {
                {{0,1},{1,2}},
                {{1,1},{1,1},{0,2},{1,3}},
                {{0,100}},
                {{1,5}},
                {{0,3},{1,4}}
            };
            String[] expected = {"cab", "efgabcd", "x", "hello", "nrotatio"};
            for (int i = 0; i < testStrings.length; i++) {
                String result = solver.stringShift(testStrings[i], testShifts[i]);
                String status = result.equals(expected[i]) ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %s | Expected: %s | %s\n", i+1, result, expected[i], status);
            }
        }
}
