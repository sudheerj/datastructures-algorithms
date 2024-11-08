package java1.algorithms.array.removeElement;

public class RemoveElement {

    private static int removeElement(int[] nums, int val){
        int k = 0;

        for (int num : nums) {
            if (num != val) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 1, 4, 1};
        int val1=4;
        System.out.println(removeElement(nums1, val1));
        int[] nums2 = new int[]{0, 3, 5, 5, 3, 1, 5, 2};
        int val2=5;
        System.out.println(removeElement(nums2, val2));
    }
}