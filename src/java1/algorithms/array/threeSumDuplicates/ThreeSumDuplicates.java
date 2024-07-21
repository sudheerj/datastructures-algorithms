package threeSumDuplicates;
import java.util.*;

// Hashing:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(n)
public class ThreeSumDuplicates {
    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<Integer> hashset = new HashSet<>();

        for(int i=0; i< nums.length-2; i++) {
            for(int j=i+1; j< nums.length-1; j++) {
                int complement = target -(nums[i]+nums[j]);
                if(hashset.contains(complement) && !triplets.contains(List.of(nums[i], nums[j], complement))) {
                    triplets.add(List.of(nums[i], nums[j], complement));
                } else {
                    hashset.add(nums[j]);
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, -1, -2, 0, -2, 0, -1, 0, -1};
        System.out.println(threeSum(nums, 0));
    }
}