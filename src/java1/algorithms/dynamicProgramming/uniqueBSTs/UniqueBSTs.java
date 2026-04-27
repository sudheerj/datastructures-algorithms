package java1.algorithms.dynamicProgramming.uniqueBSTs;

public class UniqueBSTs {
    //DP bottom-up: TC:O(n2) SC: O(n)
    private static int uniqueBSTs(int n) {
        int[] dp = new int[n+1];
        if(n <=1) return 1;

        dp[0] = dp[1] = 1;

        for(int nodes=2; nodes<= n; nodes++) {
            int total = 0;
            for(int root=1; root<=nodes; root++) {
                int left = root-1;
                int right = nodes-root;
                total += dp[left] * dp[right];
            }
            dp[nodes] = total;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] testCases = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.println("Test case " + (i + 1) + ": n = " + n);
            int result = uniqueBSTs(n);
            System.out.println("Output: " + result);
        }
    }
}
