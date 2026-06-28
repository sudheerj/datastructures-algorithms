package java1.algorithms.greedy.maxProductTwoElements;

public class MaxProductTwoElements {
    //Greedy selection TC: O(n) SC: O(1)
    private static int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for(int n: nums) {
            if(n > max1) {
                max2 = max1;
                max1 = n;
            } else if(n > max2) {
                max2 = n;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3, 4, 5, 2}));      // 12
        System.out.println(maxProduct(new int[]{1, 5, 4, 5}));      // 16
        System.out.println(maxProduct(new int[]{10, 2, 5, 2}));     // 36
        System.out.println(maxProduct(new int[]{7, 7, 7, 7}));      // 36
        System.out.println(maxProduct(new int[]{9, 1}));            // 0
    }
}
