package java1.algorithms.array.minimumPrefixRemoval;

public class MinimumPrefixRemoval {
    //Reversal traversal(backward scan) TC: O(n) SC: O(1)
    private static int minimumPrefixRemoval(int[] nums) {
        int n = nums.length;

        for(int i=n-1; i>0; i--) {
            if(nums[i-1] >= nums[i]) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        System.out.println(minimumPrefixRemoval(
                new int[]{1, -1, 2, 3, 3, 4, 5})); // 4

        System.out.println(minimumPrefixRemoval(
                new int[]{4, 3, -2, -5})); // 3

        System.out.println(minimumPrefixRemoval(
                new int[]{1, 2, 3, 4})); // 0

        System.out.println(minimumPrefixRemoval(
                new int[]{5})); // 0

        System.out.println(minimumPrefixRemoval(
                new int[]{2, 2})); // 1

        System.out.println(minimumPrefixRemoval(
                new int[]{3, 2, 1})); // 2

        System.out.println(minimumPrefixRemoval(
                new int[]{1, 3, 5, 4, 6})); // 3
    }
}
