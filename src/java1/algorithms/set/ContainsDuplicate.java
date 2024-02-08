// TC: O(n), SC: O(1)
import java.util.*;

class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {8, 6, 4, 2, 6};
        System.out.println(containsDuplicate(nums));

        int[] nums1 = {1, 3, 5, 7, 9};
        System.out.println(containsDuplicate(nums1));
    }
    
}