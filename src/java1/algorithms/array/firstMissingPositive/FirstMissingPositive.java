package firstMissingPositive;

public class FirstMissingPositive {

    private static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int nonExistNum = length + 1;

        for(int i=0; i< length; i++){
            if(nums[i] <=0 || nums[i] > length) {
                nums[i] = nonExistNum;
            }
        }

        for (int i = 0; i < length; i++) {
            int index = Math.abs(nums[i]);
            if(index == nonExistNum) {
                continue;
            }
            index--;
            if(nums[index] > 0) {
                nums[index] = -1 *  nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >0) {
                return i+1;
            }
        }

        return length+1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3 ,4, -1, 1};
        int[] nums2 = {-1,7,8,9,11,12,-10};
        int[] nums3 = {1,2,0};

        System.out.println(firstMissingPositive(nums1));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
    }
}
