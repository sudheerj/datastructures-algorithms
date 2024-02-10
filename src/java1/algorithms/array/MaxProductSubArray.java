public class MaxProductSubArray {
    private static int maxProductSubArray(int[] nums) {
        int result = nums[0];
        int currentMax = 1, currentMin = 1;
        for(int n: nums) {
            int tempMaxProduct = currentMax * n;
            currentMax = Math.max(Math.max(tempMaxProduct, currentMin * n), n);
            currentMin = Math.min(Math.min(tempMaxProduct, currentMin * n), n);
            result = Math.max(currentMax, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers1 = {6, 7,-4, 5, 8, 1};
        System.out.println(maxProductSubArray(numbers1));

        int[] numbers2 = {2, 7,-4, 0, 3, 3};
        System.out.println(maxProductSubArray(numbers2));
    }
}
