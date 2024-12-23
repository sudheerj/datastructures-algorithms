package java1.algorithms.array.identicalPairs;

import java.util.HashMap;
import java.util.Map;

public class IdenticalPairs {
    private static int findIdenticalPairs(int[] nums){
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if(frequencyMap.containsKey(num)) {
                count += frequencyMap.get(num);
            }
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{6, 3, 1, 5, 3, 6, 5, 6};
        int[] nums2 = new int[]{2, 2, 2, 2};
        int[] nums3 = new int[]{1, 2, 3, 4};

        System.out.println(findIdenticalPairs(nums1));
        System.out.println(findIdenticalPairs(nums2));
        System.out.println(findIdenticalPairs(nums3));
    }
}
