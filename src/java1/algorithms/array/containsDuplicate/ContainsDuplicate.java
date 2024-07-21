package containsDuplicate;
import java.util.*;

class ContainsDuplicate {
    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    private static boolean containsDuplicateUsingMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 8, 6, 4, 2, 6 };
        int[] nums2 = new int[] { 1, 3, 5, 7, 9 };

        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));

        System.out.println(containsDuplicateUsingMap(nums1));
        System.out.println(containsDuplicateUsingMap(nums2));
    }
}