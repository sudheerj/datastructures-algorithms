package intersectionOfArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {
    //Using two sets and linear scan TC: O(n + m) SC: O(n + k) = Intersection size
    private static int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (Integer num : nums1) {
            set.add(num);
        }

        for (Integer num : nums2) {
            if(set.contains(num)) {
                result.add(num);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();    
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,3,3,5}, nums2 = new int[]{5,3};
        int[] nums3 = new int[]{1, 3, 5}, nums4 = new int[]{2,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        System.out.println(Arrays.toString(intersection(nums3, nums4)));
    }
}
