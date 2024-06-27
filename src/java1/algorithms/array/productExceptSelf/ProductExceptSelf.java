package productExceptSelf;

import java.util.Arrays;

public class ProductExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix=1, postfix=1;
        for(int i=0; i< nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for(int i= nums.length-1; i>=0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    } 

    public static void main(String[] args) {
        int[] productArray1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(productExceptSelf(productArray1)));
        int[] productArray2 = {-3, 3, 2, 0, -4};
        System.out.println(Arrays.toString(productExceptSelf(productArray2)));
    }
}
