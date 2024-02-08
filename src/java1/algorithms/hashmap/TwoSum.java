// TC: O(n), SC: O(n)
import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        int[] array = new int[]{3, 8, 13, 12, 9};
        System.out.println(Arrays.toString(twoSum(array, 15)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] indices = new int[2];
        if(len < 2) return indices;

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for(int i=0; i< len; i++) {
            int compliment = target - nums[i];
            if(hashmap.containsKey(compliment)) {
                indices[0] = hashmap.get(compliment);
                indices[1] = i;
            }
            hashmap.put(nums[i], i);
        }
        return indices;
    }
}