package maxProductSubarray;

public class MaxProductSubarray {
    private static int maxProductSubArray(int[] nums) {
        int currentMaxProduct = nums[0], currentMinProduct = nums[0], globalMaxProduct = nums[0];
        for(int i=1; i< nums.length; i++) {
            int num = nums[i];
            if(num <0) {
                int temp = currentMinProduct;
                currentMinProduct = currentMaxProduct;
                currentMaxProduct = temp;
            }

            currentMinProduct = Math.min(num, currentMinProduct * num);
            currentMaxProduct = Math.max(num, currentMaxProduct * num);
            globalMaxProduct = Math.max(globalMaxProduct, currentMaxProduct);
        }
        return globalMaxProduct;
    }

    public static void main(String[] args) {
        int[] numbers1 = {6, 7,-4, 5, 8, 1};
        System.out.println(maxProductSubArray(numbers1));

        int[] numbers2 = {2, 7,-4, 0, 3, 3};
        System.out.println(maxProductSubArray(numbers2));

        int[] numbers3 = {-2, 0, -2};
        System.out.println(maxProductSubArray(numbers3));
    }
}
