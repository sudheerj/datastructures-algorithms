package java1.algorithms.array.sumRange;

public class SumRange {
    private int[] prefixSum;

    SumRange(int[] nums) {
        this.prefixSum = new int[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            this.prefixSum[i+1] = this.prefixSum[i] + nums[i];
        }
    }

    private int sumRange(int left, int right){
        return this.prefixSum[right+1] - this.prefixSum[left];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{6, -3, 1, 5, 3, 7, -5};
        SumRange sumRangeInstance = new SumRange(nums1);
        System.out.println(sumRangeInstance.sumRange(0, 3));
        System.out.println(sumRangeInstance.sumRange(2, 6));
        System.out.println(sumRangeInstance.sumRange(0, 6));
    }
}
