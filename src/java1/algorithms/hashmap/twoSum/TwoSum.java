// TC: O(n), SC: O(n)
import java.util.*;

class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) return new int[]{};
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0; i< nums.length; i++) {
            int compliment = target - nums[i];
            if(indexMap.containsKey(compliment)) {
                return new int[] {indexMap.get(compliment), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{3, 8, 13, 12, 9};
        System.out.println(Arrays.toString(twoSum(array1, 15)));
        int[] array2 = new int[]{4, 4};
        System.out.println(Arrays.toString(twoSum(array2, 8)));
    }

}