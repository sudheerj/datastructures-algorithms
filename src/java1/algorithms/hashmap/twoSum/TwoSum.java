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

        // Unique Numbers
        int[] array1 = new int[]{3, 4, 9, 14};
        System.out.println("Input: [3, 4, 9, 14], Target: 12");
        System.out.println("Output: " + Arrays.toString(twoSum(array1, 12)));

        // Duplicate Numbers
        int[] array2 = new int[]{5, 7, 4, 7};
        System.out.println("Input: [5, 7, 4, 7], Target: 14");
        System.out.println(Arrays.toString(twoSum(array2, 14)));

        // No sum Numbers
        int[] array3 = new int[]{7, 1, 13, 1};
        System.out.println("Input: [7, 1, 13, 1], Target: 10");
        System.out.println(Arrays.toString(twoSum(array3, 10)));

        // Negative Numbers
        int[] array4 = new int[]{-5, -4, -3, -1, -2};
        System.out.println("Input: [-5, -4, -3, -1, -2], Target: -10");
        System.out.println(Arrays.toString(twoSum(array4, -10)));

        // One number Array
        int[] array5 = new int[]{3};
        System.out.println("Input: [3], Target: 4");
        System.out.println(Arrays.toString(twoSum(array5, 4)));

        // Empty Array
        int[] array6 = new int[]{};
        System.out.println("Input: [], Target: 0");
        System.out.println(Arrays.toString(twoSum(array6, 0)));
    }

}