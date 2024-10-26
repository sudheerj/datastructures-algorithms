package java1.algorithms.hashmap.duplicates;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Duplicates {

    private static List<Integer> findDuplicates(int[] nums){
        Map<Integer, Integer> numsCount = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (Integer num : nums) {
            numsCount.put(num, (numsCount.getOrDefault(num, 0)) +1);
        }

        for (Entry<Integer, Integer> entry : numsCount.entrySet()) {
            if(entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        /**---------------
         No Duplicates
        --------------- */
        System.out.println("Input: [6, 5, 4, 3, 2, 1]");
        System.out.println(findDuplicates(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println("---------------");

        /**---------------
         Single Duplicate
        --------------- */
        System.out.println("Input: [6, 5, 5, 4, 3, 2, 1]");
        System.out.println(findDuplicates(new int[]{6, 5, 5, 4, 3, 2, 1}));
        System.out.println("---------------");

        /**---------------
         Multiple Duplicates
        --------------- */
        System.out.println("Input: [5, 4, 4, 4, 3, 2, 1, 4, 2]");
        System.out.println(findDuplicates(new int[]{5, 4, 4, 4, 3, 2, 1, 4, 2}));
        System.out.println("---------------");
    }
}
