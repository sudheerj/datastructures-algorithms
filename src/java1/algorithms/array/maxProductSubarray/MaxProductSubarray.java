package maxProductSubarray;

public class MaxProductSubarray {
    private static int maxProductSubArray(int[] nums) {
        int result = nums[0];
        int currentMax = 1, currentMin = 1;
        for(int num: nums) {
            int tempMaxProduct = currentMax * num;
            int tempMinProduct = currentMin * num;
            currentMax = Math.max(Math.max(tempMaxProduct, tempMinProduct), num);
            currentMin = Math.min(Math.min(tempMaxProduct, tempMinProduct), num);
            result = Math.max(currentMax, result);
        }
        return result;
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
