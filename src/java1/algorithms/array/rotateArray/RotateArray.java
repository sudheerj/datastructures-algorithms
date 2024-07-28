package rotateArray;

import java.util.Arrays;

public class RotateArray {

    private static int[] rotate(int[] nums, int n) {
        int length = nums.length;
        n %= length;

        reversal(nums, 0, length-1);
        reversal(nums, 0, n-1);
        reversal(nums, n, length-1);

        return nums;
    }

    private static void reversal(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] rotate1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Before rotate: "+ Arrays.toString(rotate1));
        rotate(rotate1, 4);
        System.out.println("After rotate: "+ Arrays.toString(rotate1));

        int[] rotate2 = {-10, 4, 5, -1};
        System.out.println("Before rotate: "+ Arrays.toString(rotate2));
        rotate(rotate2, 2);
        System.out.println("After rotate: "+ Arrays.toString(rotate2));   
    }
}
