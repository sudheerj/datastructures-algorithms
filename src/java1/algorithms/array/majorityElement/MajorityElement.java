package majorityElement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    //Boyer Moore Voting algorithm TC: O(n) SC: O(1)
    private static int majorityElement1(int[] nums){
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if(count == 0) {
                candidate = num;
            }

            count += num == candidate ? 1 : -1;
        }

        return candidate;
    }

    //Using frequency map TC: O(n) SC: O(1)
    private static int majorityElement2(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);

            if(freqMap.get(num) > (nums.length/2)) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5,4,5,5};
        int[] nums2 = new int[]{3,4,3,5,3,3,1,3};
        System.out.println(majorityElement1(nums1));
        System.out.println(majorityElement1(nums2));
        System.out.println(majorityElement2(nums1));
        System.out.println(majorityElement2(nums2));
    }
}
