// Two pointer approach:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(1)
import java.util.*;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i < nums.length-2; i++) {
                if(i > 0 && nums[i] == nums[i-1]) continue;
                
                int left = i + 1, right = nums.length-1;

                while(left < right) {
                    int sum = nums[left] + nums[right] + nums[i] ;
                    if(sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                    else {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        triplets.add(triplet);
                        left++;
                        while(left < right && nums[left] == nums[left-1]) left++;
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

/** // Hashing:- TC: O(n logn) + O(n*2) => O(n * 2), SC: O(n)
class ThreeSumHashing {
    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<Integer> hashset = new HashSet<>();

        for(int i=0; i< nums.length -2; i++) {
            for(int j=i+1; j< nums.length-1; j++) {
                int compliment = target -(nums[i]+nums[j]);
                if(hashset.contains(compliment)) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[compliment]);
                    triplets.add(triplet);
                }
                hashset.add(nums[compliment]);
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, -1, -2, 0, -2, 0, -1, 0, -1};
        System.out.println(threeSum(nums, 0));
    }
} */
