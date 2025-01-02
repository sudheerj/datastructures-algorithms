package java1.algorithms.array.intersectionOfArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfArrays {
    private static List<Integer> intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : nums1) {
            set.add(num);
        }

        for (Integer num : nums2) {
            if(set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }

        return result;    
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,3,3,5}, nums2 = new int[]{5,3};
        int[] nums3 = new int[]{1, 3, 5}, nums4 = new int[]{2,4};
        System.out.println(intersection(nums1, nums2));
        System.out.println(intersection(nums3, nums4));
    }
}
