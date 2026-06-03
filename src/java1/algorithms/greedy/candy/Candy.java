package java1.algorithms.greedy.candy;

public class Candy {
    // Returns the minimum candies needed using Greedy TC: O(2n) ~= O(n) SC: O(n) 
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        //left to right
        for(int i=0; i<n; i++) {
            candies[i] = 1;
            if(i>0 && ratings[i] > ratings[i-1]) {
                candies[i] = 1 + candies[i-1];
            }
        }

        //right to left
        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i+1]);
            }
        }

        int minCandies = 0;
        for(int value: candies) {
            minCandies += value;
        }

        return minCandies;
    }

    public static void main(String[] args) {
        Candy obj = new Candy();
        int[][] testCases = {
            {1,0,2},
            {1,2,2},
            {1,3,2,2,1},
            {1,2,87,87,87,2,1},
            {1,3,4,5,2},
            {1,2,3,1,0},
            {1,6,10,8,7,3,2},
            {1,2,2,1,2,2,1},
            {1,2,3,4,5},
            {5,4,3,2,1}
        };
        int[] expected = {5,4,7,13,11,9,18,11,15,15};
        for (int i = 0; i < testCases.length; i++) {
            int[] input = testCases[i];
            int exp = expected[i];
            int result = obj.candy(input);
            String status = result == exp ? "PASS" : "FAIL";
            System.out.printf("Test %d | Output: %d | Expected: %d | %s\n", i+1, result, exp, status);
        }
    }
}
