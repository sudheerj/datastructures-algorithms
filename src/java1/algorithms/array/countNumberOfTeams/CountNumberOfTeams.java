package countNumberOfTeams;

public class CountNumberOfTeams {
    //Fixed element + count left/right contributions TC: O(n^2) SC: O(1)
    private int numTeams(int[] rating) {
        int n= rating.length;
        int count = 0;

        for(int j=0; j<n; j++) {
            int leftLess = 0, leftGreater =0, rightLess = 0, rightGreater = 0;

            //left side of j
            for(int i=0; i<j; i++) {
                if(rating[i] < rating[j]) leftLess++;
                else {
                    leftGreater++;
                }
            }

            //right side of j
            for(int k=j+1; k<n; k++) {
                if(rating[k] < rating[j]) rightLess++;
                else {
                    rightGreater++;
                }
            }

            //increasing tripplets
            count += leftLess * rightGreater;
            //decreasing tripplets
            count += leftGreater * rightLess;

        }
        return count;
    }
    public static void main(String[] args) {
            CountNumberOfTeams solver = new CountNumberOfTeams();
            int[][] testCases = {
                {2, 5, 3, 4, 1},      // 3
                {2, 1, 3},            // 0
                {1, 2, 3, 4},         // 4
                {4, 3, 2, 1},         // 4
                {1, 3, 2, 4, 5},      // 7
                {1, 2, 3, 2, 1},      // 4
                {1, 1, 1, 1},         // 0
                {1, 2, 1, 2, 1, 2}    // 5
            };
            int[] expected = {3, 0, 4, 4, 7, 4, 0, 5};
            for (int i = 0; i < testCases.length; i++) {
                int result = solver.numTeams(testCases[i]);
                String status = result == expected[i] ? "PASS" : "FAIL";
                System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, expected[i], status);
            }
    }

}
