package java1.algorithms.hashmap.longestConsecutiveSequence;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    // TC: O(2n) ~ O(n) SC: O(n)
    private static int longestConsecutiveSequence(int[]  nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int longestStreak = 0;

        for(int num: nums) {
            numSet.add(num);
        }

        for(int num: numSet) {
            //Check if left element exists to find the sequence
            if(!numSet.contains(num-1)) {
                int currentStreak = 1;
                while(numSet.contains(num+1)) {
                    currentStreak++;
                    num++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
            if(longestStreak > nums.length/2) break;
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums1 = {20, 4, 10, 1, 3, 2};
        int[] nums2 = {7, 0, 6, 2, 3, 1, 5, 4};
        System.out.println(longestConsecutiveSequence(nums1));
        System.out.println(longestConsecutiveSequence(nums2));
    }
}
