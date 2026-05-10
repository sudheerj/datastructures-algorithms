package java1.algorithms.array.kDiffPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDiffPairs {
    // Using set TC: O(n) SC: O(1)
    private static int kDiffPairs(int[] nums, int k) {
        if(k < 0) return 0;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for(int num: nums) {
            if(seen.contains(num-k)) { // if current element is bigger
                pairs.add(num-k);
            }

            if(seen.contains(num+k)) { // if current element is smaller
                pairs.add(num);
            }

            seen.add(num);
        }

        return pairs.size();
    }

    //Using two pointers TC: O(n log n) SC: O(1)
    private static int kDiffPairsSorting(int[] nums, int k) {
        Arrays.sort(nums);

        int left =0, right =1, count = 0;

        while(right < nums.length) {
            int diff = nums[right] - nums[left];

            if(diff > k) {
                right++;
            } else if(diff < k) {
                left++;
            } else {
                count++;
                left++;
                right++;
            }

            if(left == right) {
                right++;
            }
        }

        return count;
    }

    private static List<int[]> kDifferencePairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        //Store all unique elements
        for(int num: nums) {
            set.add(num);
        }

        for(int num: set) {
            int target = num+k;

            if(set.contains(target)) {
                result.add(new int[]{target, num});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // kDiffPairs (count unique pairs)
        System.out.println("-- kDiffPairs (HashSet) --");
        System.out.println(kDiffPairs(new int[]{3,1,4,1,5}, 2) + " (expected 2)");   // (1,3),(3,5)
        System.out.println(kDiffPairs(new int[]{1,2,3,4,5}, 1) + " (expected 4)");   // (1,2),(2,3),(3,4),(4,5)
        System.out.println(kDiffPairs(new int[]{1,3,1,5,4}, 0) + " (expected 1)");   // k=0: only (1,1)
        System.out.println(kDiffPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3) + " (expected 2)"); // (0,3),(6,9) → actually (0,3),(1,4)
        System.out.println(kDiffPairs(new int[]{1,1,1,1,1}, 0) + " (expected 1)");   // duplicates k=0

        System.out.println();
        System.out.println("-- kDiffPairsSorting (Two Pointers) --");
        System.out.println(kDiffPairsSorting(new int[]{3,1,4,1,5}, 2) + " (expected 2)");
        System.out.println(kDiffPairsSorting(new int[]{1,2,3,4,5}, 1) + " (expected 4)");
        System.out.println(kDiffPairsSorting(new int[]{1,3,1,5,4}, 0) + " (expected 1)");
        System.out.println(kDiffPairsSorting(new int[]{1,1,1,1,1}, 0) + " (expected 1)");

        System.out.println();
        System.out.println("-- kDifferencePairs (actual pairs) --");
        for (int[] p : kDifferencePairs(new int[]{3,1,4,1,5}, 2))
            System.out.println(Arrays.toString(p));  // [1,3] [3,5]
    }
}
