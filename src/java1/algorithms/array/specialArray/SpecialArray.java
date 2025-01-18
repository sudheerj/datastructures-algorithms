package java1.algorithms.array.specialArray;

public class SpecialArray {
    private static int specialArray(int[] nums) {
        int len = nums.length;
        int[] counts = new int[len+1];

        for(int num: nums){
            if(num >=len) {
                counts[len]++;
            } else {
                counts[num]++;
            }
        }
        
        int elementsGreaterThanX = 0;
        for (int x = len; x >= 1; x--) {
            elementsGreaterThanX += counts[x];
            if(elementsGreaterThanX == x) {
                return x;
            }
        }

        return -1;
    } 

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3};
        int[] nums2 = new int[]{0,0,0};
        int[] nums3 = new int[]{0,4,3,0,4};
        System.out.println(specialArray(nums1));
        System.out.println(specialArray(nums2));
        System.out.println(specialArray(nums3));        
    }
}
