package java1.algorithms.array.disappearedNumbers;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

    private static List<Integer> findDisappearedNumbers(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >0) {
                missingNumbers.add(i+1);
            }
        }

        return missingNumbers;
    }
    public static void main(String[] args) {
        int[] nums1= new int[]{6, 3, 1, 5, 3, 7, 5};
        int[] nums2= new int[]{1, 1};

        System.out.println(findDisappearedNumbers(nums1));
        System.out.println(findDisappearedNumbers(nums2));
    }
}