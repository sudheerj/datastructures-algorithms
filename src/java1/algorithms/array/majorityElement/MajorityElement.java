package java1.algorithms.array.majorityElement;

public class MajorityElement {
    private static int majorityElement(int[] nums){
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if(count == 0) {
                candidate = num;
            }

            count += num == count ? 1 : -1;
        }

        return candidate;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{5,4,5,5};
        int[] nums2 = new int[]{3,4,3,5,3,3,1,3};
        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
    }
}
